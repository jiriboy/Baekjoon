import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] seq;
    static long answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, N - 1);

        bw.write(Long.toString(answer));
        bw.close();
        br.close();
    }

    static void solve(int start, int end) {
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;

        solve(start, mid);
        solve(mid + 1, end);

        int p1 = start;
        int p2 = mid + 1;
        int index = 0;

        int[] temp = new int[end - start + 1];

        while (p1 <= mid && p2 <= end) {
            if (seq[p1] > seq[p2]) {
                temp[index] = seq[p2];
                p2++;
                index++;
                answer += mid - p1 + 1;
            } else {
                temp[index] = seq[p1];
                p1++;
                index++;
            }
        }

        while (p1 <= mid) {
            temp[index] = seq[p1];
            p1++;
            index++;
        }

        while (p2 <= end) {
            temp[index] = seq[p2];
            p2++;
            index++;
        }

        for (int i = 0; i < temp.length; i++) {
            seq[start + i] = temp[i];
        }
    }
}
