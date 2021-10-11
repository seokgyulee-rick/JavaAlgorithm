package TwoPointer;

import java.io.*;
import java.util.StringTokenizer;

public class ListofUniqueNumbers {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N ;
    static long ans = 0L;
    static int[] a, count;

    public static void input() {
        N = scan.nextInt();
        count = new int[N + 1];
        a = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
        }
    }

    public static void pro() {
        int R = 1;
        count[a[1]] =1;
        for (int L = 1; L <= N; L++) {
            boolean possible = true;
            count[a[L - 1]] = 0;
            while (R < N && possible) {
                if (count[a[R+1]] == 0) {
                    R++;
//                    System.out.println("a[R] = " + a[R]);
//                    System.out.println("count[a[R]] = " + count[a[R]]);
                    possible = true;
                    count[a[R]] = 1;
                } else {
                    possible = false;
                }
            }
//            System.out.println("R = " + R);
            ans += R - L + 1;
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
