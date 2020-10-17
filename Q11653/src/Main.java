import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static boolean[] table;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        init(N);

        for (int i = 2; i < table.length; i++) {
            if (!table[i]) {
                while (N % i == 0) {
                    bw.write(i + "\n");
                    N /= i;
                }

                if (N == 1) {
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void init(int size) {
        table = new boolean[size + 1];

        for (int i = 2; i < table.length; i++) {
            for (int j = i * 2; j < table.length; j += i) {
                table[j] = true;
            }
        }
    }
}
