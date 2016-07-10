package cl.ff0xblue.code.test.count_pairs;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author daniel
 */
public class CountPairsTest {


    @Test
    public void countPairs() throws Exception {
        Thread.sleep(5L);
        measurePerformance();
    }

    public void measurePerformance(){
        long init = System.currentTimeMillis();
        runMethod();
        long time = System.currentTimeMillis()-init;
        System.out.println("Time: "+time);
    }

    public void runMethod(){
        CountPairs.countPairs(new int[]{
                        363374326,
                        364147530,
                        61825163,
                        107306571,
                        128124602,
                        139946991,
                        428047635,
                        491595254,
                        879792181,
                        106926279},
                1);
    }

}