class ProgrammersTargetNumber {
    static int l;

    public int solution(int[] a, int target) {
        l = a.length;

        int ret = go(0, 0, a, target);

        return ret;
    }

    public int go(int now, int idx, int[] t, int n) {
        int cnt = 0;

        if(idx >= l) {
            if(now == n) return 1;
            return 0;
        }

        cnt += go(now + t[idx], idx + 1, t, n);
        cnt += go(now - t[idx], idx + 1, t, n);

        return cnt;
    }
}
