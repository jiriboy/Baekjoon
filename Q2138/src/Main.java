import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        char[] from1 = br.readLine().toCharArray();
        char[] from2 = from1.clone();
        char[] to = br.readLine().toCharArray();

        from2[0] = toggle(from2[0]);
        from2[1] = toggle(from2[1]);

        int answer1 = Solve(from1, to, 0);
        int answer2 = Solve(from2, to, 1);

        if (answer1 == -1 || answer2 == -1) {
            bw.write(Integer.toString(Math.max(answer1, answer2)));
        } else {
            bw.write(Integer.toString(Math.min(answer1, answer2)));
        }

        bw.close();
        br.close();
    }

    static int Solve(char[] from, char[] to, int answer) {
        for (int i = 1; i < N; i++) {
            if (from[i - 1] != to[i - 1]) {
                answer++;
                from[i - 1] = toggle(from[i - 1]);
                from[i] = toggle(from[i]);
                if (i + 1 < N) {
                    from[i + 1] = toggle(from[i + 1]);
                }
            }
        }

        if (from[N - 1] != to[N - 1]) {
            answer = -1;
        }

        return answer;
    }

    static char toggle(char c) {
        if (c == '0') {
            return '1';
        } else {
            return '0';
        }
    }
}
