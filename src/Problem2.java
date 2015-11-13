import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import supportingFiles.StreamUtils;

/**
 * @author Eric Vennaro
 * Could've done this using for loop (see ruby version) but I wanted to use Java 8 concepts
 * In order to stop stream at correct value using StreamUtils.takeWhile() a feature apparently coming
 * in java 9. 
 * Implemented Spliterator.Ofint in order to avoid boxing and continue to utilize primitives.
 */
public class Problem2 {
    
    public static void mutableFib(){
        IntSupplier fib = new IntSupplier(){
            private int previous = 0;
            private int current = 1;
            
            public int getAsInt(){
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        
        //filter even values and limit at 4,000,000
       Stream<Integer> fibonacci = StreamUtils.takeWhile(IntStream.generate(fib).filter(i -> i % 2 == 0), i -> i < 4000000);
       System.out.println(fibonacci.mapToInt(i -> i).sum());

    }
}