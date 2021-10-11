package TwoPointer;

import java.io.*;
import java.util.StringTokenizer;

public class Sequence_TP {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K, ans = Integer.MIN_VALUE;
    static int[] a;

    public static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        a = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
        }

    }

    public static void pro() {
        int sum = 0;
        for (int i = K; i <= N; i++) {
            if( i == K) {
                for (int j = 1 ; j <= K ; j ++){
                    sum += a[j];
                }
            }
            else{
                sum -= a[i-K];
                sum += a[i];
            }
            System.out.println("sum = " + sum);
            ans=Math.max(sum, ans);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
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
