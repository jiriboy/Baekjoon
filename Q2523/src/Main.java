import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String s = "";
        for (int i = 0; i < n; i++) {
            s += "*";
            System.out.println(s);
        }

        for (int i = 0; i < n - 1; i++) {
            s = s.substring(1);
            System.out.println(s);
        }
    }
}
