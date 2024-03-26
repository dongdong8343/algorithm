import java.util.*;
import java.io.*;
public class BaekjoonReRe4375 {
    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int ret = 0;
            int cnt = 0;
            while(true){
                ret = (ret * 10 + 1) % n;
                cnt++;
                if(ret == 0)
                    break;
            }
            System.out.println(cnt);
        }
    }
}
