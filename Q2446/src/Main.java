import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[] chars = new char[2 * n - 1];

        for (int i = 0; i < 2 * n - 1; i++) {
            chars[i] = '*';
        }

        for (int i = 0; i < n; i++) {
            System.out.println(new String(chars).substring(0, 2 * n - 1 - i));
            chars[i] = ' ';
        }

        chars[n - 1] = '*';
        for (int i = n - 2; i >= 0; i--) {
            chars[i] = '*';
            System.out.println(new String(chars).substring(0, 2 * n - 1 - i));
        }
    }
}
