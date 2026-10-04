import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

class seat {

    // 좌석 상태
    static final int a = 0; // 사용 가능
    static final int u = 1; // 사용 중
    static final int b = 2; // 고장

    // 0번은 사용하지 않고 1~44번 PC 사용
    static ArrayList<Integer> seat = new ArrayList<>(Collections.nCopies(45, a));

    static String[] userName = new String[45];
    static long[] startTime = new long[45];
    static long[] endTime = new long[45];

    static ArrayList<String> seat_label = new ArrayList<>(Collections.nCopies(45, ""));

    // 현재 좌석 정보
    static String filePath = "C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\seat.txt";

    // 이용 기록
    static String historyFilePath = "C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\h_seat.txt";

    // 통계
    static long[] time = new long[45];   // 누적 사용 시간(ms)
    static int[] count = new int[45];    // 사용 횟수
    static long historyStart = 0;        // 통계 시작 시각

    // =========================================================
    // 기본 좌석 기능
    // =========================================================

    public seat() {
        seat_one();

        // 타이머가 실행되지 않은 경우 시작
        if (!timer.isRunning()) {
            timer.start();
        }
    }

    public void seat_one() {
        for (int i = 1; i <= 44; i++) {
            setSeatLabel(i);
        }
    }

    static int availableCount() {
        int cnt = 0;

        for (int i = 1; i <= 44; i++) {
            if (seat.get(i) == a) {
                cnt++;
            }
        }

        return cnt;
    }

    static int findUserSeat(String name) {
        if (name == null) {
            return -1;
        }

        for (int i = 1; i <= 44; i++) {
            if (seat.get(i) == u && name.equals(userName[i])) {
                return i;
            }
        }

        return -1;
    }

    static String status(int pc) {
        if (pc < 1 || pc > 44) {
            return "잘못된 좌석";
        }

        if (seat.get(pc) == a) {
            return "사용 가능";
        }

        if (seat.get(pc) == u) {
            return "사용 중";
        }

        return "고장";
    }

    static void setSeatLabel(int index) {
        String path = "C:\\Users\\user\\OneDrive\\Desktop\\학교과제\\2-1\\AI기초프로젝트\\레벨_01\\";

        if (seat.get(index) == a) {
            seat_label.set(index, path + "초록.png");
        } else if (seat.get(index) == u) {
            seat_label.set(index, path + "빨강.png");
        } else {
            seat_label.set(index, path + "회색.png");
        }
    }

    static void updateSeatImages(int index) {
        setSeatLabel(index);

        if (GUI_00.g3 != null) {
            GUI_00.g3.updateSeatImage(index);
        }

        if (GUI_00.g2_1 != null) {
            GUI_00.g2_1.updateSeatImage(index);
        }

        if (GUI_00.g1_0 != null) {
            GUI_00.g1_0.updateSeatImage(index);
        }
    }

    // =========================================================
    // 예약 / 사용 종료
    // =========================================================

    static void checkUser(String name, int minutes) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("먼저 로그인해주세요.");
        }

        if (minutes < 1 || minutes > 90) {
            throw new IllegalArgumentException("사용 시간은 1~90분입니다.");
        }

        if (findUserSeat(name) != -1) {
            throw new IllegalArgumentException("이미 사용 중인 좌석이 있습니다.");
        }

        if (isWaiting(name)) {
            throw new IllegalArgumentException("이미 대기 신청한 사용자입니다.");
        }
    }

    static void reserve(String name, int pc, int minutes) {
        checkEndTime();
        checkUser(name, minutes);

        if (pc < 1 || pc > 44) {
            throw new IllegalArgumentException("좌석을 선택해주세요.");
        }

        // 대기자가 있으면 대기자가 먼저 배정됨
        if (waitingCount() > 0) {
            throw new IllegalArgumentException( "기존 대기자가 우선입니다. 대기 신청을 이용해주세요.");
        }

        if (seat.get(pc) != a) {
            throw new IllegalArgumentException( "현재 사용 가능한 좌석이 아닙니다.");
        }

        start(name, pc, minutes);
        saveState();
        refreshPanels();
    }

    private static void start(String name, int pc, int minutes) {
        long now = System.currentTimeMillis();

        seat.set(pc, u);
        userName[pc] = name;
        startTime[pc] = now;
        endTime[pc] = now + minutes * 60_000L;

        updateSeatImages(pc);
    }

    static int endCurrentUser(String name) {
        checkEndTime();

        int pc = findUserSeat(name);

        if (pc == -1) {
            return -1;
        }

        finish(pc, System.currentTimeMillis(), a);
        assignWaiting();

        saveState();
        refreshPanels();

        return pc;
    }

    private static void finish(int pc, long now, int nextState) {
        String name = userName[pc];
        long start = startTime[pc];
        long end = endTime[pc];

        if (start > 0 && end > 0 && name != null && !name.isEmpty()) {
            long used = Math.max(0L, Math.min(now, end) - start);

            // h_seat.txt는 기존 형식대로 분 단위로 저장
            int minutes = (int)((used + 59_999L) / 60_000L);

            if (minutes > 0) {
                save_h(name, pc, minutes);
            }
        }

        seat.set(pc, nextState);
        userName[pc] = "";
        startTime[pc] = 0;
        endTime[pc] = 0;

        updateSeatImages(pc);
    }

    static void checkEndTime() {
        long now = System.currentTimeMillis();
        boolean changed = false;

        for (int i = 1; i <= 44; i++) {
            if (seat.get(i) == u && endTime[i] > 0 && endTime[i] <= now) {

                String name = userName[i];
                String loginName = "";

                if (GUI_00.g2 != null) {
                    loginName = GUI_00.g2.us_n();
                }

                // 현재 로그인한 사용자의 좌석이 끝난 경우만 팝업
                if (name != null && !name.trim().isEmpty() && name.equals(loginName)) {
                    JOptionPane.showMessageDialog( GUI_00.g2, name + "님의 PC" + i + " 사용 시간이 종료되었습니다.\n" + "좌석이 자동으로 사용 종료됩니다.", "사용 시간 종료", JOptionPane.WARNING_MESSAGE);
                }

                finish(i, endTime[i], a);
                changed = true;
            }
        }

        // 빈자리가 생기면 대기자 자동 배정
        if (assignWaiting()) {
            changed = true;
        }

        if (changed) {
            saveState();
            refreshPanels();
        }
    }

    static void markBroken(int pc) {
        if (pc < 1 || pc > 44) {
            throw new IllegalArgumentException("잘못된 좌석 번호입니다.");
        }

        if (seat.get(pc) == u) {
            finish(pc, System.currentTimeMillis(), b);
        } else {
            seat.set(pc, b);
            updateSeatImages(pc);
        }

        saveState();
        refreshPanels();
    }

    // =========================================================
    // 대기 기능
    // =========================================================

    static class wait {
        String name;
        boolean lesson; // true = 수업 참여자, false = 일반 사용자
        int minutes;

        wait(String name, boolean lesson, int minutes) {
            this.name = name;
            this.lesson = lesson;
            this.minutes = minutes;
        }
    }

    // Queue 자료구조 사용
    static Queue<wait> classQueue = new ArrayDeque<>();
    static Queue<wait> normalQueue = new ArrayDeque<>();

    static int waitingCount() {
        return classQueue.size() + normalQueue.size();
    }

    static boolean isWaiting(String name) {
        if (name == null) {
            return false;
        }

        for (wait w : classQueue) {
            if (name.equals(w.name)) {
                return true;
            }
        }

        for (wait w : normalQueue) {
            if (name.equals(w.name)) {
                return true;
            }
        }

        return false;
    }

    // 화면에 표시할 대기 목록
    // 수업 참여자 우선, 같은 유형 안에서는 먼저 신청한 순서
    static ArrayList<wait> waitingList() {
        ArrayList<wait> list = new ArrayList<>();

        list.addAll(classQueue);
        list.addAll(normalQueue);

        return list;
    }

    static int waitingNumber(String name) {
        int number = 1;

        for (wait w : classQueue) {
            if (name.equals(w.name)) {
                return number;
            }
            number++;
        }

        for (wait w : normalQueue) {
            if (name.equals(w.name)) {
                return number;
            }
            number++;
        }

        return -1;
    }

    static void joinWaiting(String name, boolean lesson, int minutes) {
        checkEndTime();
        checkUser(name, minutes);

        // 사용할 PC가 있으면 대기 신청하지 않음
        if (availableCount() > 0) {
            throw new IllegalArgumentException("빈 좌석이 있습니다. 좌석 신청을 이용해주세요.");
        }

        wait w = new wait(name, lesson, minutes);

        if (lesson) {
            classQueue.offer(w);
        } else {
            normalQueue.offer(w);
        }

        saveState();
        refreshPanels();
    }

    static void cancelWaiting(String name) {
        if (name == null) {
            return;
        }

        classQueue.removeIf(w -> name.equals(w.name));
        normalQueue.removeIf(w -> name.equals(w.name));

        saveState();
        refreshPanels();
    }

    // 빈 좌석이 생기면 대기자 자동 배정
    private static boolean assignWaiting() {
        boolean changed = false;
        while (availableCount() > 0 && waitingCount() > 0) {
            Queue<wait> queue;

            // 수업 참여자 우선
            if (!classQueue.isEmpty()) {
                queue = classQueue;
            } else {
                queue = normalQueue;
            }

            // Queue의 가장 앞 사람을 꺼냄
            wait w = queue.poll();

            int pc = recommendSeat();

            if (pc == -1) {
                // 이론상 거의 발생하지 않지만 안전하게 복원
                queue.offer(w);
                return changed;
            }

            start(w.name, pc, w.minutes);
            changed = true;
        }

        return changed;
    }

    // 대기자에게 배정할 PC
    // 사용 시간이 가장 적은 빈 PC를 선택
    static int recommendSeat() {
        int best = -1;
        long bestTime = Long.MAX_VALUE;
        long now = System.currentTimeMillis();

        for (int i = 1; i <= 44; i++) {
            if (seat.get(i) != a) {
                continue;
            }

            long t = usedMillis(i, now);

            if (best == -1 || t < bestTime) {
                best = i;
                bestTime = t;
            }
        }

        return best;
    }

    // =========================================================
    // seat.txt 저장 / 불러오기
    // =========================================================

    static void saveState() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 1; i <= 44; i++) {
                String name = userName[i];

                if (name == null) {
                    name = "";
                }

                // 새 형식: PC번호/상태/사용자/시작시간/종료시간
                writer.write(i + "/" + seat.get(i) + "/" + name + "/" + startTime[i] + "/" + endTime[i]);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void loadState() {
        File file = new File(filePath);

        // 기존 파일이 없으면 기본 상태로 시작하고 기록만 읽음
        if (!file.exists()) {
            loadHistory();
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] array = line.split("/", -1);

                if (array.length < 4) {
                    continue;
                }

                int index = Integer.parseInt(array[0]);
                int state = Integer.parseInt(array[1]);
                String name = array[2];

                if (index < 1 || index > 44) {
                    continue;
                }

                seat.set(index, state);
                userName[index] = name;

                // 기존 seat.txt: 번호/상태/사용자/종료시간
                if (array.length == 4) {
                    startTime[index] = 0;
                    endTime[index] = Long.parseLong(array[3]);
                }
                // 새 seat.txt: 번호/상태/사용자/시작시간/종료시간
                else {
                    startTime[index] = Long.parseLong(array[3]);
                    endTime[index] = Long.parseLong(array[4]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        loadHistory();
        checkEndTime();
    }

    // =========================================================
    // h_seat.txt 저장 / 불러오기
    // =========================================================

    static void save_h(String name, int pc, int minutes) {
        try (BufferedWriter writer = new BufferedWriter( new FileWriter(historyFilePath, true))) {
            long now = System.currentTimeMillis();

            // 기존 형식 유지: 사용자/PC/사용시간(분)/기록시간
            writer.write(name + "/" + pc + "/" + minutes + "/" + now);
            writer.newLine();

            time[pc] += minutes * 60_000L;
            count[pc]++;

            if (historyStart == 0) {
                historyStart = now;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void loadHistory() {
        Arrays.fill(time, 0);
        Arrays.fill(count, 0);
        historyStart = 0;

        File file = new File(historyFilePath);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] array = line.split("/", -1);

                if (array.length < 4) {
                    continue;
                }

                int pc = Integer.parseInt(array[1]);
                int minutes = Integer.parseInt(array[2]);
                long now = Long.parseLong(array[3]);

                if (pc < 1 || pc > 44 || minutes < 0) {
                    continue;
                }

                time[pc] += minutes * 60_000L;
                count[pc]++;

                if (historyStart == 0 || now < historyStart) {
                    historyStart = now;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 종료된 기록 + 현재 사용 중인 시간
    static long usedMillis(int pc, long now) {
        if (pc < 1 || pc > 44) {
            return 0;
        }

        long total = time[pc];

        if (seat.get(pc) == u && startTime[pc] > 0) {
            total += Math.max( 0L, Math.min(now, endTime[pc]) - startTime[pc]);
        }

        return total;
    }

    // 종료된 기록 + 현재 사용 중인 횟수
    static int useCount(int pc) {
        if (pc < 1 || pc > 44) {
            return 0;
        }

        if (seat.get(pc) == u && startTime[pc] > 0) {
            return count[pc] + 1;
        }

        return count[pc];
    }

    // 통계 시작 시간을 결정
    static long statsStart() {
        long start = historyStart;

        // 기록이 없으면 현재 사용 중인 PC의 가장 이른 시작시간 사용
        for (int i = 1; i <= 44; i++) {
            if (seat.get(i) == u && startTime[i] > 0) {
                if (start == 0 || startTime[i] < start) {
                    start = startTime[i];
                }
            }
        }

        return start;
    }

    // 좌석 사용률
    static double utilization(int pc, long now) {
        long start = statsStart();

        if (start == 0 || now <= start) {
            return 0;
        }

        double result = usedMillis(pc, now) * 100.0 / (now - start);

        return Math.min(100.0, result);
    }

    // 가장 많이 사용된 PC
    // byCount=true : 사용 횟수
    // byCount=false: 누적 사용 시간
    static int[] mostUsed(boolean byCount) {
        int best = -1;
        long value = Long.MIN_VALUE;
        long now = System.currentTimeMillis();

        for (int i = 1; i <= 44; i++) {
            long v = byCount ? useCount(i) : usedMillis(i, now);

            if (v > value) {
                value = v;
            }
        }

        // 2. 최댓값과 같은 좌석 개수 세기
        int count = 0;
        for (int i = 1; i <= 44; i++) {
            long v = byCount ? useCount(i) : usedMillis(i, now);
            if (v == value) {
                count++;
            }
        }

        // 3. 최댓값과 같은 좌석 번호 저장
        int[] result = new int[count];
        int index = 0;

        for (int i = 1; i <= 44; i++) {
            long v = byCount ? useCount(i) : usedMillis(i, now);
            if (v == value) {
                result[index++] = i;
            }
        }

        return result;
    }

    // 가장 적게 사용된 PC
    // byCount=true : 사용 횟수
    // byCount=false: 누적 사용 시간
    static int[] leastUsed(boolean byCount) {
        long value = Long.MAX_VALUE;
        long now = System.currentTimeMillis();

     // 1. 최솟값 찾기
        for (int i = 1; i <= 44; i++) {

            long v = byCount ? useCount(i) : usedMillis(i, now);

            if (v < value) {
                value = v;
            }
        }

        // 2. 최솟값과 같은 좌석 개수 세기
        int count = 0;

        for (int i = 1; i <= 44; i++) {

            long v = byCount ? useCount(i) : usedMillis(i, now);

            if (v == value) {
                count++;
            }
        }

        // 3. 최솟값과 같은 좌석 번호 저장
        int[] result = new int[count];
        int index = 0;

        for (int i = 1; i <= 44; i++) {

            long v = byCount ? useCount(i) : usedMillis(i, now);

            if (v == value) {
                result[index++] = i;
            }
        }

        return result;
    }

    // =========================================================
    // GUI 갱신
    // =========================================================

    static void refreshPanels() {
        if (GUI_00.g2 != null) {
            GUI_00.g2.recount();
        }

        if (GUI_00.wait != null && GUI_00.wait.isVisible()) {
            GUI_00.wait.refresh();
        }

        if (GUI_00.state != null && GUI_00.state.isVisible()) {
            GUI_00.state.refresh();
        }
    }

    static Timer timer = new Timer(1000, e -> checkEndTime());
}
