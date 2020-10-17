import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        String answer = "";

        Solve(1, 1, answer);

        bw.flush();
        bw.close();
        br.close();
    }

    static void Solve(int depth, int start, String s) throws Exception {
        if (depth > m) {
            bw.write(s + "\n");
            return;
        }

        int len = s.length();

        for (int i = start; i <= n; i++) {
            s += i + " ";
            Solve(depth + 1, i, s);
            s = s.substring(0, len);
        }
    }
}
