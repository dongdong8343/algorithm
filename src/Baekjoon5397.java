import java.util.*;
import java.io.*;
public class Baekjoon5397 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            String str = br.readLine();
            LinkedList<String> list = new LinkedList<>();
            ListIterator li = list.listIterator();

            for (int j = 0; j < str.length(); j++) {
                char a = str.charAt(j);
                if (a == '<') {
                    if (li.hasPrevious()) {
                        li.previous();
                    }
                } else if (a == '>') {
                    if (li.hasNext()) {
                        li.next();
                    }
                } else if (a == '-') {
                    if (li.hasPrevious()) {
                        li.previous();
                        li.remove();
                    }
                } else {
                    li.add(String.valueOf(a));
                }
            }

            System.out.println(String.join("", list));
        }
    }
}
