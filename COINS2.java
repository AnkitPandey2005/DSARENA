package Recursion_MONUBHAIYA;

public class COINS2 {
    public static void main(String[] args) {
        int n=3;
        CoinToss(n,"");
    }
    public static void CoinToss(int n,String a){
        if(n==0){
            System.out.println(a);
            return;
        }
        if(a.length()==0 ||a.charAt(a.length()-1) !='H'){
            CoinToss(n-1,a+"H");
        }
        CoinToss(n-1,a+"T");
    }
}
