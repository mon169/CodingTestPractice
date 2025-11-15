package BFS;

import java.util.*;
import java.io.*;

public class B7576 
{
    static int M, N;
    static int[][] box;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) 
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) 
            {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) 
                {
                    // 익은 토마토 위치 큐에 삽입
                    q.offer(new int[]{i, j});
                }
            }
        }

        bfs(q);

        int result = 0;
        for (int i = 0; i < N; i++) 
        {
            for (int j = 0; j < M; j++) 
            {
                if (box[i][j] == 0) 
                {
                    // 익지 않은 토마토 있음 → 불가능
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, box[i][j]);
            }
        }

        // 처음 익은 건 1부터 시작했으므로 –1 해준다
        System.out.println(result - 1);
    }

    static void bfs(Queue<int[]> q) 
    {
        while (!q.isEmpty()) 
        {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) 
            {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (box[nx][ny] != 0) continue;

                box[nx][ny] = box[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
