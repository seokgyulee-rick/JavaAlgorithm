package Sort.SequenceSort;
import java.io.*;
import java.util.*;

public class SequenceSort {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> {

        /**
         * @param idx A 배열의 idx 위치를 기억하는 변수
         * @param num A[idx]의 원래 값
         */
        public int num, idx;

        @Override
        public int compareTo(Elem other) {
            // TODO
            // 정렬 조건에 맞게 정렬하기
            // 1. num 의 비내림차순
            if(num != other.num) return num - other.num;
            // 2. num이 같으면 idx 오름차순
            else return idx - other.idx;
        }
    }

    static int N;
    static int[] P;
    static Elem[] B;

    static void input() {
        N = scan.nextInt();
        B = new Elem[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = new Elem();
            B[i].idx = i;
            B[i].num = scan.nextInt();
            // TODO: Elem 의 정의에 맞게 B[i] 에 값을 넣어주기
        }
    }

    static void pro() {
        // TODO: B 배열 정렬하기
        Arrays.sort(B);
        // TODO: B 배열의 값을 이용해서 P 배열 채우기
        for (int i = 0 ; i < N ; i++){
            P[B[i].idx] = i;
        }
        // TODO: P 배열 출력하기
        for (int j =0 ; j <N ; j++){
            System.out.print(P[j]+" ");
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