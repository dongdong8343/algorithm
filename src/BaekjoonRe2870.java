import java.io.*;
import java.util.*;
public class BaekjoonRe2870 {
    static String go(StringBuilder sb){
        while(true){
            if(sb.length() == 1 && sb.toString().equals("0"))
                break;
            if(sb.toString().charAt(0) == '0')
                sb.deleteCharAt(0);
            else
                break;
        }
        return sb.toString();
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<String> li = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(char c : s.toCharArray()){
                if(Character.isDigit(c))
                    sb.append(c);
                else{
                    if(sb.length() != 0){
                        li.add(go(sb));
                        sb.setLength(0);
                    }
                }
            }
            if(sb.length() != 0){
                li.add(go(sb));
                sb.setLength(0);
            }
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
