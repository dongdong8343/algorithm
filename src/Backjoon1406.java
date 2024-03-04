import java.util.*;
import java.io.*;

public class Backjoon1406 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        LinkedList<String> list = new LinkedList<>();
        for(int i = 0; i < str.length(); i++){
            list.add(String.valueOf(str.charAt(i)));
        }
        ListIterator iterator = list.listIterator(list.size());

        int m = Integer.parseInt(br.readLine());

        while(iterator.hasNext()) {
            iterator.next();
        }

        for(int i = 0; i < m; i++){
            String s = br.readLine();
            char c = s.charAt(0);

            if(c == 'L' && iterator.hasPrevious()){
                iterator.previous();
            } else if (c == 'D' && iterator.hasNext()) {
                iterator.next();
            } else if (c == 'B' && (iterator.hasPrevious())) {
                iterator.previous();
                iterator.remove();
            }else if(c == 'P'){
                char x = s.charAt(2);
                iterator.add(String.valueOf(x));
            }
        }

        System.out.println(String.join("", list));
    }
}
