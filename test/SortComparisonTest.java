import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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

    }
}

