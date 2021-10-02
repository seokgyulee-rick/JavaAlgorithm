import java.io.*;
import java.util.*;

public class base_code {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        col = new int[N + 1];
    }

    static int N, ans;
    static int[] col;

    static boolean attackable(int r1, int c1, int r2, int c2) {
        if(c1 == c2) return true;
        if(Math.abs(r2 - r1) ==Math.abs(c2-c1))
            return true;
        return false;
    }

    static void rec_func(int row) {
        if (row == N + 1) {
            ans ++;
            return;
        } else {
            for (int i = 1 ; i <= N; i++){
                    boolean isAttackable = false;
                    for (int j = 1 ; j<row; j++)
                    {
                        if(attackable(j,col[j],row,i)){
                            isAttackable = true;
                            break;
                        }
                    }
                    if(isAttackable == false ){
                        col[row] = i;
                        rec_func(row+1);
                        col[row] = 0;
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