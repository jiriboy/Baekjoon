import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strings = br.readLine().split("-");

        int answer = 0;

        String[] plus = strings[0].split("\\+");
        for (String s: plus) {
            answer += Integer.parseInt(s);
        }

        for (int i = 1; i < strings.length; i++) {
            String[] minus = strings[i].split("\\+");
            for (String s: minus) {
                answer -= Integer.parseInt(s);
            }
        }

        bw.write(Integer.toString(answer));
        bw.close();
        br.close();
    }
}
