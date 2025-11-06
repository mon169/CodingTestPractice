package Stack;

import java.io.*;
import java.util.*;

public class B2493 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 탑의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>(); // Stack은 제네릭(Generic) 클래스라서, 안에 어떤 타입을 담을지 지정해야 함
		// int[]는 정수형 배열,
        // 여기서 stack은 int 배열을 요소로 갖는 스택이 됨
        // 즉, stack.push(new int[]{i, height}); → [번호, 높이] 한 쌍을 스택에 넣는 것

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            // 자신보다 낮은 탑들은 pop (자신에게 막히니까)
            while (!stack.isEmpty() && stack.peek()[1] < height) {
                stack.pop();
            }

            // 비어있으면 왼쪽에 더 높은 탑이 없음 → 0
            if (stack.isEmpty()) {
                sb.append("0 ");
            } else {
                // 스택의 top이 바로 신호 수신자
                sb.append(stack.peek()[0]).append(" ");
            }

            // 현재 탑을 스택에 push
            stack.push(new int[]{i, height});
        }

        System.out.println(sb);
    }
}
