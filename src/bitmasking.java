public class bitmasking {
    public static void main(String[] args)throws Exception{
        int n = 4;
        String[] s = {"사과", "딸기", "포도", "배"};
        for(int i = 0; i < (1 << n); i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    sb.append(s[j]).append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
