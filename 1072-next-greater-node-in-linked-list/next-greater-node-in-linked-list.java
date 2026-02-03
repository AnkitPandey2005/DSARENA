class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> values = new ArrayList<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            values.add(cur.val);
        }
        int n = values.size();
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && values.get(stack.peek()) <= values.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = values.get(stack.peek());
            }
            stack.push(i);
        }
        return ans;
    }
}