import java.util.stream.IntStream;


public class Problem1 {
    public static void multiples(){
        int multiples3And5 = IntStream.rangeClosed(1,999).filter(i -> i % 3 == 0 || i % 5 == 0).sum();
        System.out.println(multiples3And5);
    }
    
}
