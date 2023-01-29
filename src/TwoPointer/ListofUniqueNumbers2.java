package TwoPointer;

import java.io.*;
import java.util.StringTokenizer;

public class ListofUniqueNumbers2 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int answer = 0;
    static int[] array;
    static int[] countArray;

    static void input() {
        N = scan.nextInt();
        array = new int[N + 1];
        countArray = new int[100000+1];
        for (int i = 1; i <= N; i++) {
            array[i] = scan.nextInt();
        }
    }
    static void pro(){

        for (int left = 1, right = 0 ; left <= N ; left++){
            while(right+1 <= N && countArray[array[right+1 ]] == 0){
                right++;
                countArray[array[right ]]++;
            }
            answer += right - left +1;
            countArray[array[left ]]--;
//        int left = 1, right = 1;
//        countArray[array[left ]] =1;
////        boolean rightMoveChecker = true;
//        while(left < N+1){
//            if(right == N){
////                System.out.println("a");
//                answer += right - left+1;
//                countArray[array[left]] =0;
//                left++;
//            }else {
//                if (countArray[array[right + 1]] == 0) {
////                    System.out.println("b");
//                    countArray[array[right]] = 1;
//                    right++;
//                } else {
////                    System.out.println("c");
//                    answer += right - left + 1;
//                    countArray[array[left]] = 0;
//                    left++;
//                }
//            }
//            System.out.println("left: "+left+ " right: "+ right+" answer: "+answer);
//
//
//
////            if(right == N) countArray = new int[100000];
////            System.out.println(countArray[right]+" "+right);
//                if(countArray[array[right]]!= 0 ){ // 중복이다.
//                    System.out.println("a right: "+right );
//                    answer += right - left;
//                    countArray[array[left]] = 0;
//                    left++;
//    //                answer +=( right - left+1);
//                }else{ // 아니다.
//                    System.out.println("b");
//                    countArray[array[right]] = 1;
//    //                answer++;
//                    if(right <= N-1) { //끝이다.
//                    }else{ //아니다.
//                        answer += right - left+1;
//                        countArray[array[left]] = 0;
//                        left++;
//                    }
//                }
//
//            System.out.println("left: "+left+ " right: "+ right+" answer: "+answer);
        }
        System.out.println(answer);
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
/**
 *
 * 왼쪽에서 오다가, 중복되면, 그때 카운트 해서, 하나 줄이고
 * 왼쪽부터 시작
 */