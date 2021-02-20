import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] pair;
    static boolean[][] check1;
    static boolean[][] check2;
    static boolean[][] check3;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int N;
        int num = 0;

        while ((N = Integer.parseInt(br.readLine())) != 0) {
            num++;
            map = new int[9][9];
            pair = new boolean[9][9];
            check1 = new boolean[9][9];
            check2 = new boolean[9][9];
            check3 = new boolean[9][9];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int num1 = Integer.parseInt(st.nextToken());
                char[] pos1 = st.nextToken().toCharArray();
                int num2 = Integer.parseInt(st.nextToken());
                char[] pos2 = st.nextToken().toCharArray();

                map[pos1[0] - 'A'][pos1[1] - '1'] = num1;
                map[pos2[0] - 'A'][pos2[1] - '1'] = num2;
                pair[num1 - 1][num2 - 1] = true;
                pair[num2 - 1][num1 - 1] = true;

                check1[pos1[0] - 'A'][num1 - 1] = true;
                check2[pos1[1] - '1'][num1 - 1] = true;
                check3[(pos1[0] - 'A') / 3 * 3 + (pos1[1] - '1') / 3][num1 - 1] = true;
                check1[pos2[0] - 'A'][num2 - 1] = true;
                check2[pos2[1] - '1'][num2 - 1] = true;
                check3[(pos2[0] - 'A') / 3 * 3 + (pos2[1] - '1') / 3][num2 - 1] = true;
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i < 10; i++) {
                char[] pos = st.nextToken().toCharArray();

                map[pos[0] - 'A'][pos[1] - '1'] = i;

                check1[pos[0] - 'A'][i - 1] = true;
                check2[pos[1] - '1'][i - 1] = true;
                check3[(pos[0] - 'A') / 3 * 3 + (pos[1] - '1') / 3][i - 1] = true;
            }

            Solve(0);

            bw.write("Puzzle " + num + "\n");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(Integer.toString(map[i][j]));
                }
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean Solve(int n) {
        if (n == 81) {
            return true;
        }

        int x = n / 9;
        int y = n % 9;

        if (map[x][y] != 0) {
            return Solve(n + 1);
        }

        for (int i = 0; i < 9; i++) {
            if (check1[x][i] || check2[y][i] || check3[(x / 3) * 3 + (y / 3)][i]) {
                continue;
            }

            map[x][y] = i + 1;
            check1[x][i] = true;
            check2[y][i] = true;
            check3[(x / 3) * 3 + (y / 3)][i] = true;

            for (int j = 0; j < 9; j++) {
                if (i == j || pair[i][j]) {
                    continue;
                }

                if (x < 8 && map[x + 1][y] == 0 && !check1[x + 1][j] && !check2[y][j] && !check3[((x + 1) / 3) * 3 + (y / 3)][j]) {
                    map[x + 1][y] = j + 1;
                    pair[i][j] = true;
                    pair[j][i] = true;
                    check1[x + 1][j] = true;
                    check2[y][j] = true;
                    check3[((x + 1) / 3) * 3 + (y / 3)][j] = true;

                    if (Solve(n + 1)) {
                        return true;
                    }

                    map[x + 1][y] = 0;
                    pair[i][j] = false;
                    pair[j][i] = false;
                    check1[x + 1][j] = false;
                    check2[y][j] = false;
                    check3[((x + 1) / 3) * 3 + (y / 3)][j] = false;
                }

                if (y < 8 && map[x][y + 1] == 0 && !check1[x][j] && !check2[y + 1][j] && !check3[(x / 3) * 3 + ((y + 1) / 3)][j]) {
                    map[x][y + 1] = j + 1;
                    pair[i][j] = true;
                    pair[j][i] = true;
                    check1[x][j] = true;
                    check2[y + 1][j] = true;
                    check3[(x / 3) * 3 + ((y + 1) / 3)][j] = true;

                    if (Solve(n + 1)) {
                        return true;
                    }

                    map[x][y + 1] = 0;
                    pair[i][j] = false;
                    pair[j][i] = false;
                    check1[x][j] = false;
                    check2[y + 1][j] = false;
                    check3[(x / 3) * 3 + ((y + 1) / 3)][j] = false;
                }
            }

            map[x][y] = 0;
            check1[x][i] = false;
            check2[y][i] = false;
            check3[(x / 3) * 3 + (y / 3)][i] = false;
        }

        return false;
    }
}
