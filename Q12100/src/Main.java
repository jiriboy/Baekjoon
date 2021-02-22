import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Solve(map, 0);

        bw.write(Integer.toString(answer));
        bw.close();
        br.close();
    }

    static void Solve(int[][] map, int depth) {
        if (depth == 5) {
            return;
        }

        int[][] left = left(map);
        int[][] right = right(map);
        int[][] up = up(map);
        int[][] down = down(map);

        Solve(left, depth + 1);
        Solve(right, depth + 1);
        Solve(up, depth + 1);
        Solve(down, depth + 1);
    }

    static int[][] left(int[][] map) {
        int N = map.length;
        int[][] left = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] temp = new int[N];
            int index = 0;
            int num = 0;

            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                if (num == 0) {
                    num = map[i][j];
                } else {
                    if (num == map[i][j]) {
                        temp[index] = 2 * num;
                        num = 0;
                    } else {
                        temp[index] = num;
                        num = map[i][j];
                    }

                    index++;
                }
            }

            temp[index] = num;

            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, temp[j]);
                left[i][j] = temp[j];
            }
        }

        return left;
    }

    static int[][] right(int[][] map) {
        int N = map.length;
        int[][] right = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] temp = new int[N];
            int index = N - 1;
            int num = 0;

            for (int j = N - 1; j >= 0; j--) {
                if (map[i][j] == 0) {
                    continue;
                }

                if (num == 0) {
                    num = map[i][j];
                } else {
                    if (num == map[i][j]) {
                        temp[index] = 2 * num;
                        num = 0;
                    } else {
                        temp[index] = num;
                        num = map[i][j];
                    }

                    index--;
                }
            }

            temp[index] = num;

            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, temp[j]);
                right[i][j] = temp[j];
            }
        }

        return right;
    }

    static int[][] up(int[][] map) {
        int N = map.length;
        int[][] up = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] temp = new int[N];
            int index = 0;
            int num = 0;

            for (int j = 0; j < N; j++) {
                if (map[j][i] == 0) {
                    continue;
                }

                if (num == 0) {
                    num = map[j][i];
                } else {
                    if (num == map[j][i]) {
                        temp[index] = 2 * num;
                        num = 0;
                    } else {
                        temp[index] = num;
                        num = map[j][i];
                    }

                    index++;
                }
            }

            temp[index] = num;

            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, temp[j]);
                up[j][i] = temp[j];
            }
        }

        return up;
    }

    static int[][] down(int[][] map) {
        int N = map.length;
        int[][] down = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] temp = new int[N];
            int index = N - 1;
            int num = 0;

            for (int j = N - 1; j >= 0; j--) {
                if (map[j][i] == 0) {
                    continue;
                }

                if (num == 0) {
                    num = map[j][i];
                } else {
                    if (num == map[j][i]) {
                        temp[index] = 2 * num;
                        num = 0;
                    } else {
                        temp[index] = num;
                        num = map[j][i];
                    }

                    index--;
                }
            }

            temp[index] = num;

            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, temp[j]);
                down[j][i] = temp[j];
            }
        }

        return down;
    }
}
