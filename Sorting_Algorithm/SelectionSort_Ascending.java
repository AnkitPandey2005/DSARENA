package Sorting_Algorithm_MARK_15___MARK_22;

import java.util.Arrays;

public class SelectionSort_Ascending {
    public static void main(String[] args) {
        int[] arr={5,3,4,2,1};
        selectionsort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectionsort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int last=arr.length-i-1;
            int getmax=maximum(arr,0,last);
            swap(arr,getmax,last);
        }
    }
    public static int maximum(int[] arr,int start,int end){
        int max=start;
        for(int i=start;i<=end;i++){
            if(arr[i]>arr[max]){
                max=i;
            }
        }
        return max;
    }
    public static void swap(int[] arr,int index1,int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
}
