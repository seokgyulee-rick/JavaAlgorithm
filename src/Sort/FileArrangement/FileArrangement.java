package Sort.FileArrangement;

import Sort.LangEngMath.LangEngMath;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FileArrangement {

    static class FileElem implements Comparable<FileElem>{
        public  String file, ext;
        @Override
        public int compareTo(FileElem other) {
            if(ext != other.ext)return ext.compareTo(other.ext);
            return file.compareTo(other.file);
        }

    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static FileElem[] e;
    static ArrayList<answer> ans;

    static class answer{
        String fileName;
        int cnt;
    }

    public static void input() {
        N = scan.nextInt();
        e = new FileElem[N ];

        for (int i = 0; i < N; i++) {
            
            e[i] = new FileElem();
            e[i].file = scan.next();
            e[i].ext = e[i].file.substring(e[i].file.indexOf('.') + 1);
            e[i].file = e[i].file.substring(0, e[i].file.indexOf('.') );
        }
    }

    public static void sortCnt(){
        ans = new ArrayList<answer>();
        int cnt = 0 ;
        String extname ;
        for (int i = 0 ; i<N; i++){
            if(i == 0 ){
                cnt = 1;
                answer tmp = new answer();
                tmp.fileName = e[i].ext;
                tmp.cnt = cnt;
                ans.add(tmp);
            }else{
              if(!e[i].ext.equals( e[i-1].ext)){
                  answer tmp = new answer();
                  tmp.fileName = e[i].ext;
                  cnt = 1;
                  tmp.cnt = cnt;
                  ans.add(tmp);
              }else{
                  ans.get(ans.size()-1).cnt++;
              }
            }
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(e);
        sortCnt();
        for(int i = 0 ; i< ans.size(); i++){
            System.out.println(ans.get(i).fileName + " "+ ans.get(i).cnt);
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
