import java.util.*;
import java.io.*;

public class Inflearn1_8 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        // 문자열 돌면서 문자가 알파벳이면 소문자로 바꿔서 sb에 넣는다.
        for(char c : s.toCharArray()){
            if(Character.isAlphabetic(c)) sb.append(Character.toLowerCase(c));
        }

        // 기존의 문자열과 거꾸로 읽었을 때 문자열이 동일 하다면 YES를 출력 아니면 노!
        if(sb.toString().equals(sb.reverse().toString())) System.out.println("YES");
        else System.out.println("NO");

        return ;
    }
}