import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        LinkedList<Position> queue = new LinkedList<>();
        queue.add(new Position(r1, c1, 0));
        visited[r1][c1] = true;

        int answer = -1;

        while (!queue.isEmpty()) {
            Position p = queue.poll();

            if (p.r == r2 && p.c == c2) {
                answer = p.m;
                break;
            }

            for (int i = 0; i < 6; i++) {
                int next_r = p.r + dr[i];
                int next_c = p.c + dc[i];

                if (next_r < 0 || next_r >= N || next_c < 0 || next_c >= N) {
                    continue;
                }

                if (!visited[next_r][next_c]) {
                    visited[next_r][next_c] = true;
                    queue.add(new Position(next_r, next_c, p.m + 1));
                }
            }
        }

        bw.write(Integer.toString(answer));

        bw.close();
        br.close();
    }

    static class Position {
        int r;
        int c;
        int m;

        Position(int r, int c, int m) {
            this.r = r;
            this.c = c;
            this.m = m;
        }
    }
}
