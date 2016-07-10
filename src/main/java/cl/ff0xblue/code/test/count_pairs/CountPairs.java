package cl.ff0xblue.code.test.count_pairs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author daniel
 */
public class CountPairs {

    public static void main(String[] args) {
        long init = System.currentTimeMillis();
        run();
        long time = System.currentTimeMillis()-init;
        System.out.println("Time: "+time);
    }

    public static void run(){
        System.out.println(countPairs(new int[]{1,5,3,4,2},2));
        System.out.println(countPairs(new int[]{
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
                1));
    }

    private static final int INVALID = -1;

    static int countPairs(int[] numbers, int k) {
        if(constraintsArr(numbers.length) || constraintsK(k)){
            return INVALID;
        }
        //Set<Tuple> pairs = new HashSet<>();
        SetC<Tuple> pairs = new SetC<>();
        int count = 0;
        for(int a=0;a<numbers.length;a++){
            for(int b=a+1;b<numbers.length;b++) {
                if(!pairs.add(new Tuple(numbers[a],numbers[b])))
                    continue;
                if(constraintsK(numbers[a]) || constraintsK(numbers[b]))
                    return INVALID;
                if(Math.abs(numbers[a]-numbers[b])==k)
                    count++;
            }
        }
        return count;
    }


    private static boolean constraintsArr(int length){
        return length<2 || length>2*Math.pow(10,5);
    }

    private static boolean constraintsK(int k){
        return k<0 || k>Math.pow(10,9);
    }


    static final class Tuple{
        final int a, b;

        public Tuple(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this==o || this.hashCode() == o.hashCode()) return true;
            //if (o == null || getClass() != o.getClass()) return false;
            //Tuple tuple = (Tuple) o;
            //if(a==tuple.b && b==tuple.a || a==tuple.a && b==tuple.b) return true;
            return false;
        }

        @Override
        public int hashCode() {
            return (31*a)*(7*b);
        }
    }

    static final class SetC<T>{
        private final List<T> arr = new ArrayList<>();
        /*private final T[] arr;
        public SetC(int size){
            this.arr = new T[](size);
        }*/
        public boolean add(T t){
            for(int i=0;i<arr.size();i++){
                if(t.hashCode()==arr.get(i).hashCode())
                    return false;
            }
            return arr.add(t);
        }
    }


}
