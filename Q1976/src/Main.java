import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        int[] travel = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            travel[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        boolean result = true;

        for (int i = 0; i < M - 1; i++) {
            if (find(travel[i]) != find(travel[i + 1])) {
                result = false;
                break;
            }
        }

        if (result) {
            bw.write("YES\n");
        } else {
            bw.write("NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        parent[b] = parent[a];
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        parent[a] = find(parent[a]);

        return parent[a];
    }
}
