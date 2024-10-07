import java.util.*;
import java.io.*;

class programmers42578 {
    static HashMap<String, Integer> hs = new HashMap<>();

    public int solution(String[][] clothes) {
        int answer = 1;

        for(int i = 0; i < clothes.length; i++){
            hs.put(clothes[i][1], hs.getOrDefault(clothes[i][1], 0) + 1);
        }

        for(String s : hs.keySet()){
            answer *= hs.get(s) + 1;
        }

        return answer - 1;
    }
}