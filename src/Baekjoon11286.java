import java.io.*;
import java.util.*;

public class Baekjoon11286 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                if(q.isEmpty()) sb.append(0 + "\n");
                else sb.append(q.poll()).append("\n");
            } else q.add(temp);
        }

        System.out.println(sb.toString());


    }

}