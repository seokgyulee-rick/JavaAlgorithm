package Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Danji {

    static DFSandBFS.FastReader scan = new DFSandBFS.FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static int[][] map;
    static boolean[][] visit;
    static int []x = {1,0,-1,0};
    static int []y = {0,1,0,-1};

    public static void input() {
        N = scan.nextInt();
        visit = new boolean[N + 1][N + 1];
        map = new int[N + 1][N + 1];
        for (int k = 1; k <= N; k++) {
            String strNum =scan.next();

            for (int i = 1; i <= N; i++) {
//                System.out.println(i);
//                System.out.println("strNum = " + strNum);
//                System.out.println("strNum = " + strNum.length());
//                System.out.println("strNum = " + strNum.charAt(6));
                map[k][i] = strNum.charAt(i-1)-'0';
            }
        }
    }

    public static void dfs(int a, int b, int mark) {
        visit[a][b] = true;
        for (int i = 0; i<4 ; i++){
            if(N>=a+x[i]&& a+x[i] >=1 && N>=b+y[i] && b+y[i]>=1&& map[a+x[i]][b+y[i]]==1){
                dfs(a+x[i], b+y[i], mark);
            }
        }

    }

    public static void pro() {
        int mark = 1;
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if(map[k][i] ==1 && !visit[k][i]){
                    dfs(k,i, mark );
                    mark++;
                }
            }
        }
        System.out.println("mark = " + mark);
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
