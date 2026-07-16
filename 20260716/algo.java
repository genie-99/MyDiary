import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {

    // 주어진 교환 횟수
    static int exchangeLimit;

    // 최종 최댓값
    static int answer;

    // 이미 확인한 상태를 저장
    static Set<String> visited;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {

            // 숫자를 문자열로 입력받은 뒤 char 배열로 변환
            char[] numbers = sc.next().toCharArray();

            // 교환 횟수
            exchangeLimit = sc.nextInt();

            answer = 0;
            // 이미 확인한 상태를 저장하는 Set 초기화 
            // HashSet은 중복을 허용하지 않는 자료구조.
            visited = new HashSet<>();

            // 교환 횟수 0번부터 DFS 시작
            dfs(numbers, 0);

            System.out.println("#" + testCase + " " + answer);
        }

        sc.close();
    }

    /**
     * @param numbers 현재 숫자 배열
     * @param count   현재까지 교환한 횟수
     */
    static void dfs(char[] numbers, int count) {

        String currentNumber = new String(numbers);

        /*
         * 같은 숫자라도 교환 횟수가 다르면 다른 상태이다.
         *
         * 예:
         * 123을 1번 교환한 상태
         * 123을 2번 교환한 상태
         *
         * 두 상태는 앞으로 남은 교환 횟수가 다르다.
         */
        String state = count + ":" + currentNumber;

        // 이미 확인한 상태라면 더 탐색하지 않는다.
        if (visited.contains(state)) {
            return;
        }

        visited.add(state);

        // 정확히 주어진 횟수만큼 교환했다면
        if (count == exchangeLimit) {

            int result = Integer.parseInt(currentNumber);

            answer = Math.max(answer, result);

            return;
        }

        /*
         * 서로 다른 두 위치를 모두 선택한다.
         *
         * i = 첫 번째 위치
         * j = 두 번째 위치
         */
        for (int i = 0; i < numbers.length - 1; i++) {

            for (int j = i + 1; j < numbers.length; j++) {

                // 1. 두 자리 교환
                swap(numbers, i, j);

                // 2. 다음 교환으로 이동
                dfs(numbers, count + 1);

                // 3. 원래 상태로 복구
                swap(numbers, i, j);
            }
        }
    }

    /**
     * 배열의 두 위치를 교환하는 메서드
     */
    static void swap(char[] numbers, int i, int j) {

        char temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}