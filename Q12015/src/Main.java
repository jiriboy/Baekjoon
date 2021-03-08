import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = 0;

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());

            int index = binarySearch(seq, 0, len, a);
            seq[index] = a;

            if (index == len) {
                len++;
            }
        }

        bw.write(Integer.toString(len));
        bw.close();
        br.close();
    }

    static int binarySearch(int[] seq, int start, int end, int a) {
        int mid = (start + end) / 2;

        if (start == end) {
            return start;
        }

        if (seq[mid] == a) {
            return mid;
        } else if (seq[mid] < a) {
            return binarySearch(seq, mid + 1, end, a);
        } else {
            return binarySearch(seq, start, mid, a);
        }
    }
}
