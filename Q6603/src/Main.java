import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int[] seq;
    static int[] selected;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            seq = new int[k];
            selected = new int[6];

            for (int i = 0; i < k; i++) {
                seq[i] = Integer.parseInt(st.nextToken());
            }

            Solve(0, 0);
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void Solve(int count, int index) throws Exception {
        if (count == 6) {
            for (int i = 0; i < 5; i++) {
                bw.write(selected[i] + " ");
            }
            bw.write(selected[5] + "\n");

            return;
        }

        if (index == k) {
            return;
        }

        selected[count] = seq[index];
        Solve(count + 1, index + 1);
        Solve(count, index + 1);
    }
}
