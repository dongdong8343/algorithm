import java.util.*;
import java.io.*;

class programmers42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hs = new HashMap<>();
        for(int i = 0; i < participant.length; i++){
            hs.put(participant[i], hs.getOrDefault(participant[i], 0) + 1);
        }

        for(int i = 0; i < completion.length; i++){
            if(hs.get(completion[i]) == 1) hs.remove(completion[i]);
            else hs.replace(completion[i], hs.get(completion[i]) - 1);
        }

        for(String s : hs.keySet()) answer = s;

        System.out.println(answer);

        return answer;
    }
}