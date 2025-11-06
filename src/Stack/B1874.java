package Stack;

import java.io.*;
import java.util.*;

public class B1874 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력 기록용 (+, -)

        int n = Integer.parseInt(br.readLine()); // 수열의 길이 입력
        Stack<Integer> stack = new Stack<>();

        int current = 1; // 다음에 push할 숫자
        boolean possible = true; // 수열 생성 가능 여부

        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine()); // 현재 만들고자 하는 숫자

            // target이 나올 때까지 push
            while (current <= target) {
                stack.push(current++);
                sb.append("+\n");
            }

            // 스택의 맨 위가 target이면 pop
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                // 스택 top이 target이 아니면 불가능한 수열
                possible = false;
                break;
            }
        }

        // 결과 출력
        if (possible) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }
}