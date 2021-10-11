package TwoPointer;

import Sort.PartialSum.PartialSum;

import java.io.*;
import java.util.StringTokenizer;

public class SumofNum {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, M, ans = 0;
    static int[] a;

    public static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        a = new int [N+1];
        for (int i = 1 ; i <= N ; i++){
            a[i] = scan.nextInt();
        }
    }

    public static void pro(){
        int R , sum  ;
        for (int i = 1 ; i <= N ; i++){
            R = i-1;
            sum = 0 ;
            while( sum  < M && R+1 < N+1 ){
                R++;
                sum += a[R];
                if(sum == M ){
                    ans ++;
                }
            }
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
