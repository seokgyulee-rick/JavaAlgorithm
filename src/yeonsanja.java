import java.io.*;
import java.util.StringTokenizer;

public class yeonsanja {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, max, min;
    static int[] nums, operators, order;

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        operators = new int[5];
        order = new int[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
        for (int i = 1; i <= 4; i++) operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }
    public static void main(String[] args) {
        input();
        rec_func(1, nums[1]);
        System.out.println(max);
        System.out.println(min);
    }

    static void rec_func(int k,int ans){
        if(k == N){
            max = Math.max(ans, max);
            min = Math.min(ans,min);
         return;
        }
        else{
            for (int i = 1; i<=4;i++){
               if(operators[i]>0){
               operators[i]--;
                   order[k] = i;
                   rec_func(k+1, calculator(ans,i, nums[k+1] ));
                   order[k] = 0;
                   operators[i]++;
               }
            }
        }
    }

    static int calculator (int operand1, int operator, int operand2){
        if(operator == 1){
            return operand1 + operand2;
        } else if(operator == 2){
            return operand1 - operand2;
        }else if(operator == 3){
            return operand1 * operand2;
        }else{
            return operand1 / operand2;
        }
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
