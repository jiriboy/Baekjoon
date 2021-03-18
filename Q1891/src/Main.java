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

        int d = Integer.parseInt(st.nextToken());
        char[] pos = st.nextToken().toCharArray();

        st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        long N = (long) Math.pow(2, d);
        long dest_x = 0;
        long dest_y = 0;

        for (char c: pos) {
            N /= 2;

            switch (c) {
                case '1':
                    dest_x += N;
                    break;
                case '2':
                    break;
                case '3':
                    dest_y += N;
                    break;
                case '4':
                    dest_x += N;
                    dest_y += N;
                    break;
            }
        }

        dest_x += x;
        dest_y -= y;

        StringBuilder sb = new StringBuilder();
        N = (long) Math.pow(2, d);

        if (dest_y < 0 || dest_y >= N || dest_x < 0 || dest_x >= N) {
            sb.append(-1);
        } else {
            x = 0;
            y = 0;

            for (int i = 0; i < d; i++) {
                N /= 2;

                if (dest_x < x + N && dest_y < y + N) {
                    sb.append(2);
                } else if (dest_x < x + N) {
                    y += N;
                    sb.append(3);
                } else if (dest_y < y + N) {
                    x += N;
                    sb.append(1);
                } else {
                    x += N;
                    y += N;
                    sb.append(4);
                }
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
