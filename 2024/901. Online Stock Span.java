import java.util.Stack;

class StockSpanner {
    Stack<Pair> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        if (st.isEmpty()) {
            st.push(new Pair(price, 1));
            return 1;
        }

        int span = 1;

        while (!st.isEmpty() && st.peek().num <= price) {
            span += st.pop().span;
        }

        st.push(new Pair(price, span));
        return span;
    }
}

class Pair {
    int num;
    int span;

    public Pair(int num, int span) {
        this.num = num;
        this.span = span;
    }
}

