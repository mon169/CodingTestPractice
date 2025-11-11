// 일케 풀면 근데 NullPointer 오류 나긴함

package Stack;

import java.util.*;
import java.io.*;

public class B4949
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {

            String s = br.readLine();

            if (s.equals('.')) // . 찍으면 종료
            {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean balanced = true;

            for (char c : s.toCharArray()) // toCharArray() -> 이거 String을 문자열 배열로 반환해줌
            {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        balanced = false;
                        break;
                    }
                    stack.pop();

                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        balanced = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (balanced && stack.isEmpty()) // 둘다 같다는 전제하
            {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}