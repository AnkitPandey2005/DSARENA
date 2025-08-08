package Sorting_Algorithm_MARK_15___MARK_22;

import java.util.Arrays;

public class BubbleSort_Ascending {
    public static void main(String[] args) {
        int[] arr={5,3,4,2,1};
        bubblesort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubblesort(int[] arr){
        boolean swapped;
        for(int i=0;i<arr.length;i++){
            swapped=false;
            for(int j=1;j<arr.length-i;j++){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
}
