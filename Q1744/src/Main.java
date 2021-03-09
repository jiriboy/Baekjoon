import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();
        int zero = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 0) {
                plus.add(num);
            } else if (num < 0) {
                minus.add(num);
            } else {
                zero++;
            }
        }

        int answer = 0;

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        for (int i = 0; i < plus.size(); i++) {
            if (i == plus.size() - 1) {
                answer += plus.get(i);
                break;
            }

            if (plus.get(i) == 1 || plus.get(i + 1) == 1) {
                answer += plus.get(i);
                answer += plus.get(i + 1);
            } else {
                answer += plus.get(i) * plus.get(i + 1);
            }
            i++;
        }

        for (int i = 0; i < minus.size(); i++) {
            if (i == minus.size() - 1) {
                if (zero == 0) {
                    answer += minus.get(i);
                }

                break;
            }
            answer += minus.get(i) * minus.get(i + 1);
            i++;
        }

        bw.write(Integer.toString(answer));
        bw.close();
        br.close();
    }
}
