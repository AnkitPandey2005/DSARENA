import java.util.ArrayList;

class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0, j = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                ans.add(arr1[i++]);
            } else {
                ans.add(arr2[j++]);
            }
        }

        while (i < n1) {
            ans.add(arr1[i++]);
        }

        while (j < n2) {
            ans.add(arr2[j++]);
        }

        int n = n1 + n2;
        if (n % 2 == 1) {
            return ans.get(n / 2);
        } else {
            return (ans.get(n / 2) + ans.get(n / 2 - 1)) / 2.0;
        }
    }
}
