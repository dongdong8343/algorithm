import java.util.*;
import java.io.*;
public class Baekjoon4375 {
    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int num = 0;
            for(int i = 1;;i++){
                num = (num * 10 + 1) % n;
                if(num % n == 0){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
