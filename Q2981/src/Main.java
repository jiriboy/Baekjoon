import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(seq);

        int[] diff = new int[N - 1];

        for (int i = 0; i < N - 1; i++) {
            diff[i] = seq[i + 1] - seq[i];
        }

        Arrays.sort(diff);

        int gcd = diff[0];

        for (int i = 1; i < N - 1; i++) {
            gcd = GCD(gcd, diff[i]);
        }

        for (int i = 2; i <= gcd; i++) {
            if (gcd % i == 0) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int GCD(int n1, int n2) {
        if (n1 < n2) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }

        while (n1 % n2 != 0) {
            int r = n1 % n2;

            n1 = n2;
            n2 = r;
        }

        return n2;
    }
}
