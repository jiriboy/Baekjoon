import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = br.readLine();

            if (line.equals("0 0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(line);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a % b == 0) {
                bw.write("multiple\n");
            } else if (b % a == 0) {
                bw.write("factor\n");
            } else {
                bw.write("neither\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
