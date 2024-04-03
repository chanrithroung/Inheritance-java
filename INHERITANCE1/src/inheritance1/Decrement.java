package inheritance1;
import java.util.concurrent.atomic.AtomicInteger;
public class Decrement {
    public static void main(String[] args) {
       AtomicInteger num = new AtomicInteger(5);
        System.out.println("Before decrement: " + num);
        decrement(num);
        System.out.println("After decrement: " + num);
        
    }
    
    
   public static void decrement(AtomicInteger a) {
        a.decrementAndGet();
    }
}
