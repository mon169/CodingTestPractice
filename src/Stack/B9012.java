package Stack;

import java.io.*;
import java.util.*;

public class B9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String s = br.readLine();

            // 종료 조건

            Stack<Character> stack = new Stack<>();
            boolean balanced = true; // 기본값 true

            for (char c : s.toCharArray())
            {
                if (c == '(' || c == '[')
                {
                    stack.push(c);
                }
                else if (c == ')')
                {
                    if (stack.isEmpty() || stack.peek() != '(')
                    {
                        balanced = false;
                        break;
                    }
                    stack.pop();
                }
                else if (c == ']')
                {
                    if (stack.isEmpty() || stack.peek() != '[')
                    {
                        balanced = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (balanced && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}