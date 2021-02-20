import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    static int[][] schedule;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        schedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            schedule[i][0] = t;
            schedule[i][1] = p;
        }

        Solve(0, 0);

        bw.write(Integer.toString(answer));
        bw.close();
        br.close();
    }

    static void Solve(int n, int sum) {
        if (n >= schedule.length) {
            if (sum > answer) {
                answer = sum;
            }

            return;
        }

        if (n + schedule[n][0] <= schedule.length) {
            Solve(n + schedule[n][0], sum + schedule[n][1]);
        }

        Solve(n + 1, sum);
    }
}
