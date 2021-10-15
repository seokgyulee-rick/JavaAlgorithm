package Binary;

import Graph.DFSandBFS;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EatEaten2 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, A, B;
    static int[] aAry, bAry;
    public void input(){
        N = scan.nextInt();

        for (int i = 1 ; i <=N ; i++){
            A = scan.nextInt();
            B = scan.nextInt();
            aAry = new int[A];
            bAry = new int[B];
            for (int j = 0 ; j< A ; j++){
                aAry[j] = scan.nextInt();
            }
            for (int k = 0 ; k< B ; k++){
                bAry[k] = scan.nextInt();
            }
        }
    }

    public void pro(){
        Arrays.sort(bAry);

        for (int i = 0 ; i< A; i++){
            int L = 0, R = B-1, result =0;
            while(L<R){
                if(bAry[L+R/2] < aAry[i]){
                    result = L;
                    L = L+R/2 + 1;
                }
                else{
                    R = L+R/2 - 1;
                }

            }
        }

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
