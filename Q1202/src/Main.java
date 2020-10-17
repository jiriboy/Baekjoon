import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Gem[] gems = new Gem[n];
        int[] bags = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            gems[i] = new Gem(m, v);
        }

        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(gems);
        Arrays.sort(bags);

        long answer = 0;

        int gemPointer = 0;
        int bagPointer = 0;

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        while (bagPointer < k) {
            while (gemPointer < n && gems[gemPointer].m <= bags[bagPointer]) {
                queue.offer(gems[gemPointer].v);
                gemPointer++;
            }

            if (!queue.isEmpty()) {
                answer += queue.poll();
            }

            bagPointer++;
        }

        bw.write(Long.toString(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    static class Gem implements Comparable<Gem> {
        int m;
        int v;

        Gem(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Gem g) {
            return this.m - g.m;
        }
    }
}