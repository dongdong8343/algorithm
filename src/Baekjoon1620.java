import java.util.*;
import java.io.*;
public class Baekjoon1620 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(int i = 1; i <= n; i++){
            String str = br.readLine();
            map1.put(i, str);
            map2.put(str, i);
        }
        for(int i = 0; i < m; i++){ //10000000000
            String quiz = br.readLine();
            boolean isNum = true;
            for (char c : quiz.toCharArray()){
                if(!Character.isDigit(c)) isNum = false;
            }
            if(isNum){
                System.out.println(map1.get(Integer.parseInt(quiz)));
            }else{
                System.out.println(map2.get(quiz));
            }
        }
    }
}
