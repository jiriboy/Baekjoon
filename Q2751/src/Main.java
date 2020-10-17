import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int[] arr;
    static int[] temp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, N - 1);

        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void mergeSort(int start, int end) {
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        merge(start, end);
    }

    static void merge(int start, int end) {
        int mid = (start + end) / 2;
        int p1 = start;
        int p2 = mid + 1;
        int pointer = start;

        while (p1 <= mid && p2 <= end) {
            if (arr[p1] < arr[p2]) {
                temp[pointer] = arr[p1];
                p1++;
                pointer++;
            } else {
                temp[pointer] = arr[p2];
                p2++;
                pointer++;
            }
        }

        while (p1 <= mid) {
            temp[pointer] = arr[p1];
            p1++;
            pointer++;
        }

        while (p2 <= end) {
            temp[pointer] = arr[p2];
            p2++;
            pointer++;
        }

        for (int i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
    }
}
