package TwoPointer;

import com.sun.tools.jconsole.JConsoleContext;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jota2 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N ;
    static long ans = 0L;
    static int[] array, count;

    public static void input() {
        N = scan.nextInt();
        array = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            array[i] = scan.nextInt();
        }
    }

    public static void pro() {
        int answer = 0;
        Arrays.sort(array,1 ,N+1);
        for (int i = 1 ; i <= N ; i++){
            System.out.println(array[i]);
            int target = array[i];
            int left = 1, right= N;
            while(left < right){
                if(left == i) {
                    left++;
                    continue;
                }
                if(right == i) {
                    right--;
                    continue;
                }
                if(array[left]+ array[right] == target) {
                    answer++;
                    break;
                }
                else if(array[left]+ array[right] < target) left++;
                else if(array[left]+ array[right] > target) right--;
            }
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
