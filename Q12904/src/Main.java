import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String T = br.readLine();

        while (S.length() < T.length()) {
            if (T.charAt(T.length() - 1) == 'A') {
                T = T.substring(0, T.length() - 1);
            } else {
                StringBuilder sb = new StringBuilder();

                for (int i = T.length() - 2; i >= 0; i--) {
                    sb.append(T.charAt(i));
                }

                T = sb.toString();
            }
        }

        if (S.equals(T)) {
            bw.write("1");
        } else {
            bw.write("0");
        }

        bw.close();
        br.close();
    }
}
