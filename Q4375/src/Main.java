import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;

        while ((line = br.readLine()) != null) {
            int N = Integer.parseInt(line);
            int count = 1;
            int num = 1;

            while (num % N != 0) {
                num = (num * 10 + 1) % N;
                count++;
            }

            bw.write(count + "\n");
        }

        bw.close();
        br.close();
    }
}
