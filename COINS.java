package Recursion_MONUBHAIYA;

public class COINS {
    public static void main(String[] args) {
        int n=3;
        CoinToss(n,"");
    }
    public static void CoinToss(int n,String a){
        if(n==0){
            System.out.println(a);
            return;
        }
        CoinToss(n-1,a+"H");
        CoinToss(n-1,a+"T");
    }
}
