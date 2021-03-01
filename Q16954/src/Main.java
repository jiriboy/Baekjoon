import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
    static int[] dx = {0, 0, 0, 1, 1, 1, -1, -1, -1};
    static int[] dy = {0, 1, -1, 0, 1, -1, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] map = new char[8][8];

        for (int i = 0; i < 8; i++) {
            map[i] = br.readLine().toCharArray();
        }

        LinkedList<State> queue = new LinkedList<>();
        queue.add(new State(7, 0, 0));

        int answer = 0;

        while (!queue.isEmpty()) {
            State s = queue.poll();

            if (s.t >= 8) {
                answer = 1;
                break;
            }

            for (int i = 0; i < 9; i++) {
                int x = s.x + dx[i];
                int y = s.y + dy[i];

                if (x < 0 || x > 7 || y < 0 || y > 7) {
                    continue;
                }

                if (x - s.t >= 0 && map[x - s.t][y] == '#') {
                    continue;
                }

                if (x - s.t >= 1 && map[x - s.t - 1][y] == '#') {
                    continue;
                }

                queue.add(new State(x, y, s.t + 1));
            }
        }

        bw.write(Integer.toString(answer));
        bw.close();
        br.close();
    }

    static class State {
        int x;
        int y;
        int t;

        State(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
}
