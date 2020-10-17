import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[9][9];
    static LinkedList<Point> list = new LinkedList<>();
    static boolean end = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) {
                    list.add(new Point(i, j));
                }
            }
        }

        DFS(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(map[i][j] + " ");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void DFS(int index) {
        if (index == list.size()) {
            end = true;
            return;
        }

        Point p = list.get(index);

        for (int i = 1; i < 10; i++) {
            map[p.x][p.y] = i;

            if (check1(p) && check2(p) && check3(p)) {
                DFS(index + 1);

                if (end) {
                    return;
                }
            }

            map[p.x][p.y] = 0;
        }
    }

    static boolean check1(Point p) {
        int x = p.x;
        int y = p.y;
        int num = map[x][y];

        for (int i = 0; i < 9; i++) {
            if (map[x][i] == num && i != y) {
                return false;
            }
        }

        return true;
    }

    static boolean check2(Point p) {
        int x = p.x;
        int y = p.y;
        int num = map[x][y];

        for (int i = 0; i < 9; i++) {
            if (map[i][y] == num && i != x) {
                return false;
            }
        }

        return true;
    }

    static boolean check3(Point p) {
        int x = p.x;
        int y = p.y;
        int num = map[x][y];

        int xq = x / 3;
        int yq = y / 3;

        for (int i = xq * 3; i < (xq + 1) * 3; i++) {
            for (int j = yq * 3; j < (yq + 1) * 3; j++) {
                if (map[i][j] == num && i != x && j != y) {
                    return false;
                }
            }
        }

        return true;
    }
}
