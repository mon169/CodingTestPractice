package Stack;
import java.util.*;
import java.io.*;

public class B10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();  // 괄호 문자열 한 줄 입력

        Stack<Character> stack = new Stack<>();
        int count = 0;
        int index = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else { // ')'
                stack.pop();

                if (s.charAt(index - 1) == '(') { // 바로 앞이 '('면 레이저
                    count += stack.size();
                } else { // 쇠막대기 끝
                    count += 1;
                }
            }
            index++;
        }
        System.out.println(count);
    }
}

