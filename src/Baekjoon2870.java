import java.io.*;
import java.util.*;
public class Baekjoon2870 {
    static StringBuilder go(StringBuilder s){
        while(true){
            if(s.length() == 1 && s.toString().charAt(0) == '0')
                break;
            if(s.toString().charAt(0) == '0'){
                s.deleteCharAt(0);
            }
            else
                break;
        }
        return s;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> li = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            String word = br.readLine();
            for(char c : word.toCharArray()){
                if(Character.isDigit(c)){
                    sb.append(c);
                }else{
                    if(sb.length() > 0){
                        li.add(go(sb).toString());
                        sb = new StringBuilder();
                    }
                }
            }
            if(sb.length() > 0){
                li.add(go(sb).toString());
            }
        }
        Collections.sort(li, ((o1, o2) ->  {
            if(o1.length() == o2.length()){
                return o1.compareTo(o2); // 사전 순으로 비교
            }
            return o1.length() - o2.length();
        }));
        for(String s : li)
            System.out.println(s);
    }
}
