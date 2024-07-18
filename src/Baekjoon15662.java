import java.util.*;
import java.io.*;
import java.awt.Point;
public class Baekjoon15662 {
    static int n, k, ret = 0;
    static List<Integer>[] a = new List[1004];
    static List<Point> li = new ArrayList<>();
    static void go(){
        for(Point p : li){
            int[] temp = new int[n];
            int num = p.x;
            int bang = p.y;
            temp[num] = p.y;
            while(true){
                if(num == 0) break;
                if(a[num].get(6) != a[num - 1].get(2)){
                    if(bang == 1) {
                        temp[num - 1] = -1;
                        bang = -1;
                    }
                    else if (bang == -1) {
                        temp[num - 1] = 1;
                        bang = 1;
                    }
                }else break;
                num--;
                if(num <= 0) {
                    break;
                }
            }
            num = p.x;
            bang = p.y;
            while(true){
                if(num == n - 1) break;
                if(a[num].get(2) != a[num + 1].get(6)) {
                    if(bang == 1) {
                        temp[num + 1] = -1;
                        bang = -1;
                    }
                    else if (bang == -1) {
                        temp[num + 1] = 1;
                        bang = 1;
                    }
                }else break;
                num++;
                if(num == n - 1) break;
            }
            for(int i = 0; i < n; i++){
                if(temp[i] == 0) continue;
                if(temp[i] == -1){
                    int x = a[i].get(0);
                    for(int j = 0; j < 7; j++) a[i].set(j, a[i].get(j + 1));
                    a[i].set(7, x);
                }else{
                    int x = a[i].get(7);
                    for(int j = 7; j >= 1; j--) a[i].set(j, a[i].get(j - 1));
                    a[i].set(0, x);
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            a[i] = new ArrayList<>();
            for(int j = 0; j < s.length(); j++){
                a[i].add(Integer.parseInt(String.valueOf(s.charAt(j))));
            }
        }
        k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            li.add(new Point(a - 1, b));
        }
        go();
        for(int i = 0; i < n; i++){
            if(a[i].get(0) == 1) ret++;
        }
        System.out.println(ret);
    }
}