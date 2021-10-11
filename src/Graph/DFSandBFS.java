package Graph;


import java.io.*;
import java.util.*;

public class DFSandBFS {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static ArrayList<Integer>[] ary;
    static int[] visit;

    public static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        int num, num2;
        visit = new int[N + 1];
        ary = new ArrayList[N + 1];
        for (int k = 1; k <= N; k++) {
            ary[k] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= M; i++) {
            num = scan.nextInt();
            num2 = scan.nextInt();
            ary[num].add(num2);
            ary[num2].add(num);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(ary[i]);
        }
    }

    public static void dfs(int x) {
        visit[x] = 1;
        System.out.print(x + " ");
        for (int togo : ary[x]) {
            if (visit[togo] == 1) {
                continue;
            }
            dfs(togo);
        }
    }

    public static void bfs(int y) {
        Queue<Integer> que = new LinkedList<>();
        que.add(y);
        visit[y] = 1;
        while (!que.isEmpty()) {
            int num = que.poll();
            for (int togo : ary[num]) {
                if (visit[togo] == 0) {
                    que.add(togo);
                    visit[togo] = 1;
                }
            }
            System.out.print(num + " ");
        }


    }

    public static void main(String[] args) {
        input();
        dfs(V);
        visit = new int[N + 1];
        System.out.println();
        bfs(V);
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
