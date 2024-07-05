import java.util.*;
import java.io.*;
public class Baekjoon1700 {
    static int n, k, cnt = 0;
    static List<Integer> li = new ArrayList<>();
    static int[] a, v;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        a = new int[k + 4];
        v = new int[k + 4];
        for(int i = 0; i < k; i++) a[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < k; i++){
            if(v[a[i]] == 0){
                if(li.size() == n){
                    int last = 0, pos = -1;
                    for(int x : li){
                        int here = 987654321;
                        for(int j = i + 1; j < k; j++){
                            if(x == a[j]) {
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
                    cnt++;
                    li.remove((Integer)pos);
                }
                li.add(a[i]);
                v[a[i]] = 1;
            }
        }
        System.out.println(cnt);
    }
}