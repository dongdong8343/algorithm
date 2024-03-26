import java.io.*;
import java.util.*;
public class Baekjoon4659 {
    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String word = sc.next();
            if(word.equals("end"))
                break;
            int mo = 0, ja = 0, beep = 0, aeiou = 0;
            char before = ' ';
            for(char c : word.toCharArray()){
                if(before != 'e' && before != 'o' && before != ' '){
                    if(before == c){
                        beep = 1;
                        break;
                    }
                }
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    aeiou = 1;
                    mo++;
                    ja = 0;
                }
                else{
                    ja++;
                    mo = 0;
                }
                if(mo == 3 || ja == 3){
                    beep = 1;
                    break;
                }
                before = c;
            }
            if(beep == 1 || aeiou == 0)
                System.out.println("<" + word + "> is not acceptable.");
            else
                System.out.println("<" + word + "> is acceptable.");
        }
    }
}
