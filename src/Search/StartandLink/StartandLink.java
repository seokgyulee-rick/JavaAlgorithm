package Search.StartandLink;

import java.io.*;
import java.util.StringTokenizer;

public class StartandLink {


    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++) {
                nums[i][j] = scan.nextInt();
            }
        team = new int[N + 1];
        ans = Integer.MAX_VALUE;
        teamCnt = 0;
    }

    static int N, S, ans, teamCnt;
    static int[][] nums;
    static int[] team;

    static void rec_func(int k) {
        if (k == N + 1) {
            if (teamCnt == N / 2) { // 팀 조합이 갖춰진 상태
                int teamA = 0;
                int teamB = 0;
                for (int i = 1; i < N; i++) {
                    for (int j = i + 1; j <= N; j++) {
                        if (team[i] == 1 && team[i] == team[j]) teamA = teamA + nums[i][j] + nums[j][i];
                        if (team[i] == 0 && team[i] == team[j]) teamB = teamB + nums[i][j] + nums[j][i];
                    }
                }

                ans = Math.min(ans, Math.abs(teamA - teamB));
            }
        } else {
            // 팀선택 한다
            //선택 o
            team[k] = 1;
            teamCnt++;
            rec_func(k + 1);
            teamCnt--;

            // 선택 x
            team[k] = 0;
            rec_func(k + 1);
        }
    }

    public static void main(String[] args) {
        input();

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
