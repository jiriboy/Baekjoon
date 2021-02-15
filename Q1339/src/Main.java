import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    static int N;
    static int answer;
    static int max_depth;
    static String[] words;
    static int[] mapper;
    static char[] chars;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        words = new String[N];
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();

            for (char c : words[i].toCharArray()) {
                set.add(c);
            }
        }

        chars = new char[set.size()];

        Iterator<Character> iter = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            chars[i] = iter.next();
        }

        answer = 0;
        max_depth = set.size();
        mapper = new int[26];
        visited = new boolean[max_depth];

        permutation(0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void permutation(int depth) {
        if (depth == max_depth) {
            answer = Math.max(answer, calc());
            return;
        }

        for (int i = 0; i < max_depth; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            mapper[chars[i] - 'A'] = 9 - depth;
            permutation(depth + 1);
            visited[i] = false;
            mapper[chars[i] - 'A'] = 0;
        }
    }

    static int calc() {
        int result = 0;

        for (int i = 0; i < N; i++) {
            int temp = 0;

            for (int j = 0; j < words[i].length(); j++) {
                temp = 10 * temp + mapper[words[i].charAt(j) - 'A'];
            }

            result += temp;
        }

        return result;
    }
}
