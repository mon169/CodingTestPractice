package Array;

import java.util.*;
import java.io.*;


/*
JAVA에서 입력방식은 Scanner와 BufferedReader가 있다.
 Scanner를 통해 입력을 받을경우 Space Enter를 모두 경계로 인식하기에 입력받은 데이터를 가공하기 매우 편리
But! BufferedReader는 Enter만 경계로 인식하고 받은 데이터는 String으로 입력을 받기 때문에 가공을 해야하는 작업이 필요
하지만 작업속도 차이가 많이 나기 때문에 BufferedReader를 이용하여 입력 받는 것이 훨씬 효율적
 */

public class B10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /* BufferedReader의 readLine() 메소드를 사용하여 표준 입력에서 한 줄의 문자열을 읽어옴,
        사용자가 엔터를 입력하기 전까지의 모든 문자열을 한 번에 읽어옴
         */

        // 그리고 Integer.parseInt()를 사용하여 읽어온 문자열을 정수로 변환하여 int 타입 변수 N에 저장

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int i=0;
        while(i<N)
        {

            int K = Integer.parseInt(br.readLine());
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            if (st1.equals("push"))
            {
                stack.push(K);
            }

            if (st1.equals("top"))
            {
                System.out.println(stack.peek());
            }

            if (st1. equals("pop"))
            {
                stack.pop();
            }

            if (st1. equals("size"))
            {
                System.out.println(stack.size());
            }

            if (st1. equals("empty"))
            {
                if (!stack.isEmpty())
                {
                    System.out.println(1);
                }
                else
                    System.out.println(0);
            }
        }



    }
}
