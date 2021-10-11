package TwoPointer;

import java.io.*;
import java.util.StringTokenizer;

public class Cat2 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, jota = 0, ans = Integer.MIN_VALUE, len, cnt = 0 ;
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
    public static void add(int x){
        alpha[x]++;
        if(alpha[x]==1){
            cnt++;
        }
    }
    public static void erase(int y){
        alpha[y]--;
        if(alpha[y]==0){
            cnt--;
        }
    }

    public static void pro() {
        for (int j = 1, R =1; R <= len; R++) {
            add(a[R]-'a'+1);
            while (cnt >N) {
                erase(a[j]-'a'+1);
                j++;
            }
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
