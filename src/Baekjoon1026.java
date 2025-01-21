import java.io.*;
import java.util.*;
public class Baekjoon1026 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> liA = new ArrayList<>();
        List<Integer> liB = new ArrayList<>();


        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();
        String[] a = s.split(" ");

        s = br.readLine();
        String[] b = s.split(" ");

        for(int i = 0; i < n; i++){
            liA.add(Integer.parseInt(a[i]));
            liB.add(Integer.parseInt(b[i]));
        }

        Collections.sort(liA);
        Collections.sort(liB, Collections.reverseOrder());
        int ret = 0;

        for(int i = 0; i < n; i++){
            ret += liA.get(i) * liB.get(i);
        }

        System.out.println(ret);
    }
}