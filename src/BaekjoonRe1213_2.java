import java.io.*;
public class BaekjoonRe1213_2 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] num = new int[26];
        for(int i : word.toCharArray()){
            int n = i - 'A';
            num[n]++;
        }

        char mid = ' ';
        int check = 0;
        StringBuilder ret = new StringBuilder();

        for(int i = 'Z'; i >= 'A'; i--){
            int n = i - 'A';
            if(num[n] % 2 != 0){
                mid = (char) i;
                num[n]--;
                check++;
            }
            if(check >= 2){
                break;
            }
            for(int j = 0; j < num[n]; j += 2){
                ret = ret.append((char)i);
                ret = ret.insert(0, (char)i);
            }
        }
        if(check == 2){ System.out.println("I'm Sorry Hansoo");}
        else{
            if(check == 1){
                int idx = ret.length() / 2;
                ret.insert(idx, mid);
            }
            System.out.println(ret.toString());
        }
    }
}
