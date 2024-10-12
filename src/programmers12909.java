import java.util.*;
import java.io.*;
class programmers12909 {
    static Stack<Character> st = new Stack<>();
    boolean solution(String s) {
        boolean answer = true;

        for(char c : s.toCharArray()){
            if(c == '(') st.push(c);
            else if(!st.isEmpty() && st.peek() == '('){
                st.pop();
            }else{
                return false;
            }
        }

        if(!st.isEmpty()) answer = false;

        return answer;
    }
}