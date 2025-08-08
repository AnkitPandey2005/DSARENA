package Recursion_MONUBHAIYA;

public class Count_Primes {
    public static void main(String[] args) {

    }
    public static boolean isprime(int n){
        int div=2;
        while(div*div<=n){
            if(n%div==0){
                return false;
            }
            div++;
        }
        return true;
    }
}
