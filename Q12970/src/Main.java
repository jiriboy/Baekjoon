import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        int A = N / 2;
        int B = N - A;

        if (A * B < K) {
            sb.append("-1");
        } else {
            int[] count = new int[B + 1];

            count[B] = K / B;
            count[K % B] = 1;
            count[0] += A - (K / B + 1);

            for (int i = B; i > 0; i--) {
                sb.append("A".repeat(count[i]));
                sb.append("B");
            }

            sb.append("A".repeat(count[0]));
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}