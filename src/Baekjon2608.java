import java.util.*;
import java.io.*;

public class Baekjon2608 {
    static String n1, n2;
    static HashMap<String, Integer> hash = new HashMap<>();
    static List<Map.Entry<Integer, String>> romanNumerals = new ArrayList<>();

    static {
        // 로마 숫자 변환을 위한 값 설정
        romanNumerals.add(new AbstractMap.SimpleEntry<>(1000, "M"));
        romanNumerals.add(new AbstractMap.SimpleEntry<>(900, "CM"));
        romanNumerals.add(new AbstractMap.SimpleEntry<>(500, "D"));
        romanNumerals.add(new AbstractMap.SimpleEntry<>(400, "CD"));
        romanNumerals.add(new AbstractMap.SimpleEntry<>(100, "C"));
        romanNumerals.add(new AbstractMap.SimpleEntry<>(90, "XC"));
        romanNumerals.add(new AbstractMap.SimpleEntry<>(50, "L"));
        romanNumerals.add(new AbstractMap.SimpleEntry<>(40, "XL"));
        romanNumerals.add(new AbstractMap.SimpleEntry<>(10, "X"));
        romanNumerals.add(new AbstractMap.SimpleEntry<>(9, "IX"));
        romanNumerals.add(new AbstractMap.SimpleEntry<>(5, "V"));
        romanNumerals.add(new AbstractMap.SimpleEntry<>(4, "IV"));
        romanNumerals.add(new AbstractMap.SimpleEntry<>(1, "I"));
    }

    static int ton(String s) {
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = hash.get(String.valueOf(s.charAt(i)));
            int b;
            if (i + 1 < s.length()) {
                b = hash.get(String.valueOf(s.charAt(i + 1)));
                if (b > a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(s.charAt(i)).append(s.charAt(i + 1));
                    a = hash.get(sb.toString());
                    i++;
                }
            }
            temp += a;
        }
        return temp;
    }

    static String toRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> entry : romanNumerals) {
            while (num >= entry.getKey()) {
                sb.append(entry.getValue());
                num -= entry.getKey();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        hash.put("I", 1);
        hash.put("IV", 4);
        hash.put("IX", 9);
        hash.put("V", 5);
        hash.put("X", 10);
        hash.put("XL", 40);
        hash.put("L", 50);
        hash.put("XC", 90);
        hash.put("C", 100);
        hash.put("CD", 400);
        hash.put("D", 500);
        hash.put("CM", 900);
        hash.put("M", 1000);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n1 = br.readLine();
        n2 = br.readLine();

        int a = ton(n1);
        int b = ton(n2);
        int sum = a + b;

        String result = toRoman(sum);
        System.out.println(sum);
        System.out.println(result);
    }
}
