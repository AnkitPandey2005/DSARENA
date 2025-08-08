package Recursion_MONUBHAIYA;

public class Geneate_Paratheses {
    public static void main(String[] args) {
        int n=3;
        Parantheses(n,0,0,"");

    }
    public static void Parantheses(int n,int closed,int open,String ans){
        if(open==n && closed==n){
            System.out.println(ans);
            return;
        }
        if(open>n || closed>open){
            return;
        }
        Parantheses(n,closed,open+1,ans+"(");
        Parantheses(n,closed+1,open,ans+")");
    }
}
