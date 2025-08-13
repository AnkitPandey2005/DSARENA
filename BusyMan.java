package Recursion_MONUBHAIYA;

import java.util.Comparator;
import java.util.*;

public class BusyMan {
    public void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Pair [] arr=new Pair[n];
        for(int i=0;i<n;i++){
            int st=sc.nextInt();
            int et=sc.nextInt();
            arr[i]=new Pair(st,et);
        }
        Arrays.sort(arr,new Comparator<Pair>(){
            @Override
            public int compare(Pair o1,Pair o2){
                return o1.et-o2.et;
            }
        });
        int activitie=1;
        int end=arr[0].et;
        for(int i=1;i<arr.length;i++){
            if(arr[i].st>=end){
                activitie++;
                end=arr[i].et;
            }
        }
        System.out.println(activitie);
    }
    class Pair{
        int st;
        int et;
        public Pair(int si,int ei){
            this.st=st;
            this.et=et;
        }
    }
}
