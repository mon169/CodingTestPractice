package Queue;

import java.util.*;
import java.io.*;

public class B10845 {
	public static void main(String[] args) throws IOException 
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        int last = -1;  // 큐의 가장 뒤(최근에 넣은 값)를 저장할 변수

        for (int i = 0; i < N; i++) 
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    queue.offer(x);
                    last = x;
                    break;

                case "pop":
                    if (queue.isEmpty()) 
                    {
                        sb.append(-1).append('\n');
                    } else 
                    {
                        sb.append(queue.poll()).append('\n');
                    }
                    break;

                case "size":
                    sb.append(queue.size()).append('\n');
                    break;

                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append('\n');
                    break;

                case "front":
                    if (queue.isEmpty()) 
                    {
                        sb.append(-1).append('\n');
                    } else 
                    {
                        sb.append(queue.peek()).append('\n');
                    }
                    break;

                case "back":
                    if (queue.isEmpty()) 
                    {
                        sb.append(-1).append('\n');
                    } else 
                    {
                        sb.append(last).append('\n');
                    }
                    break;

                default:
                    // 예상하지 못한 명령어 처리 (필요 시)
                    break;
            }
        }

        System.out.print(sb.toString());
    }
}
