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

        boolean[] not_prime = new boolean[10000];
        not_prime[0] = true;
        not_prime[1] = true;

        for (int i = 2; i < 10000; i++) {
            if (not_prime[i]) {
                continue;
            }

            for (int j = 2 * i; j < 10000; j += i) {
                not_prime[j] = true;
            }
        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            LinkedList<Prime> queue = new LinkedList<>();
            queue.add(new Prime(p1, 0));

            boolean[] visited = new boolean[10000];
            visited[p1] = true;

            int answer = -1;

            while (!queue.isEmpty()) {
                Prime p = queue.poll();

                if (p.value == p2) {
                    answer = p.count;
                    break;
                }

                int temp;

                for (int j = 1; j < 10; j++) {
                    temp = p.value % 1000 + j * 1000;

                    if (!not_prime[temp] && !visited[temp]) {
                        visited[temp] = true;
                        queue.add(new Prime(temp, p.count + 1));
                    }
                }

                for (int j = 0; j < 10; j++) {
                    temp = p.value % 100 + (p.value / 1000) * 1000 + j * 100;

                    if (!not_prime[temp] && !visited[temp]) {
                        visited[temp] = true;
                        queue.add(new Prime(temp, p.count + 1));
                    }
                }

                for (int j = 0; j < 10; j++) {
                    temp = p.value % 10 + (p.value / 100) * 100 + j * 10;

                    if (!not_prime[temp] && !visited[temp]) {
                        visited[temp] = true;
                        queue.add(new Prime(temp, p.count + 1));
                    }
                }

                for (int j = 0; j < 10; j++) {
                    temp = (p.value / 10) * 10 + j;

                    if (!not_prime[temp] && !visited[temp]) {
                        visited[temp] = true;
                        queue.add(new Prime(temp, p.count + 1));
                    }
                }
            }

            if (answer == -1) {
                bw.write("Impossible");
            } else {
                bw.write(Integer.toString(answer));
            }

            bw.newLine();
        }

        bw.close();
        br.close();
    }

    static class Prime {
        int value;
        int count;

        Prime(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
