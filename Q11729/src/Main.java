import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write((int)Math.pow(2, N)- 1 + "\n");
        solve(N, 1, 2, 3);

        bw.close();
        br.close();
    }

    static void solve(int num, int from, int bridge, int to) throws Exception {
        if (num == 1) {
            bw.write(from + " " + to + "\n");
            return;
        }

        solve(num - 1, from, to, bridge);
        bw.write(from + " " + to + "\n");
        solve(num - 1, bridge, from, to);
    }
}
