package Queue;

import java.util.*;
import java.io.*;

public class B2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            q.addLast(i);
        }

        while (q.size() > 1) {
            q.pollFirst();          // 맨 위 카드 버리기
            q.addLast(q.pollFirst());  // 다음 카드 뒤로 보내기
        }

        System.out.println(q.peekFirst());
    }
}
