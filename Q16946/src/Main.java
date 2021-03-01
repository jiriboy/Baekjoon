import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[][] group = new int[N][M];
        int[] members = new int[N * M + 1];
        int group_num = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '1' || group[i][j] != 0) {
                    continue;
                }

                LinkedList<Point> queue = new LinkedList<>();

                group_num++;
                members[group_num] = 1;
                group[i][j] = group_num;
                queue.add(new Point(i, j));

                while (!queue.isEmpty()) {
                    Point p = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int x = p.x + dx[k];
                        int y = p.y + dy[k];

                        if (x < 0 || x >= N || y < 0 || y >= M) {
                            continue;
                        }

                        if (map[x][y] == '0' && group[x][y] == 0) {
                            members[group_num]++;
                            group[x][y] = group_num;
                            queue.add(new Point(x, y));
                        }
                    }
                }
            }
        }

        int[][] answer = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '0') {
                    answer[i][j] = 0;
                    continue;
                }

                HashSet<Integer> set = new HashSet<>();

                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];

                    if (x < 0 || x >= N || y < 0 || y >= M) {
                        continue;
                    }

                    if (map[x][y] == '0') {
                        set.add(group[x][y]);
                    }
                }

                answer[i][j] = 1;
                for (int g : set) {
                    answer[i][j] += members[g];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(Integer.toString(answer[i][j] % 10));
            }
            bw.newLine();
        }

        bw.close();
        br.close();
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
