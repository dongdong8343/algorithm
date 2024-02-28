import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[10];

        while(n != 0){
            int temp = n % 10;
            if(temp == 6 || temp == 9){
                if(arr[6] > arr[9]){
                    arr[9]++;
                }
                else{
                    arr[6]++;
                }
            }
            else{
                arr[temp]++;
            }
            n /= 10;
        }

        int max = arr[0];
        for(int i = 1; i<10; i++){
            if(max < arr[i]) {
                max = arr[i];
            }
        }

        System.out.println(max);

    }
}