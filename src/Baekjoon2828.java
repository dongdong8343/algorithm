import java.util.*;
import java.io.*;
public class Baekjoon2828 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());
        int s = 1;
        int e = 0;
        e += m;
        int ret = 0;
        for(int i = 0; i < j; i++){
            int apple = Integer.parseInt(br.readLine());
            if(s <= apple && e >= apple){
                continue;
            }
            int ns = apple - s;
            int ne = apple - e;
            if(Math.abs(ne) < Math.abs(ns)){
                ret += Math.abs(ne);
                s += ne;
                e += ne;
            }else{
                ret += Math.abs(ns);
                s += ns;
                e += ns;
            }
        }
        System.out.println(ret);
    }
}
