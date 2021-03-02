import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        int[][] group_1 = new int[N][N];
        int[][] group_2 = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer_1 = 0;
        int answer_2 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (group_1[i][j] == 0) {
                    LinkedList<Color> queue = new LinkedList<>();
                    queue.add(new Color(i, j, map[i][j]));

                    answer_1++;
                    group_1[i][j] = answer_1;

                    while (!queue.isEmpty()) {
                        Color c = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int x = c.x + dx[k];
                            int y = c.y + dy[k];

                            if (x < 0 || x >= N || y < 0 || y >= N) {
                                continue;
                            }

                            if (group_1[x][y] == 0 && map[x][y] == c.c) {
                                group_1[x][y] = answer_1;
                                queue.add(new Color(x, y, map[x][y]));
                            }
                        }
                    }
                }

                if (group_2[i][j] == 0) {
                    LinkedList<Color> queue = new LinkedList<>();
                    queue.add(new Color(i, j, map[i][j]));

                    answer_2++;
                    group_2[i][j] = answer_2;

                    while (!queue.isEmpty()) {
                        Color c = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int x = c.x + dx[k];
                            int y = c.y + dy[k];

                            if (x < 0 || x >= N || y < 0 || y >= N) {
                                continue;
                            }

                            if ((group_2[x][y] == 0) && (map[x][y] == c.c || (map[x][y] == 'R' && c.c == 'G') || (map[x][y] == 'G' && c.c == 'R'))) {
                                group_2[x][y] = answer_2;
                                queue.add(new Color(x, y, map[x][y]));
                            }
                        }
                    }
                }
            }
        }

        bw.write(answer_1 + " " + answer_2);
        bw.close();
        br.close();
    }

    static class Color {
        int x;
        int y;
        char c;

        Color(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
}
