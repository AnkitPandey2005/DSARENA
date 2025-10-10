class Pair<K, V> {
    public K key;
    public V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class StockSpanner {
    Stack<Pair<Integer, Integer>> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!st.isEmpty() && st.peek().key <= price) {
            span += st.peek().value;
            st.pop();
        }
        st.push(new Pair<>(price, span));
        return span;
    }
}
