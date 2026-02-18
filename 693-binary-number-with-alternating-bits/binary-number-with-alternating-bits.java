class Solution {
    public boolean hasAlternatingBits(int n) {
      String binaryString = Integer.toBinaryString(n);
    //  System.out.println(binaryString);
      String s=binaryString;
      for(int i=1;i<s.length();i++){
        if(s.charAt(i)==s.charAt(i-1)){
            return false;
        }
      }
      return true;
    }
}

