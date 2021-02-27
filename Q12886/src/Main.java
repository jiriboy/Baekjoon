import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3];
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        Arrays.sort(arr);

        LinkedList<State> queue = new LinkedList<>();
        queue.add(new State(arr[0], arr[1]));

        boolean[][] visited = new boolean[sum + 1][sum + 1];
        visited[arr[0]][arr[1]] = true;

        int answer = 0;

        while (!queue.isEmpty()) {
            State s = queue.poll();

            int a = s.a;
            int b = s.b;
            int c = sum - a - b;

            if (a == b && b == c) {
                answer = 1;
                break;
            }

            arr[0] = a;
            arr[1] = b;
            arr[2] = c;

            Arrays.sort(arr);

            for (int i = 0; i < 2; i++) {
                for (int j = i + 1; j < 3; j++) {
                    if (!visited[2 * arr[i]][arr[j] - arr[i]]) {
                        visited[2 * arr[i]][arr[j] - arr[i]] = true;
                        queue.add(new State(2 * arr[i], arr[j] - arr[i]));
                    }
                }
            }
        }

        bw.write(Integer.toString(answer));
        bw.close();
        br.close();
    }

    static class State {
        int a;
        int b;

        State(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
