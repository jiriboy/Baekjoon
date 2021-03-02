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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        LinkedList<Number> queue = new LinkedList<>();
        queue.add(new Number(s, ""));

        String answer = "-1";
        boolean[] visited = new boolean[Math.max(s, t) + 1];
        visited[s] = true;

        while (!queue.isEmpty()) {
            Number number = queue.poll();

            if (number.n == t) {
                answer = number.ops;
                break;
            }

            if (number.n <= Math.sqrt(t) && !visited[number.n * number.n]) {
                visited[number.n * number.n] = true;
                queue.add(new Number(number.n * number.n, number.ops + "*"));
            }

            if (number.n * 2 <= t && !visited[number.n * 2]) {
                visited[number.n * 2] = true;
                queue.add(new Number(number.n * 2, number.ops + "+"));
            }

            if (!visited[0]) {
                visited[0] = true;
            }

            if (!visited[1]) {
                visited[1] = true;
                queue.add(new Number(1, number.ops + "/"));
            }
        }

        if (answer.equals("")) {
            bw.write("0");
        } else {
            bw.write(answer);
        }

        bw.close();
        br.close();
    }

    static class Number {
        int n;
        String ops;

        Number(int n, String ops) {
            this.n = n;
            this.ops = ops;
        }
    }
}
