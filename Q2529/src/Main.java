import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int k;
    static int depth;
    static int[] num;
    static int[] seq;
    static String[] str;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());
        str = br.readLine().split(" ");

        depth = 0;
        seq = new int[k + 1];
        visited = new boolean[k + 1];
        bw.write(max() + "\n");

        depth = 0;
        seq = new int[k + 1];
        visited = new boolean[k + 1];
        bw.write(min() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static String max() {
        num = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            num[i] = 9 - i;
        }

        int[] result = permutation();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= k; i++) {
            sb.append(result[i]);
        }

        return sb.toString();
    }

    static String min() {
        num = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            num[i] = i;
        }

        int[] result = permutation();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= k; i++) {
            sb.append(result[i]);
        }

        return sb.toString();
    }

    static int[] permutation() {
        if (depth == k + 1) {
            if (check(seq)) {
                return seq;
            } else {
                return null;
            }
        }

        for (int i = 0; i <= k; i++) {
            if (!visited[i]) {
                seq[depth] = num[i];
                visited[i] = true;
                depth++;
                int[] result = permutation();
                depth--;
                if (result != null) {
                    return result;
                }
                visited[i] = false;
            }
        }

        return null;
    }

    static boolean check(int[] seq) {
        for (int i = 0; i < k; i++) {
            if (str[i].equals("<") && seq[i] > seq[i + 1]) {
                return false;
            } else if (str[i].equals(">") && seq[i] < seq[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
