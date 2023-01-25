package TwoPointer;

import Sort.PartialSum.PartialSum;

import java.io.*;
import java.util.StringTokenizer;

public class SumofNum2 {
    static StringBuilder sb = new StringBuilder();
    static SumofNum.FastReader scan = new SumofNum.FastReader();

    static int Left=1 ,Right=1,ans =0;
    static int N,M;
    static int [] array;

    public static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        array = new int[N+1];
        for (int i = 1 ; i < N+1 ; i++){
            array[i] = scan.nextInt();
        }

    }
    public static void pro(){
        int sum = array[Left];
while(Left<=N ){
    if(sum == M) {
        ans++;
    }
    if(sum > M && Left+1 <=Right){
    // left-1 하나 뺀다.
        Left++;
    sum -= array[Left-1];
    }
    else{
        if(Right == N) break;
        Right++;
        sum += array[Right];
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