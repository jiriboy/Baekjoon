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
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                A[i][j] = chars[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                B[i][j] = chars[j] - '0';
            }
        }

        int answer = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (A[i][j] != B[i][j]) {
                    answer++;

                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            A[i + k][j + l] = (A[i + k][j + l] + 1) % 2;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = Math.max(M - 2, 0); j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    answer = -1;
                    break;
                }
            }

            if (answer == -1) {
                break;
            }
        }

        for (int i = Math.max(N - 2, 0); i < N; i++) {
            for (int j = 0; j < Math.max(M - 2, 0); j++) {
                if (A[i][j] != B[i][j]) {
                    answer = -1;
                    break;
                }
            }

            if (answer == -1) {
                break;
            }
        }

        bw.write(Integer.toString(answer));
        bw.close();
        br.close();
    }
}
