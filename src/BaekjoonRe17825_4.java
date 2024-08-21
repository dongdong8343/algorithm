import java.util.*;
import java.io.*;
public class BaekjoonRe17825_4 {
    static int ret = 0;
    static List<Integer>[] map = new List[104];
    static int[] sc = new int[104];
    static int[] a = new int[13];
    static int[] mal = new int[4];
    static void setMap(){
        for(int i = 0; i < 104; i++) map[i] = new ArrayList<>();
        for(int i = 0; i < 20; i++) map[i].add(i + 1);
        map[5].add(21); map[21].add(22); map[22].add(23); map[23].add(24);
        map[15].add(27); map[27].add(26); map[26].add(25); map[25].add(24);
        map[10].add(28); map[28].add(29); map[29].add(24); map[24].add(30);
        map[30].add(31); map[31].add(20); map[20].add(100);
        for(int i = 1; i <= 20; i++) sc[i] = i * 2;
        sc[21] = 13; sc[22] = 16; sc[23] = 19; sc[24] = 25;
        sc[25] = 26; sc[26] = 27; sc[27] = 28; sc[28] = 22;
        sc[29] = 24; sc[30] = 30; sc[31] = 35; sc[100] = 0;
    }
    static void go(int idx, int score){
        if(idx == 10){
            ret = Math.max(ret, score);
            return;
        }
        for(int i = 0; i < 4; i++){
            int ori = mal[i];
            int now = move(a[idx], mal[i]);
            if(check(now, i)) continue;
            mal[i] = now;
            go(idx + 1, score + sc[mal[i]]);
            mal[i] = ori;
        }
    }
    static int move(int cnt, int here){
        if(here == 100) return 100;
        if(map[here].size() == 2){
            here = map[here].get(1);
            cnt--;
        }
        while(cnt > 0){
            here = map[here].get(0);
            if(here == 100) break;
            cnt--;
        }
        return here;
    }
    static boolean check(int here, int idx){
        if(here == 100) return false;
        for(int i = 0; i < 4; i++){
            if(i == idx) continue;
            if(mal[i] == here) return true;
        }
        return false;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setMap();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 10; i++) a[i] = Integer.parseInt(st.nextToken());
        go(0, 0);
        System.out.println(ret);
    }
}