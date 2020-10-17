import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int size = 1048576;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        tree = new long[2 * size];

        for (int i = 0; i < N; i++) {
            update(i, Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update((int)b - 1, c);
            } else {
                bw.write(query((int)b - 1, (int)c - 1) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void update(int index, long num) {
        index += size;

        long diff = num - tree[index];

        while (index > 0) {
            tree[index] += diff;
            index /= 2;
        }
    }

    public static long query(int start, int end) {
        long sum = 0;

        start += size;
        end += size;

        while (start <= end) {
            if (start % 2 == 1) {
                sum += tree[start];
                start++;
            }

            if (end % 2 == 0) {
                sum += tree[end];
                end--;
            }

            start /= 2;
            end /= 2;
        }

        return sum;
    }
}