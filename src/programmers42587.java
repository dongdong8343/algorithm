import java.util.*;
import java.io.*;
import java.awt.Point;

class programmers42587 {
    static Queue<Point> q = new LinkedList<>();
    static List<Integer> li = new ArrayList<>();
    static int cnt;
    public int solution(int[] p, int l) {

        int ret = 0;
        for(int i = 0; i < p.length; i++){
            q.add(new Point(p[i], i));
            li.add(p[i]);
        }

        Collections.sort(li, Collections.reverseOrder());

        while(!q.isEmpty()){
            Point temp = q.poll();
            if(temp.x == li.get(0)){
                li.remove(0);
                ret++;
                if(temp.y == l) {
                    System.out.println(ret);
                    return ret;
                }
            }else{
                q.add(temp);
            }
        }
        return ret;
    }
}

