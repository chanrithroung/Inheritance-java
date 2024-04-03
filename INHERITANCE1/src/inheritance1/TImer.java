import java.util.Scanner;

public class TImer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter start hour minute seconds: ");
        int h = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        
        while (true) {
            if (s >= 60) {
                m += s / 60;
                s %= 60;
            }
            if (m >= 60) {
                h += m / 60;
                m %= 60;
            }
            System.out.println( + h + ":" + m + ":" + s);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s++;
        }
    }
    
}
