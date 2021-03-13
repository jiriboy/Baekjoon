import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String T = br.readLine();

        LinkedList<String> queue = new LinkedList<>();
        queue.add(T);

        String answer = "0";

        while (!queue.isEmpty()) {
            String s = queue.poll();

            if (s.equals(S)) {
                answer = "1";
                break;
            }

            if (s.length() == S.length()) {
                continue;
            }

            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);

            if (first == 'B' && last == 'A') {
                queue.add(s.substring(0, s.length() - 1));
                queue.add(new StringBuilder(s.substring(1)).reverse().toString());
            } else if (first == 'B') {
                queue.add(new StringBuilder(s.substring(1)).reverse().toString());
            } else if (last == 'A') {
                queue.add(s.substring(0, s.length() - 1));
            }
        }

        bw.write(answer);
        bw.close();
        br.close();
    }
}
