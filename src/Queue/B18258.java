package Queue;

import java.util.*;
import java.io.*;

public class B18258 {
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        int last = -1;  // 큐에 들어간 가장 최근 값

        for (int i = 0; i < N; i++) 
        {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            String cmd = st.nextToken();

            switch (cmd) 
            {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    queue.addLast(x);
                    last = x;
                    break;

                case "pop":
                    if (queue.isEmpty()) 
                    {
                        sb.append(-1).append('\n');
                    } else 
                    {
                        sb.append(queue.removeFirst()).append('\n');
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
                        sb.append(queue.peekFirst()).append('\n');
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
                    // 예상되지 않은 명령어
                    break;
            }
        }
        System.out.print(sb.toString());
    }
}
