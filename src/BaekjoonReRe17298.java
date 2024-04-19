import java.util.*;
import java.io.*;
public class BaekjoonReRe17298 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int ret[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && arr[i] > arr[s.peek()]){
                int x = s.pop();
                ret[x] = arr[i];
            }
            s.push(i);
        }
        while(!s.isEmpty())
            ret[s.pop()] = -1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
            sb.append(ret[i]).append(" ");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
