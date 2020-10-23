import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static int[] parent;
    static int[] size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int F = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new TreeMap<>();

            int index = 0;
            parent = new int[2 * F];
            size = new int[2 * F];

            for (int j = 0; j < F; j++) {
                st = new StringTokenizer(br.readLine());

                String p1 = st.nextToken();
                String p2 = st.nextToken();

                if (!map.containsKey(p1)) {
                    map.put(p1, index);
                    parent[index] = index;
                    size[index] = 1;
                    index++;
                }

                if (!map.containsKey(p2)) {
                    map.put(p2, index);
                    parent[index] = index;
                    size[index] = 1;
                    index++;
                }

                union(map.get(p1), map.get(p2));

                bw.write(size[find(map.get(p1))] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return;
        }

        size[parent[a]] += size[parent[b]];
        size[parent[b]] = size[parent[a]];
        parent[b] = parent[a];
    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        }

        parent[a] = find(parent[a]);
        size[a] = size[parent[a]];

        return parent[a];
    }
}
