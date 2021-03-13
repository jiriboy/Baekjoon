import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];
        int min = Integer.MAX_VALUE;
        int mx = 0;
        int my = 0;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if ((i + j) % 2 == 1 && map[i][j] < min) {
                    min = map[i][j];
                    mx = i;
                    my = j;
                }
            }
        }

        if (R % 2 == 1) {
            for (int i = 0; i < R; i++) {
                if (i % 2 == 0) {
                    bw.write("R".repeat(C - 1));
                } else {
                    bw.write("L".repeat(C - 1));
                }

                if (i != R - 1) {
                    bw.write("D");
                }
            }
        } else if (C % 2 == 1) {
            for (int i = 0; i < C; i++) {
                if (i % 2 == 0) {
                    bw.write("D".repeat(R - 1));
                } else {
                    bw.write("U".repeat(R - 1));
                }

                if (i != C - 1) {
                    bw.write("R");
                }
            }
        } else {
            int x = 0;
            int y = 0;

            boolean left = true;

            while (x != R - 1 || y != C - 1) {
                if (mx == x || mx == x + 1) {
                    left = false;

                    boolean up = true;

                    for (int i = 0; i < C / 2; i++) {
                        if (my == y) {
                            up = false;
                            bw.write("RD");
                        } else if (my == y + 1) {
                            up = false;
                            bw.write("DR");
                        } else {
                            if (up) {
                                bw.write("DRU");
                            } else {
                                bw.write("URD");
                            }
                        }

                        if (y + 2 == C) {
                            y++;
                        } else {
                            y += 2;
                            bw.write("R");
                        }
                    }
                } else {
                    if (left) {
                        bw.write("R".repeat(C - 1));
                        bw.write("D");
                        bw.write("L".repeat(C - 1));
                    } else {
                        bw.write("L".repeat(C - 1));
                        bw.write("D");
                        bw.write("R".repeat(C - 1));
                    }
                }

                if (x + 2 == R) {
                    x++;
                } else {
                    bw.write("D");
                    x += 2;
                }
            }
        }

        bw.close();
        br.close();
    }
}
