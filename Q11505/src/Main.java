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

        tree = new long[2 * size + 1];

        for (int i = 0; i < N; i++) {
            update(i, Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(b - 1, c);
            } else {
                bw.write(query(b - 1, c - 1) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void update(int index, int num) {
        index += size;
        tree[index] = num;

        while (index > 1) {
            index /= 2;
            tree[index] = (tree[index * 2] * tree[index * 2 + 1]) % 1000000007;
        }
    }

    static long query(int start, int end) {
        start += size;
        end += size;

        long result = 1;

        while (start <= end) {
            if (start % 2 == 1) {
                result *= tree[start];
                result %= 1000000007;

                start++;
            }

            if (end % 2 == 0) {
                result *= tree[end];
                result %= 1000000007;

                end--;
            }

            start /= 2;
            end /= 2;
        }

        return result;
    }
}
