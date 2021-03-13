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
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (M + K - 1 > N || M * K < N) {
            bw.write("-1");
        } else {
            for (int i = K; i > 0; i--) {
                bw.write(i + " ");
            }

            if (M != 1) {
                int Q = (N - K) / (M - 1);
                int R = (N - K) % (M - 1);
                int num = K + 1;

                for (int i = 0; i < M - 1; i++) {
                    if (i < R) {
                        for (int j = num + Q; j >= num ; j--) {
                            bw.write(j + " ");
                        }

                        num += Q + 1;
                    } else {
                        for (int j = num + Q - 1; j >= num; j--) {
                            bw.write(j + " ");
                        }

                        num += Q;
                    }
                }
            }
        }

        bw.close();
        br.close();
    }
}
