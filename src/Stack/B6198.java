package Stack;

import java.io.*;
import java.util.*;

public class B6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long result = 0L;                  // 총 볼 수 있는 빌딩 수 합
        Stack<Integer> stack = new Stack<>(); // 빌딩 높이들을 저장할 스택

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());

            // 현재 height보다 작거나 같은 높이는 스택에서 제거
            while (!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }

            // 스택에 남아 있는 만큼 현재 빌딩이 볼 수 있는 빌딩 수
            result += stack.size();

            // 현재 빌딩을 후보로 스택에 추가
            stack.push(height);
        }

        System.out.println(result);
    }
}