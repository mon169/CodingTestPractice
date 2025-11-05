package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10828 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: 명령어 개수 N
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            // 한 줄 읽기 (예: "push 3" 또는 "top")
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken(); // 첫 단어는 명령어

            // 명령어에 따라 분기
            switch (command) {
                case "push":
                    // push 명령에는 두 번째 값이 존재함
                    int value = Integer.parseInt(st.nextToken());
                    stack.push(value);
                    break;

                case "pop":
                    if (stack.isEmpty()) System.out.println(-1);
                    else System.out.println(stack.pop());
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;

                case "top":
                    if (stack.isEmpty()) System.out.println(-1);
                    else System.out.println(stack.peek());
                    break;
            }
        }
    }
}