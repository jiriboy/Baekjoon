import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            bw.write(1 + "\n");
        } else {
            int[][] table = new int[N + 1][2];

            table[1][0] = 0;
            table[1][1] = 1;
            table[2][0] = 1;
            table[2][1] = 1;

            for (int i = 3; i <= N; i++) {
                table[i][0] = table[i - 1][1] % 15746;
                table[i][1] = (table[i - 1][0] + table[i - 1][1]) % 15746;
            }

            bw.write((table[N][0] + table[N][1]) % 15746 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
