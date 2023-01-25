package Sort.PartialSum;

import java.io.*;
import java.util.StringTokenizer;

public class PartialSumTwo {

    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int n, S;
    static int[] a;

    static void input() {
        n = scan.nextInt();
        S = scan.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
        }
    }

    /**
     * 10 15
     * 5 1 3 5 10 7 4 9 2 8
     */
    static void pro() {
        int R = 0, sum = 0, ans = n + 1;
        for (int L = 1; L <= n; L++) {
            // L - 1 을 구간에서 제외하기
            sum -= a[L-1];
            // R 을 옮길 수 있을 때 까지 옮기기
            while(sum < S){
                if(R >= n) break;
                R++;
                sum += a[R];
                System.out.println("sum : "+ sum +" R: "+R);
            }
            // [L ... R] 의 합, 즉 sum이 조건을 만족하면 정답 갱신하기
            if(sum>=S){
//                System.out.println(sum +" "+ n);
                System.out.println("R: "+R+" L: "+ L );
                ans = ans > R - L + 1? R - L + 1: ans;
            }

        }

        // ans 값을 보고 불가능 판단하기
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