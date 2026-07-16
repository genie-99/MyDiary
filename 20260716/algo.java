/**
 * SWEA 1244 최대 상금
 * 
 * @author minchoba
 * 
 *  Sketch Idea
 *  1. 입력받은 숫자를 문자열로 변환 후, 각 자리수를 배열에 저장
 *  2. n번 만큼 반복하며, 현재 자리수 이후의 숫자 중 가장 큰 수를 찾아서 교환
 *  3. 교환 후, 배열을 다시 문자열로 변환하여 출력
 *
 */

import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int input = sc.nextInt();
            int n = sc.nextInt();
            

            /*String str = String.valueOf(input);
            int[] inputArr = new int[str.length()];

            for (int i = 0; i < inputArr.length; i++) {
                inputArr[i] = str.charAt(i) - '0';
            }

            for (int i = 0; i < n && i < inputArr.length; i++) {
                int max = inputArr[i];
                int index = i;

                for (int j = inputArr.length - 1; j > i; j--) {
                    if (max < inputArr[j]) {
                        max = inputArr[j];
                        index = j;
                    }
                }

                // 더 큰 숫자를 찾았을 때만 교환
                if (index != i) {
                    int temp = inputArr[i];
                    inputArr[i] = inputArr[index];
                    inputArr[index] = temp;
                }
            }

            StringBuilder result = new StringBuilder();

            for (int digit : inputArr) {
                result.append(digit);
            }
            */

            System.out.println("#" + test_case + " " + result);
        }

    }
}