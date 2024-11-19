public class Temp extends Thread{
    static int share;
    public static void main(String[] args){
        Temp t1 = new Temp();
        Temp t2 = new Temp();

        t1.start();
        t2.start();
    }

    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println(share++);

            try {
                sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}