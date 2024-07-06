import java.util.*;
import java.io.*;
public class BaekjoonRe1700_1 {
    static int n, k, ret = 0;
    static int[] v, a;
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[k + 4];
        v = new int[k + 4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < k; i++){
            if(v[a[i]] == 0){
                if(li.size() == n){
                    int last = 0, pos = -1;
                    for(int x : li){
                        int here = 987654321;
                        for(int j = i + 1; j < k; j++){
                            if(x == a[j]){
                                here = j;
                                break;
                            }
                        }
                        if(last < here){
                            last = here;
                            pos = x;
                        }
                    }
                    v[pos] = 0;
                    li.remove((Integer)pos);
                    ret++;
                }
                li.add(a[i]);
                v[a[i]] = 1;
            }
        }
        System.out.println(ret);
    }
}