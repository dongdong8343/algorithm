import java.util.*;
import java.io.*;

public class Inflearn5_3 {
    static int n, m, cnt = 0;
    static int[][] board = new int[34][34];
    static int[] a = new int[1004];
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) a[i] = Integer.parseInt(st.nextToken());

        for(int s = 0; s < m; s++){
            for(int i = 1; i <= n; i++){
                if(board[i][a[s]] != 0){
                    if(!stack.isEmpty() && stack.peek() == board[i][a[s]]) {
                        stack.pop();
                        cnt += 2;
                    }
                    else stack.push(board[i][a[s]]);
                    board[i][a[s]] = 0;
                    break;
                }
            }
        }

        System.out.println(cnt);

        return ;
    }
}