import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        int[][] shortest = new int[R][C];

        LinkedList<Coordinate> queue = new LinkedList<>();

        int hx = 0;
        int hy = 0;

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'S') {
                    hx = i;
                    hy = j;
                }

                if (map[i][j] == '*') {
                    queue.add(new Coordinate(i, j, 0));
                    shortest[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            Coordinate w = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = w.x + dx[i];
                int y = w.y + dy[i];

                if (x < 0 || x >= R || y < 0 || y >= C) {
                    continue;
                }

                if (map[x][y] == 'X' || map[x][y] == 'D') {
                    continue;
                }

                if (shortest[x][y] == 0) {
                    shortest[x][y] = w.t + 1;
                    queue.add(new Coordinate(x, y, w.t + 1));
                }
            }
        }

        int answer = 0;
        boolean[][] visited = new boolean[R][C];

        queue = new LinkedList<>();
        queue.add(new Coordinate(hx, hy, 0));
        visited[hx][hy] = true;

        while (!queue.isEmpty()) {
            Coordinate h = queue.poll();

            if (map[h.x][h.y] == 'D') {
                answer = h.t;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int x = h.x + dx[i];
                int y = h.y + dy[i];

                if (x < 0 || x >= R || y < 0 || y >= C) {
                    continue;
                }

                if (map[x][y] == 'X' || visited[x][y]) {
                    continue;
                }

                if (shortest[x][y] == 0 || shortest[x][y] > h.t + 1) {
                    visited[x][y] = true;
                    queue.add(new Coordinate(x, y, h.t + 1));
                }
            }
        }

        if (answer == 0) {
            bw.write("KAKTUS");
        } else {
            bw.write(Integer.toString(answer));
        }

        bw.close();
        br.close();
    }

    static class Coordinate {
        int x;
        int y;
        int t;

        Coordinate(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
}
