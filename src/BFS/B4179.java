package BFS;

import java.util.*;
import java.io.*;

public class B4179 
{
	static int R, C;
    static char[][] map;
    static int[][] fireDist;     // 불이 각 칸에 도달하는 최소 시간
    static int[][] jihunDist;    // 지훈이가 각 칸에 도달하는 최소 시간
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fireDist = new int[R][C];
        jihunDist = new int[R][C];

        for (int i = 0; i < R; i++) 
        {
            String line = br.readLine();
            for (int j = 0; j < C; j++) 
            {
                map[i][j] = line.charAt(j);
                fireDist[i][j] = -1;
                jihunDist[i][j] = -1;
            }
        }

        Queue<int[]> fireQ = new ArrayDeque<>();
        Queue<int[]> jihunQ = new ArrayDeque<>();

        // 초기 위치 설정
        for (int i = 0; i < R; i++) 
        {
            for (int j = 0; j < C; j++) 
            {
                if (map[i][j] == 'F') 
                {
                    fireQ.offer(new int[]{i, j});
                    fireDist[i][j] = 0;
                }
                if (map[i][j] == 'J') 
                {
                    jihunQ.offer(new int[]{i, j});
                    jihunDist[i][j] = 0;
                }
            }
        }

        // 불 확산 BFS
        while (!fireQ.isEmpty()) 
        {
            int[] cur = fireQ.poll();
            int x = cur[0], y = cur[1];
            for (int d = 0; d < 4; d++) 
            {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (map[nx][ny] == '#' || fireDist[nx][ny] != -1) continue;
                fireDist[nx][ny] = fireDist[x][y] + 1;
                fireQ.offer(new int[]{nx, ny});
            }
        }

        // 지훈이 이동 BFS
        while (!jihunQ.isEmpty()) 
        {
            int[] cur = jihunQ.poll();
            int x = cur[0], y = cur[1];
            // 가장자리에 도달하면 탈출 성공
            if (x == 0 || x == R-1 || y == 0 || y == C-1) 
            {
                System.out.println(jihunDist[x][y] + 1);
                return;
            }
            for (int d = 0; d < 4; d++) 
            {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (map[nx][ny] == '#' || jihunDist[nx][ny] != -1) continue;
                // 불이 해당 칸에 이미 도달했거나, 지훈이가 그 칸에 도달하는 시간 >= 불이 도달하는 시간일 경우 이동 불가
                if (fireDist[nx][ny] != -1 && fireDist[nx][ny] <= jihunDist[x][y] + 1) continue;
                jihunDist[nx][ny] = jihunDist[x][y] + 1;
                jihunQ.offer(new int[]{nx, ny});
            }
        }

        // 탈출 불가능한 경우
        System.out.println("IMPOSSIBLE");
    }
}
