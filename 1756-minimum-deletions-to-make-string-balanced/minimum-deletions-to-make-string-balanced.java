class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> st = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If current char is 'a' and top of stack is 'b', remove that 'b' (count as deletion)
            if (!st.isEmpty() && ch == 'a' && st.peek() == 'b') {
                st.pop();
                cnt++;
            } else {
                st.push(ch);
            }
        }

        return cnt;
    }
}
