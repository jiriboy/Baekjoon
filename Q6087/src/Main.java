import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        char[][] map = new char[H][W];
        int[][] min = new int[H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                min[i][j] = -1;
            }
        }

        int start_x = -1;
        int start_y = -1;
        int end_x = -1;
        int end_y = -1;

        for (int i = 0; i < H; i++) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'C') {
                    if (start_x < 0 && start_y < 0) {
                        start_x = i;
                        start_y = j;
                    } else {
                        end_x = i;
                        end_y = j;
                    }
                }
            }
        }

        LinkedList<Laser> queue = new LinkedList<>();

        min[start_x][start_y] = 0;

        for (int i = 0; i < 4; i++) {
            if (start_x + dx[i] < 0 || start_x + dx[i] >= H || start_y + dy[i] < 0 || start_y + dy[i] >= W) {
                continue;
            }

            if (map[start_x + dx[i]][start_y + dy[i]] == '*') {
                continue;
            }

            min[start_x + dx[i]][start_y + dy[i]] = 0;
            queue.add(new Laser(start_x + dx[i], start_y + dy[i], 0, i));
        }

        while (!queue.isEmpty()) {
            Laser l = queue.poll();

            for (int i = 0; i < 4; i++) {
                if (l.b == (i + 2) % 4) {
                    continue;
                }

                int x = l.x + dx[i];
                int y = l.y + dy[i];

                if (x < 0 || x >= H || y < 0 || y >= W) {
                    continue;
                }

                if (map[x][y] == '*') {
                    continue;
                }

                if (l.b == i) {
                    if (min[x][y] != -1 && min[x][y] < l.c) {
                        continue;
                    }

                    min[x][y] = l.c;
                    queue.add(new Laser(x, y, l.c, i));
                } else {
                    if (min[x][y] != -1 && min[x][y] < l.c + 1) {
                        continue;
                    }

                    min[x][y] = l.c + 1;
                    queue.add(new Laser(x, y, l.c + 1, i));
                }
            }
        }

        bw.write(Integer.toString(min[end_x][end_y]));
        bw.close();
        br.close();
    }

    static class Laser {
        int x;
        int y;
        int c;
        int b;

        Laser(int x, int y, int c, int b) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.b = b;
        }
    }
}
