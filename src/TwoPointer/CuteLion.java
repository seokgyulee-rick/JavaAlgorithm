package TwoPointer;

import java.io.*;
import java.util.StringTokenizer;

public class CuteLion {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
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
        int R = 0, minCnt = N + 1, lionCnt = 0, cnt = 0;
        for (int L = 1; L <= N; L++) {
            if (a[L] == 1) {
                cnt = R - L + 1;
                while (R < N && lionCnt < K) {
                    R++; // 한칸 이동
                    cnt++;
//                    System.out.println("a[R] = " + a[R]);
                    if (a[R] == 1) lionCnt++;
                }
                if (lionCnt == K) minCnt = Math.min(minCnt, cnt);
                lionCnt--;
            }
        }
        if (minCnt == N + 1) minCnt = -1;
        System.out.println(minCnt);
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
