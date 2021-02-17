import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int sum;
    static int answer;
    static int[] seq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        seq = new int[N];

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        sum = 0;
        answer = 0;

        Solve(0);

        if (S == 0) {
            answer--;
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void Solve(int index) {
        if (index == N) {
            if (sum == S) {
                answer++;
            }

            return;
        }

        sum += seq[index];
        Solve(index + 1);
        sum -= seq[index];
        Solve(index + 1);
    }
}
