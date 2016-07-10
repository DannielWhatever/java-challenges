package cl.ff0xblue.code.test.count_pairs;

import java.util.*;
import java.util.function.Predicate;

/**
 *
 * when i had to answer this exercise i failed in two things.
 *  first : i use a queue instead of a stack
 *  second : i use removeIf , and removeIf remove all elements, not the last :c
 *
 * @author daniel
 */
public class BalancedBrackets {



    public static void main(String[] args) {
        String[] sss = new String[]{"ashdhashdas [] sadsa "," ( (] ([)]","() [] () ([]()[])"};
        for(String s : sss)
            System.out.println(hasBalancedBrackets(s));

    }




    private final static Map<Character,Byte> MAP_OPEN_BRACKETS = new HashMap<Character,Byte>(){{
        this.put('(',(byte)1);
        this.put('{',(byte)2);
        this.put('[',(byte)3);
        this.put('<',(byte)4);
    }};

    private final static Map<Character,Byte> MAP_CLOSE_BRACKETS = new HashMap<Character,Byte>(){{
        this.put(')',(byte)1);
        this.put('}',(byte)2);
        this.put(']',(byte)3);
        this.put('>',(byte)4);
    }};

    static boolean hasBalancedBrackets(String s) {
        final Stack<Byte> stackBrackets = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            final char c = s.charAt(i);
            System.out.println("\n\n"+c);
            if(MAP_OPEN_BRACKETS.containsKey(c)){
                stackBrackets.add(MAP_OPEN_BRACKETS.get(c));
                System.out.println("added: " +MAP_OPEN_BRACKETS.get(c));
            } else if(MAP_CLOSE_BRACKETS.containsKey(c)){
                byte lastE = stackBrackets.pop();
                if(lastE != MAP_CLOSE_BRACKETS.get(c)){
                    System.out.println("incorrect: " +MAP_CLOSE_BRACKETS.get(c));
                    return false;
                }
                System.out.println("removed: " +MAP_CLOSE_BRACKETS.get(c));
            }
        }
        System.out.println("at The End : " +stackBrackets.isEmpty());
        return stackBrackets.isEmpty();
    }



}
