import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        long[] len = new long[101];

        len[1] = 1;
        len[2] = 1;
        len[3] = 1;
        len[4] = 2;
        len[5] = 2;

        for (int i = 6; i < 101; i++) {
            len[i] = len[i - 1] + len[i - 5];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            bw.write(len[N] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
