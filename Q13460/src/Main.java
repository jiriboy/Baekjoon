import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static LinkedList<State> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        State s = new State(0);

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                if (chars[j] == 'R') {
                    s.rx = i;
                    s.ry = j;
                } else if (chars[j] == 'B') {
                    s.bx = i;
                    s.by = j;
                } else if (chars[j] == 'O') {
                    map[i][j] = 1;
                } else if (chars[j] == '#') {
                    map[i][j] = -1;
                }
            }
        }

        queue = new LinkedList<>();
        queue.add(s);

        int result = -1;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (s.move == 10) {
                continue;
            }

            result = Math.max(result, right(s));
            result = Math.max(result, left(s));
            result = Math.max(result, up(s));
            result = Math.max(result, down(s));

            if (result > -1) {
                break;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static class State {
        int rx;
        int ry;
        int bx;
        int by;
        int move;

        State(int move) {
            this.move = move;
        }

        State(int rx, int ry, int bx, int by, int move) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.move = move;
        }
    }

    static int right(State s) {
        int rx = s.rx;
        int ry = s.ry;
        int bx = s.bx;
        int by = s.by;

        while (map[bx][by + 1] > -1) {
            by++;

            if (map[bx][by] == 1) {
                return -1;
            }
        }

        while (map[rx][ry + 1] > -1) {
            ry++;

            if (map[rx][ry] == 1) {
                return s.move + 1;
            }
        }

        if (rx == bx && ry == by) {
            if (s.ry > s.by) {
                by--;
            } else {
                ry--;
            }
        }

        if (rx != s.rx || ry != s.ry || bx != s.bx || by != s.by) {
            queue.add(new State(rx, ry, bx, by, s.move + 1));
        }

        return -1;
    }

    static int left(State s) {
        int rx = s.rx;
        int ry = s.ry;
        int bx = s.bx;
        int by = s.by;

        while (map[bx][by - 1] > -1) {
            by--;

            if (map[bx][by] == 1) {
                return -1;
            }
        }

        while (map[rx][ry - 1] > -1) {
            ry--;

            if (map[rx][ry] == 1) {
                return s.move + 1;
            }
        }

        if (rx == bx && ry == by) {
            if (s.ry < s.by) {
                by++;
            } else {
                ry++;
            }
        }

        if (rx != s.rx || ry != s.ry || bx != s.bx || by != s.by) {
            queue.add(new State(rx, ry, bx, by, s.move + 1));
        }

        return -1;
    }

    static int up(State s) {
        int rx = s.rx;
        int ry = s.ry;
        int bx = s.bx;
        int by = s.by;

        while (map[bx - 1][by] > -1) {
            bx--;

            if (map[bx][by] == 1) {
                return -1;
            }
        }

        while (map[rx - 1][ry] > -1) {
            rx--;

            if (map[rx][ry] == 1) {
                return s.move + 1;
            }
        }

        if (rx == bx && ry == by) {
            if (s.rx > s.bx) {
                rx++;
            } else {
                bx++;
            }
        }

        if (rx != s.rx || ry != s.ry || bx != s.bx || by != s.by) {
            queue.add(new State(rx, ry, bx, by, s.move + 1));
        }

        return -1;
    }

    static int down(State s) {
        int rx = s.rx;
        int ry = s.ry;
        int bx = s.bx;
        int by = s.by;

        while (map[bx + 1][by] > -1) {
            bx++;

            if (map[bx][by] == 1) {
                return -1;
            }
        }

        while (map[rx + 1][ry] > -1) {
            rx++;

            if (map[rx][ry] == 1) {
                return s.move + 1;
            }
        }

        if (rx == bx && ry == by) {
            if (s.rx < s.bx) {
                rx--;
            } else {
                bx--;
            }
        }

        if (rx != s.rx || ry != s.ry || bx != s.bx || by != s.by) {
            queue.add(new State(rx, ry, bx, by, s.move + 1));
        }

        return -1;
    }
}
