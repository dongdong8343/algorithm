import java.util.*;

public class practice {
    static int n = 5, k = 3;
    static int[] a = {1, 2, 3, 4, 5};
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        combi(-1, li);
    }
    static void print(List<Integer> li){
        for(int i : li) System.out.print(i + " ");
        System.out.println();
    }
    static void combi(int start, List<Integer> li){
        if(li.size() == k){
            print(li);
            return;
        }
        for(int i = start + 1; i < n; i++){
            li.add(a[i]);
            combi(i, li);
            li.remove(li.size() - 1);
        }
    }

}
