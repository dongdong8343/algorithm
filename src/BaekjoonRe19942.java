import java.util.*;
import java.io.*;
public class BaekjoonRe19942 {
    public static class Food{
        public int dan;
        public int tan;
        public int ji;
        public int vi;
        public int price;
        public Food(){}
        public Food(int dan, int tan, int ji, int vi, int price){
            this.dan = dan;
            this.tan = tan;
            this.ji = ji;
            this.vi = vi;
            this.price = price;
        }
    }
    static int n, ret = 987654321;
    static List<Integer> retli = new ArrayList<>();
    static List<Integer> templi = new ArrayList<>();
    static List<Food> li = new ArrayList<>();
    static int sort(List<Integer> li1, List<Integer> li2){
        int min = Math.min(li1.size(), li2.size());
        for(int i = 0; i < min; i++){
            if(!li1.get(i).equals(li2.get(i))) return li1.get(i) - li2.get(i);
        }
        return li1.size() - li2.size();
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[4];
        for(int i = 0; i < 4; i++) arr[i] = Integer.parseInt(st.nextToken());
        Food minimum = new Food(arr[0], arr[1], arr[2], arr[3], 0);

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr = new int[5];
            for(int j = 0; j < 5; j++) arr[j] = Integer.parseInt(st.nextToken());
            li.add(new Food(arr[0], arr[1], arr[2], arr[3], arr[4]));
        }

        for(int i = 0; i < (1 << n); i++){
            Food combi = new Food();
            templi = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    templi.add(j + 1);
                    combi.dan += li.get(j).dan;
                    combi.tan += li.get(j).tan;
                    combi.ji += li.get(j).ji;
                    combi.vi += li.get(j).vi;
                    combi.price += li.get(j).price;
                }
            }
            if(combi.tan >= minimum.tan && combi.dan >= minimum.dan && combi.ji >= minimum.ji && combi.vi >= minimum.vi){
                if(ret == combi.price){
                    if(sort(templi, retli) < 0) retli = new ArrayList(templi);
                }else if(ret > combi.price){
                    retli = new ArrayList<>(templi);
                    ret = combi.price;
                }
            }
        }
        if(ret != 987654321){
            System.out.println(ret);
            for(int i : retli) System.out.print(i + " ");
        }else System.out.println(-1);
    }
}