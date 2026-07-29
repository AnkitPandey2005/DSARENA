import java.math.BigInteger;
import java.util.*;

class Solution {
    public String smallestPalindrome(String s, int k) {
      
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

       
        String middle = "";
        int oddCount = 0;
        for (char c : freq.keySet()) {
            if (freq.get(c) % 2 != 0) {
                oddCount++;
                middle = String.valueOf(c);
            }
        }

       
        List<Character> firstHalfChars = new ArrayList<>();
        for (char c : freq.keySet()) {
            int count = freq.get(c) / 2;
            for (int i = 0; i < count; i++) {
                firstHalfChars.add(c);
            }
        }
        int n = firstHalfChars.size();
        if (n == 0) {
            return k == 1 ? middle : "";
        }

       
        Collections.sort(firstHalfChars);
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : firstHalfChars) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        List<Character> uniqueChars = new ArrayList<>(counts.keySet());
        Collections.sort(uniqueChars);

      
        BigInteger[] fact = new BigInteger[n + 1];
        fact[0] = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1].multiply(BigInteger.valueOf(i));
        }

      
        BigInteger numerator = fact[n];
        BigInteger denominator = BigInteger.ONE;
        for (char c : uniqueChars) {
            denominator = denominator.multiply(fact[counts.get(c)]);
        }
        BigInteger T = numerator.divide(denominator);

        StringBuilder sb = new StringBuilder();
        int sumRemaining = n;
        BigInteger kBig = BigInteger.valueOf(k);
        while (sumRemaining > 0) {
            boolean found = false;
            for (char c : uniqueChars) {
                int cnt = counts.get(c);
                if (cnt == 0) continue;

                BigInteger perm = T.multiply(BigInteger.valueOf(cnt)).divide(BigInteger.valueOf(sumRemaining));
                if (kBig.compareTo(perm) > 0) {
                    kBig = kBig.subtract(perm);
                } else {
                    sb.append(c);
                    counts.put(c, cnt - 1);
                    T = perm;
                    sumRemaining--;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return "";
            }
        }

        if (kBig.compareTo(BigInteger.ONE) != 0) {
            return "";
        }

        String firstHalf = sb.toString();
        String secondHalf = new StringBuilder(firstHalf).reverse().toString();
        return firstHalf + middle + secondHalf;
    }
}