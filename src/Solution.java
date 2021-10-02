import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int numbers [] = {3, 30, 34, 5, 9};
        Solution sol = new Solution();
        String answer = sol.solution(numbers);
        System.out.println(answer);
    }
    String solution(int[] numbers){
        String answer = "";

        List<Integer> list = new ArrayList<>();
        for (int i =  0 ; i < numbers.length; i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, (a, b) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            System.out.println("as = " + as);
            System.out.println("bs = " + bs);
            System.out.println(-Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as)));
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }
        answer = sb.toString();
                    return answer;
//        if(answer.charAt(0) == '0') {
//            return "0";
//        }else {
//            return answer;
//        }
    }
}
