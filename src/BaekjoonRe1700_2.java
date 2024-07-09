import java.util.*;
import java.io.*;
public class BaekjoonRe1700_2 {
    static int n, k, ret = 0;
    static List<Integer> li = new ArrayList<>();
    static int[] v = new int[104];
    static int[] a = new int[104];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < k; i++){
            if(v[a[i]] == 0){
                if(li.size() == n){
                    int last = 0, pos = -1;
                    for(int x : li){
                        int idx = 987654321;
                        for(int j = i + 1; j < k; j++){
                            if(x == a[j]){
                                idx = j;
                                break;
                            }
                        }
                        if(last < idx){
                            last = idx;
                            pos = x;
                        }
                    }
                    v[pos]--;
                    ret++;
                    li.remove((Integer)pos);
                }
                v[a[i]]++;
                li.add(a[i]);
            }
        }
        System.out.println(ret);
    }
}