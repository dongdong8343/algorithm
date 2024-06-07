import java.util.*;
import java.io.*;
public class BaekjoonReRe19942 {
    static class Info{
        public int p;
        public int f;
        public int s;
        public int v;
        public int price;
        Info(int p, int f, int s, int v, int price){
            this.p = p;
            this.f = f;
            this.s = s;
            this.v = v;
            this.price = price;
        }
    }
    static int n, min = 987654321;
    static int[] m = new int[4];
    static List<Info> li = new ArrayList<>();
    static List<Integer> ret = new ArrayList<>();
    static void go(){
        for(int i = 0; i < (1 << n); i++){
            int p = 0, f = 0, s = 0, v = 0, price = 0, isOver = 0;
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    p += li.get(j).p;
                    f += li.get(j).f;
                    s += li.get(j).s;
                    v += li.get(j).v;
                    price += li.get(j).price;
                    list.add(j);
                    if(min < price){
                        isOver = 1;
                        break;
                    }
                }
            }
            if(isOver == 1) continue;
            if(m[0] <= p && m[1] <= f && m[2] <= s && m[3] <= v){
                if(min == price){
                    if(compare(list, ret) < 0) ret = list;
                }
                else if(min > price){
                    min = price; ret = list;
                }
            }
        }
    }
    static int compare(List<Integer> li1, List<Integer> li2){
        int size = Math.min(li1.size(), li2.size());
        for(int i = 0; i < size; i++){
            if(!li1.get(i).equals(li2.get(i))) return li1.get(i) - li2.get(i);
        }
        return li1.size() - li2.size();
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) m[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[5];
            for(int j = 0; j < 5; j++) temp[j] = Integer.parseInt(st.nextToken());
            li.add(new Info(temp[0], temp[1], temp[2], temp[3], temp[4]));
        }
        go();
        if(min == 987654321) System.out.println(-1);
        else{
            System.out.println(min);
            for(int i : ret) System.out.print(i + 1 + " ");
        }
    }
}