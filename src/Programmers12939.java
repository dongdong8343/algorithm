import java.util.*;
import java.io.*;
class Programmers12939 {
    public String Main(String s) {
        StringBuilder ret = new StringBuilder();

        String[] temp = s.split(" ");
        List<Integer> li = new ArrayList<>();

        for(int i = 0; i < temp.length; i++){
            li.add(Integer.parseInt(temp[i]));
        }

        Collections.sort(li);
        ret.append(li.get(0)).append(" ").append(li.get(li.size() - 1));

        return ret.toString();
    }
}