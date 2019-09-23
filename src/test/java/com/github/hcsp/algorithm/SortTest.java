
package com.github.hcsp.algorithm;
import org.junit.jupiter.api.Test;;import java.util.Random;;import java.util.Arrays;;import org.junit.jupiter.api.Assertions;

public class SortTest {
int[] randomArray = new int[10];

{
    Random r = new Random();
    for (int i = 0; i < 10; i++) {
        randomArray[i] = r.nextInt(10);
    }
}

@Test
public void sort1Test() {
    int[] copy = Arrays.copyOf(randomArray, 10);
    Arrays.sort(copy);


    System.out.println("Before: " + Arrays.toString(randomArray));
    Sort.sort1(randomArray);`
    System.out.println("After: " + Arrays.toString(randomArray));
    Assertions.assertArrayEquals(copy, randomArray);
}

@Test
public void sort2Test() {
    int[] copy = Arrays.copyOf(randomArray, 10);
    Arrays.sort(copy);


    System.out.println("Before: " + Arrays.toString(randomArray));
    Sort.sort1(randomArray);
    System.out.println("After: " + Arrays.toString(randomArray));
    Assertions.assertArrayEquals(copy, randomArray);
}
}
