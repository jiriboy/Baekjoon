import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int size = 1048576;
    static int[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        tree = new int[size * 2];

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int instruction = Integer.parseInt(st.nextToken());

            if (instruction == 1) {
                int num = Integer.parseInt(st.nextToken());
                bw.write(delete(num, 1, 1, size) + "\n");
            } else {
                int flavor = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                update(flavor, num);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int delete(int num, int node, int start, int end) {
        if (start == end) {
            update(start, -1);
            return start;
        }

        int mid = (start + end) / 2;

        if (num <= tree[node * 2]) {
            return delete(num, node * 2, start, mid);
        } else {
            return delete(num - tree[node * 2], node * 2 + 1, mid + 1, end);
        }
    }

    static void update(int flavor, int num) {
        int index = size + flavor - 1;

        while (index >= 1) {
            tree[index] += num;
            index /= 2;
        }
    }
}
