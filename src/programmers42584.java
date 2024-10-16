import java.util.*;

class programmers42584 {
    public int[] solution(int[] p) {
        int[] ret = new int[p.length];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < p.length; i++){
            while(!st.isEmpty() && p[st.peek()] > p[i]){
                int idx = st.pop();
                ret[idx] = i - idx;
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int idx = st.pop();
            ret[idx] = p.length - idx - 1;
        }

        return ret;
    }
}