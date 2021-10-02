import java.util.ArrayList;
import java.util.List;

public class moigosa {
    public static void main(String[] args) {
        int answers[] = {1,3,2,4,2};
        moigosa m = new moigosa();
        m.solution(answers);
    }
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<Integer>();
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int a_score = 0;
        int b_score = 0;
        int c_score = 0;
        for (int i =0 ; i < answers.length; i++){
            if (answers[i] == a[i % a.length]){
                a_score++;
            }
            if (answers[i] == b[i % b.length]){
                b_score++;
            }
            if (answers[i] == c[i % c.length]) {
                c_score++;
            }
        }
        int max = Math.max(a_score, Math.max(b_score,c_score));
        if (max == a_score) list.add(1);
        if (max == b_score) list.add(2);
        if (max == c_score) list.add(3);
        int[] answer = list.stream().mapToInt(i->i.intValue()).toArray();
//        System.out.println("c_score = " + c_score);
//        System.out.println("b_score = " + b_score);
//        System.out.println("a_score = " + a_score);


        return answer;
    }
}
