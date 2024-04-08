import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon1325 {
    static int n, m;
    static boolean[] visited;
    static int[] result;
    static List<Integer>[] arr;
    public static void main(String[] args) throws IOException{
        Reader reader = new Reader();

        n = reader.nextInt();
        m = reader.nextInt();

        arr = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            arr[reader.nextInt() - 1].add(reader.nextInt() - 1);
        }

        result = new int[n];
        for(int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i);
        }

        int max = 0;
        for(int num : result) {
            max = Math.max(max, num);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(result[i] == max) {
                sb.append(i + 1).append(" ");
            }
        }
        System.out.print(sb);
    }

    public static void dfs(int n) {
        if(visited[n]) {
            return;
        }

        visited[n] = true;

        for(int num : arr[n]) {
            if(!visited[num]) {
                result[num]++;
                dfs(num);
            }
        }
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) {
                return -ret;
            }
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null) {
                return;
            }
            din.close();
        }
    }
}