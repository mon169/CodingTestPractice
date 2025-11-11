// 근데 이렇게하면 시간초과됨 시간 복잡도가 O(n^2)
package Stack;

import java.util.*;
import java.io.*;

public class B1874 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();


        int current = 1; // 1부터 push하기 위한 변수
        boolean possible = true;

        while (n-- > 0)
        {
            while (current <= n)
            {
                stack.push(current++);
                sb.append("+\n");
            }
            // 스택 맨 위가 n이면 pop
            if (stack.peek() == n) {
                stack.pop();
                sb.append("-\n");
            } else {
                // 불가능한 경우
                possible = false;
                break;
            }

            if (possible) System.out.print(sb);
            else System.out.println("NO");
        }

    }
}