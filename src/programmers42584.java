import java.util.*;

class programmers42584 {
    public int[] solution(int[] p) {
        int[] ret = new int[p.length];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < p.length; i++){
            // 스택이 비어있지않고 현재 주식 가격이 스택 맨 위의 값보다 떨어진 경우 스택을 pop해서 기간을 배열에 기록함.
            while(!st.isEmpty() && p[st.peek()] > p[i]){
                int idx = st.pop();
                ret[idx] = i - idx;
            }
            st.push(i);
        }

        // 스택에 값들이 남아있다면 돌면서 기간을 배열에 기록함.
        while(!st.isEmpty()){
            int idx = st.pop();
            ret[idx] = p.length - idx - 1;
        }

        return ret;
    }
}