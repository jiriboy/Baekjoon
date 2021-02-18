import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static char map[][];
    static int answer;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        int x1 = -1;
        int y1 = -1;
        int x2 = -1;
        int y2 = -1;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'o') {
                    if (x1 < 0 && y1 < 0) {
                        x1 = i;
                        y1 = j;
                    } else {
                        x2 = i;
                        y2 = j;
                    }
                    map[i][j] = '.';
                }
            }
        }

        answer = -1;

        Solve(x1, y1, x2, y2, 0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void Solve(int x1, int y1, int x2, int y2, int move) {
        if (move > 10) {
            return;
        }

        if (x1 < 0 && x2 < 0 || x1 >= N && x2 >= N || y1 < 0 && y2 < 0 || y1 >= M && y2 >= M) {
            return;
        }

        if (x1 < 0 || x2 < 0) {
            answer = answer < 0 ? move : Math.min(answer, move);
            return;
        }

        if (x1 >= N || x2 >= N) {
            answer = answer < 0 ? move : Math.min(answer, move);
            return;
        }

        if (y1 < 0 || y2 < 0) {
            answer = answer < 0 ? move : Math.min(answer, move);
            return;
        }

        if (y1 >= M || y2 >= M) {
            answer = answer < 0 ? move : Math.min(answer, move);
            return;
        }

        int nx1;
        int ny1;
        int nx2;
        int ny2;

        for (int i = 0; i < 4; i++) {
            nx1 = x1 + dx[i];
            ny1 = y1 + dy[i];
            nx2 = x2 + dx[i];
            ny2 = y2 + dy[i];

            if (nx1 >= 0 && nx1 < N && ny1 >= 0 && ny1 < M && map[nx1][ny1] == '#') {
                nx1 = x1;
                ny1 = y1;
            }

            if (nx2 >= 0 && nx2 < N && ny2 >= 0 && ny2 < M && map[nx2][ny2] == '#') {
                nx2 = x2;
                ny2 = y2;
            }

            Solve(nx1, ny1, nx2, ny2, move + 1);
        }
    }
}
