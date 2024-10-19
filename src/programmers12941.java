import java.util.*;
import java.io.*;
class programmers12941
{
    public int solution(int []a, int []b)
    {
        int ret = 0;
        int n = a.length;
        List<Integer> li = new ArrayList<>();
        List<Integer> li2 = new ArrayList<>();

        for(int i = 0; i < n; i++){
            li.add(a[i]);
            li2.add(b[i]);
        }

        Collections.sort(li);
        Collections.sort(li2, (o1, o2) -> {
            return o2 - o1;
        });

        for(int i = 0; i < n; i++){
            ret += li.get(i) * li2.get(i);
        }

        return ret;
    }
}