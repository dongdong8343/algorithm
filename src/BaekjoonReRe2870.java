import java.util.*;
import java.io.*;
public class BaekjoonReRe2870 {
    static List<String> li = new ArrayList<>();
    static void go(StringBuilder num){
        for(char c : num.toString().toCharArray()){
            if(num.length() != 1 && num.toString().charAt(0) == '0')
                num.deleteCharAt(0);
            else
                break;
        }
        li.add(num.toString());
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            StringBuilder num = new StringBuilder();
            for(char c : s.toCharArray()){
                if(!Character.isDigit(c)){
                    if(num.length() != 0)
                        go(num);
                    num.setLength(0);
                }
                else{
                    num.append(c);
                }
            }
            if(!num.isEmpty())
                go(num);
            num.setLength(0);
        }
        Collections.sort(li, ((o1, o2)->{
            if(o1.length() == o2.length())
                return o1.compareTo(o2);
            return o1.length() - o2.length();
        }));
        for(String s : li)
            System.out.println(s);
    }
}
