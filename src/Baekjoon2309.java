import java.util.*;
import java.io.*;
public class Baekjoon2309 {
    static int n = 9;
    static int r = 7;
    static int sum = 0;
    static int[] arr = new int[n];
    static int first, second;
    static void combi(){
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int temp = sum - arr[i] - arr[j];
                if(temp == 100){
                    first = i;
                    second = j;
                    return;
                }
            }
        }
    }


    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        List<Integer> li = new ArrayList<>();
        combi();
        for(int i = 0; i < n; i++){
            if(i == first || i == second) continue;
            li.add(arr[i]);
        }
        Collections.sort(li);
        for(int i : li) System.out.println(i);
    }
}
