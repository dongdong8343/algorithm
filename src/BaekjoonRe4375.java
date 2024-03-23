import java.io.*;
import java.util.*;
public class BaekjoonRe4375 {
    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int ret = 1;
            int m = 1;
            while(m % n != 0){
                m = (m * 10 + 1) % n;
                ret++;
            }
            System.out.println(ret);
        }
    }
}
