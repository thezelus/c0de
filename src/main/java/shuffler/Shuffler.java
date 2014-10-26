package shuffler;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Shuffler {

    private Shuffler(){}

    public static ArrayList<Long> shuffle(long n){

        if(n <= 0)
            throw new IllegalArgumentException("long n should be greater than 0");

        ArrayList<Long> numberList = Lists.newArrayList();

        for(long i = 1; i <= n ; i++){
            numberList.add(i);
        }

        //Java uses Knuth shuffle
        Collections.shuffle(numberList);

        return numberList;
    }


    public static int[] shuffle(int n){
        if (n <= 0)
            throw new IllegalArgumentException("int n should be greater than 0");

        int[] array = new int[n];

        for(int i = 0; i < n; i++)
            array[i] = i+1;

        fastShuffle(array);
        return array;
    }

    //Using primitive types makes it a tad faster since it doesn't need to wrap it into a class object
    static void fastShuffle(int[] array) {

        Random random = new Random();
        int index;
        for(int j = array.length -1 ; j > 0; j--) {
            index = random.nextInt(j + 1);
            //swap
            int a = array[j];
            array[j] = array[index];
            array[index] = a;
        }
    }

}
