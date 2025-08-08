package Sorting_Algorithm_MARK_15___MARK_22;

import java.util.Arrays;

public class InserationSort_Ascending {
    public static void main(String[] args) {
        int[] arr={5,3,4,2,1};
        inserationsort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void inserationsort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
    }
}
