package CodingTest;

public class Money {

    static int [][] money = {{100,3},{200,1},{50,2}};
//    static int [][]money = {{2500,3},{700,5}};
    static int N, A,B, sum, bMoney, diff;
    public static void main(String[] args) {
        solution(money);
    }

    public static int solution (int[][]money){
        String[] before = {"A","B","C"};
        for(String i:before){
            System.out.println("i = " + i);
        }
        System.out.println(before);
        N=0;
        sum=0;
        diff = Integer.MAX_VALUE;
        for (int i = 0; i<money.length;i++){
            for (int j =0; j<money[i][1];j++) {
                N ++;
                sum += money[i][0];
            }
        }
        rec_func(money, 0, 0);
        System.out.println("diff = " + diff);
        return 0;
    }

    public static void rec_func(int [][]money, int k, int bMoney) {
        if (k == N) {
            // B가 돈을 다 고른 상태
            return;
        } else {
            for (int i = 0; i < money.length; i++) {
                if (money[i][1] > 0) {
                    money[i][1]--;
                    bMoney+=money[i][0];
                    sum -= money[i][0];
                    diff = Math.min(diff, Math.abs(sum-bMoney));
                    rec_func(money,k+1,bMoney);
                    bMoney-=money[i][0];
                    sum += money[i][0];
                    money[i][1]++;
                }
            }
        }
    }
}
