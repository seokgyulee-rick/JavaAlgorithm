package Search.NQueen;

import java.io.*;
import java.util.*;

public class NQueen {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        col = new int[N + 1];
    }

    static int N, ans;
    static int[] col;

    static boolean attackable2(int r1, int c1, int r2, int c2) {
        // TODO
        //열

        //대각선
        for(int i = 1 ; i <= r1 ; i++){
            if (c2 == col[i]) return true;
            if (Math.abs(r2 - i) == Math.abs(c2 - col[i])) {
                //System.out.println("r1 = " + i + ", c1 = " + col[i] + ", r2 = " + r2 + ", c2 = " + c2);
                return true;
            }

        }
        return false;
    }

    static void rec_func(int row) {
        if (row == N + 1) {

            // TODO
            ans++;
            return;
        } else {
            // TODO
            if (row >= 2) {
                for (int j = 1; j <= N; j++) {
                    if(col[row-1] != 0){
                        if (!attackable2(row - 1, col[row - 1], row, j)) {
                            //System.out.println("row = " + row + " col[row-1] : " +col[row-1] + " j : "+ j);
                            col[row] = j;
                            rec_func(row + 1);
                        }
                    }
                }
                return;
            } else {
                for (int k = 1; k <= N; k++) {
                    col[row] = k;
                    rec_func(row + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        ans = 0;
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1);
        System.out.println(ans);
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