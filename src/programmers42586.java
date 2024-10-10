import java.util.*;
import java.io.*;
class programmers42586 {
    static int[] ret;
    static Queue<Integer> q = new LinkedList<>();
    static List<Integer> li = new ArrayList<>();

    public int[] solution(int[] p, int[] s) {
        for(int i = 0; i < p.length; i++){
            int temp = ((int)Math.ceil(((double)100 - p[i]) / s[i]));
            if(!q.isEmpty() && q.peek() < temp){
                li.add(q.size());
                q.clear();
            }
            q.add(temp);
        }

        if(!q.isEmpty()) li.add(q.size());

        ret = new int[li.size()];
        for(int i = 0; i < li.size(); i++){
            ret[i] = li.get(i);
        }

        return ret;
    }
}