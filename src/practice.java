import java.util.*;
import java.io.*;

public class practice {

    public static void main(String[] args)throws Exception {
        List<Integer> li1 = new ArrayList<>();
        List<Integer> li2 = new ArrayList<>();
        li1.add(1);
        li1.add(2);
        li2.add(5);
        if (compareLists(li1, li2) < 0) {
            System.out.println(li1);
        }else System.out.println(li2);
    }

    private static int compareLists(List<Integer> list1, List<Integer> list2) {
        int size = Math.min(list1.size(), list2.size());
        for (int i = 0; i < size; i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return list1.get(i) - list2.get(i);
            }
        }
        return list1.size() - list2.size();
    }
}
