import java.util.*;
import java.io.*;
public class BaekjoonRe1700_4 {
    static int n, m, ret = 0;
    static int[] a = new int[104];
    static int[] v = new int[104];
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) a[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < m; i++){
            if(v[a[i]] == 1) continue;
            if(li.size() == n){
                int pos = -1, x = -1;
                for(int t : li){
                    int idx = Integer.MAX_VALUE;
                    for(int j = i + 1; j < m; j++){
                        if(a[j] == t){
                            idx = j;
                            break;
                        }
                    }
                    if(pos < idx){
                        pos = idx;
                        x = t;
                    }
                }
                li.remove((Integer)x);
                v[x] = 0;
                ret++;
            }
            li.add(a[i]); v[a[i]] = 1;
        }
        System.out.println(ret);
    }
}