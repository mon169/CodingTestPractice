package BFS;

import java.util.*;
import java.io.*;

public class B2178 {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) 
        {
            String line = br.readLine();
            for (int j = 0; j < M; j++) 
            {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    }

    static int bfs(int startX, int startY) 
    {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        // 시작 위치 칸 수는 1로 간주
        int[][] distance = new int[N][M];
        distance[startX][startY] = 1;

        while (!q.isEmpty()) 
        {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == N - 1 && y == M - 1) 
            {
                return distance[x][y];
            }

            for (int d = 0; d < 4; d++) 
            {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (!visited[nx][ny] && maze[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        // 항상 도착 가능한 입력만 주어진다고 되어 있음
        return -1;
    }
}
