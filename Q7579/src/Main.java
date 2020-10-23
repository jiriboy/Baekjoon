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

        int[] memory = new int[N];
        int[] cost = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            sum += cost[i];
        }

        int[] table = new int[sum + 1];

        for (int i = 0; i < N; i++) {
            for (int j = sum; j >= cost[i]; j--) {
                table[j] = Math.max(table[j], table[j - cost[i]] + memory[i]);
            }
        }

        for (int i = 0; i <= sum; i++) {
            if (table[i] >= M) {
                bw.write(i + "\n");
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
