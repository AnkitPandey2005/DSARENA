class Solution {
    public int maximum69Number(int num) {
        int placevalue = 0; //at start it wil be at 0
        int placevaluesix = -1;
        int temp = num;

        while (temp > 0) {
            int rem = temp % 10;  

            if (rem == 6) {
                placevaluesix = placevalue;
            }
            temp = temp / 10; 
            placevalue++;
        }

        if (placevaluesix == -1) {
            return num;
        }

        // Add 3 * 10^placevaluesix to replace the leftmost 6 by 9
        return num + (int)(3 * Math.pow(10, placevaluesix));
    }
}
