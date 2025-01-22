import java.io.*;
import java.util.*;
public class Baekjoon1181 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            hs.add(s);
        }

        List<String> li = new ArrayList<>(hs);

        Collections.sort(li, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() != s2.length()) return s1.length() - s2.length();
                return s1.compareTo(s2);
            }
        });

        for(String s : li) System.out.println(s);

    }
}