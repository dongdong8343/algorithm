import java.util.*;
import java.io.*;

public class programmers1845 {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        int answer = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            hs.put(nums[i], hs.getOrDefault(nums[i], 0) + 1);
        }
        n /= 2;
        answer = hs.size() >= n ? n : hs.size();
        return answer;
    }
}