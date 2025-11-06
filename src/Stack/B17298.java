package Stack;

import java.io.*;
import java.util.*;

public class B17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 수열 길이 입력

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N]; // 수열 저장

        for (int i = 0; i < N; i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N]; // 각 위치의 오큰수 저장
        Arrays.fill(result, -1); // 기본값 -1로 채움 (오큰수 없을 경우 대비)

        Stack<Integer> stack = new Stack<>(); // 인덱스 저장용 스택

        for (int i = 0; i < N; i++) {
            // 현재 값이 스택의 top 인덱스가 가리키는 값보다 크면
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int idx = stack.pop();   // 해당 인덱스 꺼내고
                result[idx] = arr[i];    // 현재 값이 그 인덱스의 오큰수
            }
            // 현재 인덱스 push
            stack.push(i);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(result[i]).append(" ");
        System.out.println(sb);
    }
}