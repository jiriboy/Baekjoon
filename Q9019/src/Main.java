import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            String[] route = new String[10000];
            route[num1] = "";

            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(num1);

            while (!queue.isEmpty()) {
                int n = queue.poll();

                if (n == num2) {
                    bw.write(route[n]);
                    bw.newLine();
                    break;
                }

                int D = D(n);
                int S = S(n);
                int L = L(n);
                int R = R(n);

                if (route[D] == null) {
                    route[D] = route[n] + "D";
                    queue.add(D);
                }

                if (route[S] == null) {
                    route[S] = route[n] + "S";
                    queue.add(S);
                }

                if (route[L] == null) {
                    route[L] = route[n] + "L";
                    queue.add(L);
                }

                if (route[R] == null) {
                    route[R] = route[n] + "R";
                    queue.add(R);
                }
            }
        }

        bw.close();
        br.close();
    }

    static int D(int n) {
        return 2 * n % 10000;
    }

    static int S(int n) {
        n--;

        if (n < 0) {
            n = 9999;
        }

        return n % 10000;
    }

    static int L(int n) {
        int d1 = n / 1000;
        int r = n % 1000;

        return r * 10 + d1;
    }

    static int R(int n) {
        int d4 = n % 10;
        int q = n / 10;

        return 1000 * d4 + q;
    }
}
