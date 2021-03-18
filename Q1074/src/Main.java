import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        solve(0, 0, N);

        bw.write(Integer.toString(answer));

        bw.close();
        br.close();
    }

    static void solve(int x, int y, int len) {
        if (x == r && y == c) {
            return;
        }

        len /= 2;

        if (r < x + len && c < y + len) {
            solve(x, y, len);
        } else if (r < x + len) {
            answer += len * len;
            solve(x, y + len, len);
        } else if (c < y + len) {
            answer += len * len * 2;
            solve(x + len, y, len);
        } else {
            answer += len * len * 3;
            solve(x + len, y + len, len);
        }
    }
}
