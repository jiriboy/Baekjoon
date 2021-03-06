import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(lectures);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int pointer = 0;
        int answer = 0;

        for (int i = 10000; i > 0; i--) {
            while (pointer < lectures.length && lectures[pointer].d >= i) {
                queue.add(lectures[pointer].p);
                pointer++;
            }

            if (!queue.isEmpty()) {
                answer += queue.poll();
            }
        }

        bw.write(Integer.toString(answer));
        bw.close();
        br.close();
    }

    static class Lecture implements Comparable<Lecture> {
        int p;
        int d;

        Lecture(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Lecture l) {
            if (this.d != l.d) {
                return l.d - this.d;
            }

            return l.p - this.p;
        }
    }
}
