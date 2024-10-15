import java.util.*;
import java.io.*;
class programmers42583 {
    static Queue<Integer> q = new LinkedList<>();
    static int sum = 0;
    public int solution(int l, int w, int[] t) {
        int ret = 0;

        for(int i = 0; i < t.length; i++){
            int temp = t[i];
            while(true){
                if(q.isEmpty()){
                    q.add(temp);
                    ret++;
                    sum += temp;
                    break;
                }else if(q.size() == l){
                    sum -= q.poll();
                }else{
                    if(sum + temp <= w){
                        q.add(temp);
                        ret++;
                        sum += temp;
                        break;
                    }else{
                        q.add(0);
                        ret++;
                    }
                }
            }
        }

        return ret + l;
    }
}