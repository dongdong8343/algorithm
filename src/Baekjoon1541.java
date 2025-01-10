import java.io.*;
import java.util.*;
public class Baekjoon1541 {
    static List<Integer> li = new ArrayList<>();
    static int ret = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] arr = s.split("-");

        for(String t : arr){
            String[] temp = t.split("\\+");
            int sum = 0;
            for(String x : temp){
                sum += Integer.parseInt(x);
            }
            li.add(sum);
        }

        ret = li.get(0);
        for(int i = 1; i < li.size(); i++){
            ret -= li.get(i);
        }

        System.out.println(ret);
    }
}
