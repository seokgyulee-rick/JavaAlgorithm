package Graph;


import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Danji_BFS {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static int[][] map;
    static boolean[][] visit;
    static int[] x = {1, 0, -1, 0};
    static int[] y = {0, 1, 0, -1};
    static int[] danji = {};

    public static void input() {
        N = scan.nextInt();
        danji = new int[N * N];
        visit = new boolean[N + 1][N + 1];
        map = new int[N + 1][N + 1];
        for (int k = 1; k <= N; k++) {
            String strNum = scan.next();

            for (int i = 1; i <= N; i++) {
                map[k][i] = strNum.charAt(i - 1) - '0';
            }
        }
    }

    static class Pair {
        int c, d;

        Pair(int c, int d) {
            this.c = c;
            this.d = d;
        }
    }

    public static void dfs(int a, int b, int mark) {
        visit[a][b] = true;
        danji[mark]++;
        for (int i = 0; i < 4; i++) {
            if (N >= a + x[i] && a + x[i] >= 1 && N >= b + y[i] && b + y[i] >= 1
                    && map[a + x[i]][b + y[i]] == 1 && !visit[a + x[i]][b + y[i]]) {
                dfs(a + x[i], b + y[i], mark);
            }
        }

    }

    public static void bfs(int a, int b, int mark) {
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(a,b));
        visit[a][b] = true;
        while (!que.isEmpty()) {
            Pair p = que.poll();
            danji[mark]++;
//            System.out.println("p.c = " + p.c);
//            System.out.println("p.d = " + p.d);
//            System.out.println();
            for (int i = 0; i < 4; i++) {
                if (p.c +x[i]>= 1 && p.c +x[i] <= N && p.d + y[i] >= 1 && p.d +y[i]<= N
                        && map[p.c + x[i]][p.d + y[i]] == 1 && !visit[p.c + x[i]][p.d + y[i]]) {
                    que.add(new Pair(p.c+x[i],p.d+y[i]));
                    visit[p.c + x[i]][p.d + y[i]] = true;
                }
            }
        }
    }

    public static void pro() {
        int mark = 1;
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (map[k][i] == 1 && !visit[k][i]) {
//                    dfs(k, i, mark);
                    bfs(k,i,mark);
                    mark++;
                }
            }
        }
        mark--;
        System.out.println(mark);
        int[] new_danji = new int[mark];
        for (int i = 0; i < mark; i++) {
            new_danji[i] = danji[i + 1];
        }
        Arrays.sort(new_danji);
        for (int i = 0; i < mark; i++) {
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
