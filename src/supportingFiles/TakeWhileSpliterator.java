package supportingFiles;
import java.util.Spliterator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

class TakeWhileSpliterator<T> implements Spliterator.OfInt {

    public TakeWhileSpliterator(java.util.Spliterator.OfInt source, IntPredicate condition){
        this.source = source;
        this.condition = condition;
    }

    static <T> TakeWhileSpliterator<T> over(java.util.Spliterator.OfInt ofInt, IntPredicate condition2) {
        return new TakeWhileSpliterator<T>(ofInt, condition2);
    }

    private final java.util.Spliterator.OfInt source;
    private final IntPredicate condition;
    private boolean conditionHolds = true;

    //tryAdvance is ambiguous need to specialize type as IntConsumer
    @Override
    public boolean tryAdvance(IntConsumer action) {
        return conditionHolds && source.tryAdvance((IntConsumer)(e) -> {
            if (conditionHolds = condition.test(e)) {
                action.accept(e);
            }
        });
    }
    
    @Override
    public long estimateSize() {
        return conditionHolds ? source.estimateSize() : 0;
    }

    @Override
    public int characteristics() {
        return source.characteristics() &~ Spliterator.SIZED;
    }

    @Override
    public java.util.Spliterator.OfInt trySplit() {
        // TODO Auto-generated method stub
        return null;
    }
}