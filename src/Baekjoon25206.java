import java.util.*;
import java.io.*;
public class Baekjoon25206 {
    static double hak = 0, sum = 0;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 20; i++){
            String s = br.readLine();
            String[] arr = s.split(" ");
            double p = Double.parseDouble(arr[1]);
            String sc = arr[2];
            if(sc.equals("P")) continue;
            hak += p;
            switch (sc){
                case "A+": sum += 4.5 * p; break;
                case "A0": sum += 4.0 * p; break;
                case "B+": sum += 3.5 * p; break;
                case "B0": sum += 3.0 * p; break;
                case "C+": sum += 2.5 * p; break;
                case "C0": sum += 2.0 * p; break;
                case "D+": sum += 1.5 * p; break;
                case "D0": sum += p; break;
            }
        }
        System.out.println(sum / hak);
    }
}