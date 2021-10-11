package Sort.Card;

import java.io.*;
import java.util.*;

public class CardSort {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static long[] a;

    static void input() {
        N = scan.nextInt();
        a = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = scan.nextLong();
        }
    }

    static void pro() {
        // Sort 정렬하기
        Arrays.sort(a,1,N+1);
        // mode: 최빈값, modeCnt: 최빈값의 등장 횟수, curCnt: 현재 값(a[1])의 등장 횟수
        long mode = a[1];
        int modeCnt = 1, curCnt = 1;

        // TODO
        // 2번 원소부터 차례대로 보면서, 같은 숫자가 이어서 나오고 있는 지, 새로운 숫자가 나왔는 지를 판단하여
        // curCnt를 갱신해주고, 최빈값을 갱신하는 작업.
        for (int i =2; i<=N ; i++){
//            System.out.println("a[i] = " + a[i]);
//            System.out.println("a[i-1] = " + a[i-1]);
            if(a[i] == a[i-1]){
//                System.out.println("if");
                curCnt++;
                if(modeCnt< curCnt){
//                    System.out.println("mode = " + mode);
//                    System.out.println("modeCnt = " + modeCnt);
//                    System.out.println("curCnt = " + curCnt);
//                    System.out.println("a[i] = " + a[i]);
                    modeCnt = curCnt;
                    if(mode != a[i]) mode = a[i];
//                    System.out.println("mode in if = " + mode);
                }
            }else{
//                System.out.println("else");
                curCnt = 1;
            }
        }
        // 정답 출력하기
        System.out.println(mode);
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