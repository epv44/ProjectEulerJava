import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;


public class Problem3 {
    public static boolean isPrime(long number){
        for(int i = 2; i < Math.sqrt((double) number); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public static void largestPrimeFactor(){
        long number = 600851475143l;
        long candidate = (long) Math.sqrt(number);
        //need to box primitive stream in order to collect
        List<Long> primes = LongStream.rangeClosed(2, candidate)
                .filter(i -> number % i == 0 && isPrime(i))
                .boxed()
                .collect(Collectors.toList());
        //goes in order will always be last value
        System.out.println(primes.get(primes.size()-1));
    }
}
