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

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        bw.write(GCD(n1, n2) + "\n" + LCM(n1, n2) + "\n");

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

    static int LCM(int n1, int n2) {
        if (n1 < n2) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }

        int result = 0;

        for (int i = 1; i <= n2; i++) {
            if (n1 * i % n2 == 0) {
                result = n1 * i;
                break;
            }
        }

        return result;
    }
}
