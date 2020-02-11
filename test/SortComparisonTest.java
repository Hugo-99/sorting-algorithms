import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.*;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    @Test
    public void insertionSort() {
        double[] unsortedList = {9,8,7,6,5,0,1,2,3,4};
        double[] sortedList = {0,1,2,3,4,5,6,7,8,9};

        assertTrue("Sort a list of double with insertion sorting algorithm",Arrays.equals(sortedList, SortComparison.insertionSort(unsortedList)));

    }

    @Test
    public void selectionSort() {
        double[] unsortedList = {9,8,7,6,5,0,1,2,3,4};
        double[] sortedList = {0,1,2,3,4,5,6,7,8,9};

        assertTrue("Sort a list of double with selection sorting algorithm",Arrays.equals(sortedList, SortComparison.selectionSort(unsortedList)));
    }

    @Test
    public void quickSort() {
        double[] unsortedList = {9,8,7,6,5,0,1,2,3,4};
        double[] sortedList = {0,1,2,3,4,5,6,7,8,9};

        assertTrue("Sort a list of double with quicksort algorithm",Arrays.equals(sortedList, SortComparison.quickSort(unsortedList)));
    }

    @Test
    public void mergeSortIterative() {
        double[] unsortedList = {9,8,7,6,5,0,1,2,3,4};
        double[] sortedList = {0,1,2,3,4,5,6,7,8,9};

        assertTrue("Sort a list of double with iterative merge sorting algorithm",Arrays.equals(sortedList, SortComparison.mergeSortIterative(unsortedList)));
    }

    @Test
    public void mergeSortRecursive() {
        double[] unsortedList = {9,8,7,6,5,0,1,2,3,4};
        double[] sortedList = {0,1,2,3,4,5,6,7,8,9};

        assertTrue("Sort a list of double with recursive merge sorting algorithm",Arrays.equals(sortedList, SortComparison.mergeSortRecursive(unsortedList)));
    }

    public static void main(String[] args){
        BufferedReader rd;
        int testCount = 0;
        int[] testSize = {10,100,1000,1000,1000,1000,1000};
        String[] testLocation = {   "/Users/lihang/Desktop/TCD/Year2/CSU22010-Data&Algorithms/localTest/numbers10.txt",
                                    "/Users/lihang/Desktop/TCD/Year2/CSU22010-Data&Algorithms/localTest/numbers100.txt",
                                    "/Users/lihang/Desktop/TCD/Year2/CSU22010-Data&Algorithms/localTest/numbers1000.txt",
                                    "/Users/lihang/Desktop/TCD/Year2/CSU22010-Data&Algorithms/localTest/numbers1000Duplicates.txt",
                                    "/Users/lihang/Desktop/TCD/Year2/CSU22010-Data&Algorithms/localTest/numbersNearlyOrdered1000.txt",
                                    "/Users/lihang/Desktop/TCD/Year2/CSU22010-Data&Algorithms/localTest/numbersReverse1000.txt",
                                    "/Users/lihang/Desktop/TCD/Year2/CSU22010-Data&Algorithms/localTest/numbersSorted1000.txt"};
        while(testCount<testSize.length){
            double[] testCase = new double[testSize[testCount]];
            int index = 0;
            try{
                rd = new BufferedReader(new FileReader(testLocation[testCount]));
                String line = rd.readLine();
                while(line!=null){
                    testCase[index] = Double.valueOf(line);
                    index++;
                    line = rd.readLine();
                }
            } catch (IOException e){
                e.printStackTrace();
            }

            long startTime = System.nanoTime();
            double[] sortedTestcase = SortComparison.selectionSort(testCase);
            long endTime = System.nanoTime();
            long duration = endTime-startTime;
            System.out.println(duration);
            testCount++;
        }


//        for(int i=0; i<sortedTestcase.length; i++)
//            System.out.print(sortedTestcase[i]+" ");
    }
}

