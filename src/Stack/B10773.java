package Stack;

import java.io.*;
import java.util.*;

public class B10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine()); // 입력 개수

        while (K > 0) {
            String line = br.readLine();

            // 공백이나 빈 줄일 경우 건너뛰기
            if (line == null || line.trim().isEmpty()) {
                continue;
            }

            int num = Integer.parseInt(line.trim());
            K--;

            if (num == 0) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(num);
            }
        }

        int sum = 0;
        for (int n : stack) sum += n;

        System.out.println(sum);
    }
}