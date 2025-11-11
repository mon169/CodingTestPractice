package Stack;

import java.util.*;
import java.io.*;

public class B10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();



        while (n-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command)
            {
                case "push" :
                {
                    int value = Integer.parseInt(st.nextToken());
                    System.out.println(stack.push(value));
                    break;
                }
                case "pop" :
                {
                    if(stack.isEmpty())
                    {
                        System.out.println(-1);
                        break;
                    }
                    else
                    {
                        System.out.println(stack.pop());
                        break;
                    }
                }
                case "size" :
                {
                    System.out.println(stack.size());
                    break;
                }
                case "empty" :
                {
                    if (!stack.isEmpty())
                    {
                        System.out.println(1);
                        break;
                    }
                    else
                    {
                        System.out.println(0);
                        break;
                    }
                }
                case "top" : {
                    if (!stack.isEmpty())
                    {
                        System.out.println(stack.peek());
                        break;
                    }
                    else
                    {
                        System.out.println(-1);
                        break;
                    }
                }
            }
        }

    }
}