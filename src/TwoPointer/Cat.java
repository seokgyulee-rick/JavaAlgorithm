package TwoPointer;

import java.io.*;
import java.util.StringTokenizer;

public class Cat {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, jota = 0, ans = Integer.MIN_VALUE, len;
    static int[] a, alpha;

    public static void input() {
        N = scan.nextInt();
        String st = scan.next();
        alpha = new int[27];
        len = st.length();
        a = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            a[i] = st.charAt(i - 1);
        }
    }

    public static void pro() {
        int R = 0;
        int cnt = 0;
        for (int j = 1; j <= len; j++) {
            while (R < len && cnt <= N) {
                if (alpha[a[R+1] - 96] == 0) { // 앞의 R이 안쓰인 것이면,
                    if (cnt == N) break;
                    cnt++;
                }
                if(cnt <= N) R++; // N 개 이하의 알파벳이 쓰였으면, R 증가
                alpha[a[R] - 96]++;
            }

            alpha[a[j] - 96]--;
            if (alpha[a[j] - 96] == 0) cnt--;

            ans = Math.max(ans, R - j + 1);
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
