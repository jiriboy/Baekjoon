import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static char[][] map;
    static boolean[] chars;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        chars = new boolean[26];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Solve(0, 0, 0);

        bw.write(Integer.toString(answer));
        bw.close();
        br.close();
    }

    static void Solve(int x, int y, int count) {
        if (chars[map[x][y] - 'A']) {
            if (count > answer) {
                answer = count;
            }

            return;
        }

        chars[map[x][y] - 'A'] = true;
        count++;

        if (x > 0) {
            Solve(x - 1, y, count);
        }

        if (x < map.length - 1) {
            Solve(x + 1, y, count);
        }

        if (y > 0) {
            Solve(x, y - 1, count);
        }

        if (y < map[0].length - 1) {
            Solve(x, y + 1, count);
        }

        chars[map[x][y] - 'A'] = false;
        count--;
    }
}
