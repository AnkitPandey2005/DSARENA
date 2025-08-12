package Recursion_MONUBHAIYA;

import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int n=in.nextInt();
        System.out.println(pow(a,n));
    }
    public static int pow(int a,int n){
//        if(n==0) return a;
//        return pow(a,n-1)*a;

        if(n==0) return a;
        int ans=pow(a,n-1);//sp //variey kr rha h
        return ans*a; //fix is multiply
    }
}
