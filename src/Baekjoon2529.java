import java.util.*;
import java.io.*;
public class Baekjoon2529 {
    static int n;
    static int[] visited = new int[10];
    static char[] op;
    static List<Integer> li = new ArrayList<>();
    static List<String> ret = new ArrayList<>();
    static boolean check(int a, int b, char c){
        if(c == '>') return a > b;
        else return a < b;
    }
    static void solve(int num, int idx){
        if(idx == op.length){
            StringBuilder sb = new StringBuilder();
            for(int i : li) sb.append(i);
            ret.add(sb.toString());
            return;
        }
        for(int i = 0; i < 10; i++){
            if(visited[i] != 1 && check(num, i, op[idx])){
                li.add(i);
                visited[i] = 1;
                solve(i, idx + 1);
                li.remove(li.indexOf(i));
                visited[i] = 0;
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        op = new char[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            op[i] = st.nextToken().charAt(0);
        }
        for(int i = 0; i < 10; i++){
            visited[i] = 1;
            li.add(i);
            solve(i, 0);
            visited[i] = 0;
            li.remove(li.indexOf(i));
        }
        Collections.sort(ret);
        System.out.println(ret.get(ret.size() - 1));
        System.out.println(ret.get(0));
    }
}