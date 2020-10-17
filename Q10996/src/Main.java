import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println("*");
            return;
        }

        char[] chars1 = new char[n];
        char[] chars2 = new char[n];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                chars1[i] = '*';
                chars2[i] = ' ';
            } else {
                chars1[i] = ' ';
                chars2[i] = '*';
            }
        }

        String s1 = new String(chars1);
        String s2 = new String(chars2);

        for (int i = 0; i < n; i++) {
            System.out.println(s1);
            System.out.println(s2);
        }
    }
}
