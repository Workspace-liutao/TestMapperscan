package mapperscan.Tree;

public class FeiBoNaqie {
    public static void main(String[] args) {
        FeiBoNaqie feiBoNaqie = new FeiBoNaqie();
//        int n=9;
//        int [] result = new int[n+1];
//        System.out.println(feiBoNaqie.fin(n,result));
//        System.out.println(feiBoNaqie.fin(n));
        int [] n=new  int[]{1,2,5};
        System.out.println(feiBoNaqie.coinChange(n,11));
    }

    public int fin(int n, int[] result) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (result[n] > 0) {
            return result[n];
        }
        int end = fin(n - 1, result) + fin(n - 2, result);
        result[n] = end;
        return end;
    }

    public int fin(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
       return fin(n - 1) + fin(n - 2);
    }

    public int coinChange(int[] coins, int amount) {
        int []  result = new int [amount+1];
        return dfs(coins,result,amount);
    }
    public int   dfs(int[] coins,int []  result,int amount){
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return -1;
        }
        if(result[amount]!=0){
            return result[amount];
        }
        int min =Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int end = dfs(coins,result,amount-coins[i]);
            if(end>=0 && end<min ){
                min =end+1;
            }
        }
        result[amount]=min;
        if(min ==Integer.MAX_VALUE){
            return -1;
        } else{
            return min;
        }
    }
}
