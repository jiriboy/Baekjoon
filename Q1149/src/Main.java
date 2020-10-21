import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] rgb = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            rgb[i][0] = Integer.parseInt(st.nextToken());
            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            rgb[i][0] += Math.min(rgb[i - 1][1], rgb[i - 1][2]);
            rgb[i][1] += Math.min(rgb[i - 1][0], rgb[i - 1][2]);
            rgb[i][2] += Math.min(rgb[i - 1][0], rgb[i - 1][1]);
        }

        bw.write(Math.min(rgb[N - 1][0], Math.min(rgb[N - 1][1], rgb[N - 1][2])) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
