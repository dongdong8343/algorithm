import java.util.*;
import java.util.stream.Collectors;

public class practice {
    public static void main(String[] args) {
        List<Integer> s = new ArrayList<>(Arrays.asList(4, 3, 3, 5, 1, 2, 3));

        // 중복 제거하면서 순서 유지
        List<Integer> uniqueS = new ArrayList<>(new LinkedHashSet<>(s));
        uniqueS.forEach(i -> System.out.print(i + " "));
        System.out.println();

        List<Integer> s2 = new ArrayList<>(Arrays.asList(4, 3, 3, 5, 1, 2, 3));

        // 정렬 후 중복 제거
        Collections.sort(s2);
        List<Integer> uniqueSortedS2 = new ArrayList<>(new LinkedHashSet<>(s2));
        uniqueSortedS2.forEach(i -> System.out.print(i + " "));
    }
}
