package BFS;

import java.io.*;
import java.util.*;

public class B1926 
{
    static int n, m;
    static int[][] board;
    static boolean[][] visited;

    // 상, 하, 좌, 우 이동
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        // 그림 데이터 입력
        for (int i = 0; i < n; i++) 
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) 
            {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;     // 그림 개수
        int maxArea = 0;   // 그림 중 가장 큰 넓이

        // 전체 탐색
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < m; j++) 
            {
                if (board[i][j] == 1 && !visited[i][j]) 
                {
                    count++; // 새로운 그림 발견
                    int area = bfs(i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        // 출력
        System.out.println(count);
        System.out.println(maxArea);
    }

    // BFS로 그림의 넓이 구하기
    static int bfs(int x, int y) 
    {
        Queue<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});

        int area = 1;

        while (!q.isEmpty()) 
        {
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];

            for (int dir = 0; dir < 4; dir++) 
            {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                // 범위 벗어남
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 이미 방문했거나 그림이 아님
                if (visited[nx][ny] || board[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                area++;
            }
        }
        return area;
    }
}
