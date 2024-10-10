import java.util.*;
import java.io.*;

public class programmers12906 {
    static Stack<Integer> st = new Stack<>();
    static List<Integer> li = new ArrayList<>();
    static int idx = 0;
    public int[] solution(int []arr) {
        int[] answer;

        for(int i = 0; i < arr.length; i++){
            if(!st.isEmpty() && st.peek() == arr[i]) continue;
            st.push(arr[i]);
        }

        while(!st.isEmpty()){
            li.add(st.pop());
        }

        answer = new int[li.size()];

        for(int i = li.size() - 1; i >= 0; i--)
            answer[idx++] = li.get(i);

        return answer;
    }
}