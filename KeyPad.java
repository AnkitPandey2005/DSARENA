package Recursion_MONUBHAIYA;

import java.util.ArrayList;

public class KeyPad {
    static String[] key={"","","abc","def","ghi","jkl","mno"};
    public static void main(String[] args) {
//        List<String> ll=new ArrayList<>();
        String ques="23";
//        Print(ques,"",ll);
//        System.out.println(ll);
    }
    public static void Print(String ques,String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }
        char ch=ques.charAt(0);
        String getString=key[ch-'0'];
        for(int i=0;i<getString.length();i++){
            Print(ques.substring(1),ans+getString.charAt(i));
        }
    }
}
