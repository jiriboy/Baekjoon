import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        LinkedList<Shark> shark = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    shark.add(new Shark(i, j, 2, 0, 0));
                    map[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        int answer = 0;

        while (!shark.isEmpty()) {
            Collections.sort(shark);
            Shark s = shark.poll();

            if (map[s.x][s.y] > s.m) {
                continue;
            }

            if (map[s.x][s.y] > 0 && map[s.x][s.y] < s.m) {
                answer = Math.max(answer, s.d);
                s.e++;

                if (s.e == s.m) {
                    s.m++;
                    s.e = 0;
                }

                shark.clear();
                shark.add(s);
                visited = new boolean[N][N];
                visited[s.x][s.y] = true;
                map[s.x][s.y] = 0;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int x = s.x + dx[i];
                int y = s.y + dy[i];

                if (x < 0 || x >= N || y < 0 || y >= N) {
                    continue;
                }

                if (!visited[x][y]) {
                    visited[x][y] = true;
                    shark.add(new Shark(x, y, s.m, s.e, s.d + 1));
                }
            }
        }

        bw.write(Integer.toString(answer));
        bw.close();
        br.close();
    }

    static class Shark implements Comparable<Shark> {
        int x;
        int y;
        int m;
        int e;
        int d;

        Shark(int x, int y, int m, int e, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Shark s) {
            if (this.d != s.d) {
                return this.d - s.d;
            } else if (this.x != s.x) {
                return this.x - s.x;
            } else {
                return this.y - s.y;
            }
        }
    }
}
