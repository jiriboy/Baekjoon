import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int[] num = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            num[i] = str.charAt(i) - '0';
        }

        StringBuilder sb = new StringBuilder();

        int sum = Arrays.stream(num).sum();
        Arrays.sort(num);
        if (num[0] != 0 || sum % 3 != 0) {
            sb.append(-1);
        } else {
            for (int i = num.length - 1; i >= 0; i--) {
                sb.append(num[i]);
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
