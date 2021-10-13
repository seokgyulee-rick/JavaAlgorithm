package Graph;

import javax.lang.model.SourceVersion;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Danji {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static int[][] map;
    static boolean[][] visit;
    static int []x = {1,0,-1,0};
    static int []y = {0,1,0,-1};
    static int []danji ={};

    public static void input() {
        N = scan.nextInt();
        danji = new int[N*N];
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
//                System.out.println("map[k][i] = " + map[k][i]);
//                System.out.println("visit[k][i] = " + visit[k][i]);
            }
        }
    }

    public static void dfs(int a, int b, int mark) {
        visit[a][b] = true;
        danji[mark]++;
//        System.out.println("a  = " + a+ " b = " + b);
        for (int i = 0; i<4 ; i++){
            if(N>=a+x[i]&& a+x[i] >=1 && N>=b+y[i] && b+y[i]>=1&& map[a+x[i]][b+y[i]]==1 && visit[a+x[i]][b+y[i]]==false){
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
        mark--;
        System.out.println(mark);
        int [] new_danji = new int[mark];
        for (int i = 0 ; i <mark ; i++){
           new_danji[i] = danji[i+1];
        }
        Arrays.sort(new_danji);
        for (int i = 0 ; i <mark ; i++){
            System.out.println(new_danji[i]);
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
