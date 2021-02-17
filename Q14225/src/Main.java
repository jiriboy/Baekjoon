import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int sum;
    static int[] seq;
    static boolean[] check = new boolean[2000000];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        seq = new int[N];

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        sum = 0;
        Sum(0);

        for (int i = 1; i < 2000000; i++) {
            if (!check[i]) {
                bw.write(i + "\n");
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void Sum(int index) {
        if (index == N) {
            check[sum] = true;
            return;
        }

        sum += seq[index];
        Sum(index + 1);
        sum -= seq[index];
        Sum(index + 1);
    }
}
