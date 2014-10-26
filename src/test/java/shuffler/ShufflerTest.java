package shuffler;

import com.google.common.collect.Sets;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import shuffler.Shuffler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class ShufflerTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testShufflerValidArgument_long() throws Exception {
        ArrayList<Long> shuffledList = Shuffler.shuffle(96L);
        assert shuffledList.size() == 96;
    }

    @Test
    public void testShufflerIllegalArgument_long() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("long n should be greater than 0");
        ArrayList<Long> shuffledList = Shuffler.shuffle(0L);
    }

    //This is a statistical test and should not normally be run with the test suite
    @Ignore
    @Test
    public void testShufflerRandomness_long() throws Exception{
        long n = 6;
        long totalPossibleShuffles = factorial(n);
        long iterations = 20;     //This must be a large number to make sure all the possible cases are covered over time
        float randomness = (float) .75;

        HashSet<Integer> shuffledListSet = Sets.newHashSet();

        for(long i = 0; i < iterations; i++){
            shuffledListSet.add(Shuffler.shuffle(n).hashCode());
        }

        long actualShuffles = shuffledListSet.size();
        float ratio = (float)actualShuffles / totalPossibleShuffles;
        System.out.println("actualShuffles " + actualShuffles);
        System.out.println("totalPossibleShuffles " + totalPossibleShuffles);
        System.out.println("ratio " + ratio);
        assertTrue(ratio >= randomness);

    }

    long factorial(long n){
        if (n < 0)
            throw new IllegalArgumentException("Negative number for factorial");

        if(n == 0)
            return 1;

        long fact = 1;
        for(long i = 1; i <= n ; i++)
            fact = fact * i;

        return fact;
    }

    @Test
    public void testShuffle_int() throws Exception {
        int[] shuffledIntArray = Shuffler.shuffle(100);
        assertThat(shuffledIntArray.length, equalTo(100));
    }

    @Test
    public void testShufflerIllegalArgument_int() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("int n should be greater than 0");
        int[] shuffledArray = Shuffler.shuffle(0);
    }

    //This is a statistical test and should not normally be run with the test suite as it depends on the number of iterations
    @Ignore
    @Test
    public void testShufflerRandomness_int() {
        int n = 6;
        long totalPossibleShuffles = factorial(n);
        long iterations = 1000;     //This must be a large number to make sure all the possible cases are covered over time
        float randomness = (float) .75;

        HashSet<Integer> shuffledArraySet = Sets.newHashSet();

        for (long i = 0; i < iterations; i++){
            shuffledArraySet.add(Arrays.hashCode(Shuffler.shuffle(n)));
        }

        long actualShuffles = shuffledArraySet.size();
        float ratio = (float)actualShuffles / totalPossibleShuffles;
        System.out.println("actualShuffles " + actualShuffles);
        System.out.println("totalPossibleShuffles " + totalPossibleShuffles);
        System.out.println("ratio " + ratio);
        assertTrue(ratio >= randomness);
    }


}