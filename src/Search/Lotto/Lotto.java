package Search.Lotto;

import java.io.*;
import java.util.StringTokenizer;

public class Lotto {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static boolean input() {
        N = scan.nextInt();
        if (N == 0) return false;
        nums = new int[N + 1];
        ans = new int[7];
        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
        return true;
    }

    static int N;
    static int[] nums, ans;

    static void rec_func(int k) {
        if (k == 7) {
            for (int j = 1; j <= 6; j++) {
                System.out.print(ans[j] + " ");
            }
            System.out.println();
        } else {
            for (int t = k; t <= N; t++) {
                boolean psb = true;
                for (int c = 1; c <= k-1; c++) {
                    if (ans[c] == nums[t]|| ans[c]>=nums[t]) psb = false;
                }
                if (psb == true) {
                    ans[k] = nums[t];
                    rec_func(k + 1);
                }
            }
        }
    }

    public static void main(String[] args) {

        while (input()) {
            rec_func(1);
            System.out.println();
        }
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
