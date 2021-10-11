package TwoPointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jota {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, jota = 0 ;
    static int[] a;

    public static void input() {
        N = scan.nextInt();
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
        }
    }

    public static void pro(){
        Arrays.sort(a);
        // Arrays.sort(a, 1, N+1) 로 표현해도 됨
        for (int i =0 ; i < N ; i++){
            int L = 0, R = N-1;
            while(L<R){
//                System.out.println(i);
//                System.out.println(L);
//                System.out.println(R);
//                System.out.println(a[L]+ " "+ a[R]);
//                System.out.println("a[i] = " + a[i]);
                if(L== i) {L++;
                continue;}
                if(R == i) {
                    R--;
                    continue;
                }

                int sum = a[L]+a[R];
                if(sum >a[i]){
                    R--;
                }else if ( sum < a[i]){
                    L++;
                }else{
//                    System.out.println(a[L]+ " "+ a[R]);
//                    System.out.println("a[i] = " + a[i]);
//                    System.out.println("jota");
                    jota++;
                    break;
                }
            }
        }
        System.out.println("jota = " + jota);
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
