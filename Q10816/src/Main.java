import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(seq);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            bw.write((upper(seq, 0, N - 1, num) - lower(seq, 0, N - 1, num)) + " ");
        }

        bw.close();
        br.close();
    }

    static int upper(int[] seq, int start, int end, int num) {
        if (start == end) {
            if (seq[start] == num) {
                return start + 1;
            } else {
                return start;
            }
        }

        int mid = (start + end) / 2;

        if (seq[mid] > num) {
            return upper(seq, start, mid, num);
        } else {
            return upper(seq, mid + 1, end, num);
        }
    }

    static int lower(int[] seq, int start, int end, int num) {
        if (start == end) {
            return start;
        }

        int mid = (start + end) / 2;

        if (seq[mid] >= num) {
            return lower(seq, start, mid, num);
        } else {
            return lower(seq, mid + 1, end, num);
        }
    }
}
