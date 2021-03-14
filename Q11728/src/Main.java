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

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int a = 0;
        int b = 0;

        while (a < N && b < M) {
            if (A[a] < B[b]) {
                bw.write(A[a] + " ");
                a++;
            } else {
                bw.write(B[b] + " ");
                b++;
            }
        }

        while (a < N) {
            bw.write(A[a] + " ");
            a++;
        }

        while (b < M) {
            bw.write(B[b] + " ");
            b++;
        }

        bw.close();
        br.close();
    }
}
