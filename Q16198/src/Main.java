import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int sum = 0;
    static int answer = 0;
    static ArrayList<Integer> energy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        energy = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            energy.add(Integer.parseInt(st.nextToken()));
        }

        Solve();

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void Solve() {
        if (energy.size() == 2) {
            if (sum > answer) {
                answer = sum;
            }

            return;
        }

        for (int i = 1; i < energy.size() - 1; i++) {
            sum += energy.get(i - 1) * energy.get(i + 1);
            int removed = energy.remove(i);
            Solve();
            energy.add(i, removed);
            sum -= energy.get(i - 1) * energy.get(i + 1);
        }
    }
}
