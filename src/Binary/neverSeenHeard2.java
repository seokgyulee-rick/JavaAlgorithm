package Binary;

import java.io.*;
import java.util.*;

public class neverSeenHeard2 {
    static FastReader scan = new FastReader();
    static int N, M;
    static String[] h, s;
    static ArrayList<String> answer = new ArrayList<>();
    public static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        h = new String[N+1];
        s = new String[M+1];
        for (int i = 1;  i <= N; i++){
            h[i] = scan.next();
        }
        for (int i = 1; i<= M ; i++){
            s[i] = scan.next();
        }
        Arrays.sort(s,1,M);
    }
    public static void pro(){
        for (int i = 1;  i <= N; i++){
            String target = h[i];
            int left = 1, right= M;
            while(left<right){
                int a= (left+right)/2;
                if(target.equals(s[a])){
//                    System.out.println(s[a]);
                    answer.add(s[a]);
                    break;
                }
                if(target.compareTo(s[a])<0){
                    right = right-1;
                }else {
                    left = left + 1;
                }
            }
        }
        Collections.sort(answer);

        for (int i = 0 ; i < answer.size(); i++){
            System.out.println(answer.get(i));
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
