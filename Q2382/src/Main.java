import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        ArrayList<HashMap> pages = new ArrayList<>();
        HashMap<String, Integer> all = new HashMap<>();
        int page_num = 0;
        int query_num = 0;

        while (!line.equals("E")) {
            if (line.charAt(0) == 'P') {
                page_num++;

                String[] keywords = line.split(" ");
                HashMap<String, Integer> corr = new HashMap<>();

                for (int i = 1; i < keywords.length; i++) {
                    corr.put(keywords[i].toLowerCase(), i);

                    if (!all.containsKey(keywords[i].toLowerCase())) {
                        all.put(keywords[i].toLowerCase(), 1);
                    }
                }

                pages.add(corr);
            } else if (line.charAt(0) == 'Q') {
                query_num++;

                String[] keywords = line.split(" ");
                int[] points = new int[page_num];
                int N = all.size();

                for (int i = 0; i < page_num; i++) {
                    HashMap<String, Integer> h = pages.get(i);
                    int point = 0;

                    for (int j = 1; j < keywords.length; j++) {
                        if (h.containsKey(keywords[j].toLowerCase())) {
                            point += (N + 1 - h.get(keywords[j].toLowerCase())) * (N + 1 - j);
                        }
                    }

                    points[i] = point;
                }

                int[] sorted = Arrays.copyOf(points, points.length);
                Arrays.sort(sorted);

                bw.write("Q" + query_num + ":");

                for (int i = page_num - 1; i >= Math.max(0, page_num - 5); i--) {
                    if (sorted[i] == 0) {
                        break;
                    }

                    for (int j = 0; j < page_num; j++) {
                        if (sorted[i] == points[j]) {
                            points[j] = 0;
                            bw.write(" P" + (j + 1));
                            break;
                        }
                    }
                }

                bw.write("\n");
            }

            line = br.readLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
