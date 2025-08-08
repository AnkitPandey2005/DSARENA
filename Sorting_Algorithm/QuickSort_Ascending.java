package Sorting_Algorithm_MARK_15___MARK_22;

import java.util.Arrays;

public class QuickSort_Ascending {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quicksort(int[] arr,int si,int ei){
        //base case::
        if(si>=ei){
            return;
        }
        int pIdx=partition(arr,si,ei);
        quicksort(arr,si,pIdx-1);
        quicksort(arr,pIdx+1,ei);
    }
    public static int partition(int[] arr,int si,int ei){
        int pivot=arr[ei];

        int i=si-1;

        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp=pivot;
        arr[ei]=arr[i];
        arr[i]=temp;
        return i;
    }
}
