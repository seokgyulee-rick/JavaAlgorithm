package Sort.Card;
import java.io.*;
import java.util.*;

public class CardHash {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static long[] a;
    static Map<Long,Integer> map = new HashMap();

    static void input() {
        N = scan.nextInt();
        a = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = scan.nextLong();

//            System.out.println("a[i] = " + a[i]);
//            System.out.println("map.get(a[i]) = " + map.get(a[i]));
        }
        for(int j = 1; j <=N ; j++){
            if(map.containsKey(a[j])) {
                map.put(a[j], map.get(a[j]) + 1);
            }else{
                map.put(a[j], 1);
            }
        }
    }

    static void pro() {
        // Sort 정렬하기

        // mode: 최빈값, modeCnt: 최빈값의 등장 횟수, curCnt: 현재 값(a[1])의 등장 횟수
        long mode = a[1];
        int modeCnt = 1, curCnt = 1;

        int maxValue = Collections.max(map.values());
        Long maxKey = Long.MAX_VALUE;
        for(Long key:map.keySet()) {
            if(maxValue == map.get(key)){
                maxKey = Math.min(maxKey,key);

            }
        }
        System.out.println(maxKey);
        // TODO
        // 2번 원소부터 차례대로 보면서, 같은 숫자가 이어서 나오고 있는 지, 새로운 숫자가 나왔는 지를 판단하여
        // curCnt를 갱신해주고, 최빈값을 갱신하는 작업.

        // 정답 출력하기
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