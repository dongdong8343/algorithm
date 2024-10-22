class Programmers70129 {
    public int[] solution(String s) {
        int turn = 0, cnt = 0;

        while(!s.equals("1")){
            StringBuilder sb = new StringBuilder();
            turn++;
            for(char c : s.toCharArray()){
                if(c == '0') cnt++;
                else sb.append(1);
            }
            s = Integer.toBinaryString(sb.toString().length());
        }

        int[] ret = {turn, cnt};

        return ret;
    }
}
