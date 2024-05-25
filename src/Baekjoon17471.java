import java.util.*;
import java.io.*;
public class Baekjoon17471 {
    static int n, all, ret = 987654321;
    static int[] num = new int[14];
    static int[] visited;
    static List<Integer>[] area;
    static void check(int idx, int state, int number){
        visited[idx] = 1;
        for(int x : area[idx]){
            if(number == 1 && (state & (1 << x)) == 0) continue;
            if(number == 0 && (state & (1 << x)) != number) continue;
            if(visited[x] == 1) continue;
            check(x, state, number);
        }
    }
    static void go(){
        for(int i = 1; i < (1 << n) - 1; i++){
            visited = new int[n];
            int zidx = -1, oidx = -1, oSum = 0, ok = 1;
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    if(oidx == -1) oidx = j;
                    oSum += num[j];
                }else if(zidx == -1) zidx = j;
            }
            check(zidx, i,0);
            check(oidx, i,1);
            for(int j = 0; j < n; j++) {
                if(visited[j] == 0){
                    ok = 0;
                    break;
                }
            }
            if(ok == 0) continue;
            int cha = Math.abs((all - oSum) - oSum);
            ret = Math.min(cha, ret);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        area = new List[n];
        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
            all += num[i];
            area[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for(int j = 0; j < a; j++){
                area[i].add(Integer.parseInt(st.nextToken()) - 1);
            }
        }
        go();
        if(ret == 987654321) System.out.println(-1);
        else System.out.println(ret);
    }
}