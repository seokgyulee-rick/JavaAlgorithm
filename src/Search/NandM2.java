package Search;

import java.io.*;
import java.util.StringTokenizer;

public class NandM2 {
        static StringBuilder sb = new StringBuilder();
        static int N,M;
        static int[] selected;
        static int[] used;

        static void input(){
            FastReader scan = new FastReader();
            N = scan.nextInt();
            M = scan.nextInt();
            selected = new int[M+1];
            used = new int[N+1]; // 1,2,3,4
        }
        // Recurrence Function (재귀 함수)
        // 만약 M 개를 전부 고름   => 조건에 맞는 탐색을 한 가지 성공한 것!
        // 아직 M 개를 고르지 않음 => k 번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
        public static void main(String[] args) {
            input();

            rec_func(1);
            System.out.println(sb.toString());
        }
        static void rec_func(int k){
            if(k == M +1) {
                for (int i = 1; i <= M; i++) {sb.append((selected[i])).append(' ');
                    //System.out.println("selected  "+i+" : " + selected[i]);
                }
                sb.append('\n');
            } else {
                for (int cand = 1; cand <= N ; cand ++){
                    // k 번째에 cand가 올수 잇으면
                    if( used[cand] == 0 ) {
                        selected[k] = cand;
                        used[cand] = 1;
                        rec_func(k + 1);
                        used[cand] = 0;
                        selected[k] = 0;
                    }
                }
            }
        }


        static class FastReader{
            BufferedReader br;
            StringTokenizer st;

            public FastReader(){
                br = new BufferedReader(new InputStreamReader(System.in));
            }
            public FastReader(String s ) throws FileNotFoundException {
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
