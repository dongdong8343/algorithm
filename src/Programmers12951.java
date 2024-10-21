import java.util.*;
import java.io.*;
class Programmers12951 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(i == 0 || flag){
                flag = false;
                if(!Character.isDigit(c)) c = Character.toUpperCase(c);
            }else{
                c = Character.toLowerCase(c);
            }
            if(c == ' '){
                flag = true;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}