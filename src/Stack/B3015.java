package Stack;

import java.io.*;
import java.util.*;

public class B3015 {

    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사람 수

        Stack<int[]> stack = new Stack<>(); // int[0] = height, int[1] = count
        long answer = 0; // 쌍의 개수 (많아질 수 있으므로 long)

        for (int i = 0; i < N; i++)
        {
            int h = Integer.parseInt(br.readLine()); // 현재 사람 키
            int sameCount = 1; // 같은 키 연속 개수 (기본값: 자기 자신 1명)

            // 현재 키 h가 스택 top보다 큰 경우: 작은 사람들 pop
            while (!stack.isEmpty() && stack.peek()[0] < h)
            {
                answer += stack.peek()[1]; // 작은 사람들은 현재 사람과 모두 볼 수 있음
                stack.pop();                // 가려졌으므로 스택에서 제거
            }

            // 현재 키 h가 스택 top과 같은 경우
            if (!stack.isEmpty() && stack.peek()[0] == h)
            {
                int[] top = stack.pop();     // 같은 키 그룹 꺼내기
                answer += top[1];            // 같은 키끼리 서로 볼 수 있음
                sameCount = top[1] + 1;      // 그룹 합치기

                // 아직 스택에 더 큰 사람이 남아 있다면, 그 사람과도 서로 볼 수 있음
                if (!stack.isEmpty()) answer++;
            }
            // 현재 키 h가 스택 top보다 작은 경우 (top이 더 큼)
            else if (!stack.isEmpty())
            {
                answer++; // 바로 앞의 큰 사람과는 서로 볼 수 있음
            }

            // 현재 사람 push (height, count)
            stack.push(new int[]{h, sameCount});
        }

        // 결과 출력
        System.out.println(answer);
    }
}