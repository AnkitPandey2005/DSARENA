package Sorting_Algorithm_MARK_15___MARK_22;

import java.util.Arrays;

public class MergeSort_Ascending {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr,int si,int ei){
        //base case::
        if(si>=ei){ //si>ei invalid || si==ei means single element already sorted
            return;
        }
        int mid=si+(ei-si)/2;
        mergeSort(arr,0,mid);
        mergeSort(arr,mid+1,ei);

        merge(arr,si,mid,ei);
    }
    public static void merge(int[] arr,int si,int mid,int ei){
        int[] temp=new int[ei-si+1];
        int i=si; //first sorted array
        int j=mid+1; //second sorted array
        int k=0;

        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }

        while(j<=ei){
            temp[k++]=arr[j++];
        }

        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }
}
