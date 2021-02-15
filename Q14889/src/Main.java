import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] ability;
    static LinkedList<Integer> start;
    static LinkedList<Integer> link;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        start = new LinkedList<>();
        link = new LinkedList<>();

        answer = Integer.MAX_VALUE;

        DFS(0);

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void DFS(int index) {
        if (index == N) {
            answer = Math.min(answer, Math.abs(calculate(start) - calculate(link)));
            return;
        }

        if (start.size() < N / 2) {
            start.add(index);
            DFS(index + 1);
            start.remove(Integer.valueOf(index));
        }

        if (link.size() < N / 2) {
            link.add(index);
            DFS(index + 1);
            link.remove(Integer.valueOf(index));
        }
    }

    static int calculate(LinkedList<Integer> team) {
        int result = 0;

        for (int i = 0; i < team.size(); i++) {
            for (int j = 0; j < team.size(); j++) {
                if (i == j) {
                    continue;
                }

                result += ability[team.get(i)][team.get(j)];
            }
        }

        return result;
    }
}
