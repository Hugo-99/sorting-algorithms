import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.*;
/**
 * Average running time in milliseconds of each test case
 *                      |  Insert   |   Select  | Merge Recursive | Merge Iterative |    Quick  |
 * 10 random            |  942133   |  1049166  |     1003200     |     1010700     |  1043466  |
 * 100 random           |   66800   |   101966  |       95766     |       56166     |    29266  |
 * 1000 random          | 6714000   | 73218333  |      959466     |      654633     |   450566  |
 * 1000 few unique      |  479833   |  1485033  |     1058066     |     1628933     |   441833  |
 * 1000 nearly ordered  |   59500   |  1455966  |      243866     |      442133     |   786800  |
 * 1000 reverse order   |  369466   |  1518633  |      181266     |      176033     |  1332400  |
 * 1000 sorted          |    2233   |   343066  |      132933     |      103633     |  2318100  |
 *
 * Assignment questions:
 * a.   Which of the sorting algorithms does the order of input have an impact on? Why?
 * Ans. From the average running time result above, seem insertion sort is affected the most by the order of input.
 *      Because due the algorithm mechanism, the best case for insertion will be Theta(n), and worst for Theta(n^2).
 *
 * b.   Which algorithm has the biggest difference between the best and worst performance,
 *      based on the type of input, for the input of size 1000? Why?
 * Ans. Insertion, as comparing the best case and worst case of this algorithm, there is a huge difference with n^2 and n.
 *
 * c.   Which algorithm has the best/worst scalability, i.e., the difference in performance time based
 *      on the input size? Please consider only input files with random order for this answer.
 * Ans. The best will be merge sort, since it's time complexity will always remain O(n log(n)), it won't be affect by the input size.
 *      The worst will be selection, it's time complexity is always O(n^2) which might be the worst algorithm compare with the others.
 *
 * d.   Did you observe any difference between iterative and recursive implementations of merge sort?
 * Ans. Recursion will keep calling the function where iterative code will directly run through the code, that's why the iterative merge is faster.
 *
 * e.   Which algorithm is the fastest for each of the 7 input files?
 * Ans. 10 random               :   Insertion
 *      100 random              :   Quick
 *      1000 random             :   Quick
 *      1000 few unique         :   Quick
 *      1000 nearly ordered     :   Insertion
 *      1000 reverse order      :   Merge Iterative
 *      1000 sorted             :   Insertion
 */
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
            double[] sortedTestcase = SortComparison.insertionSort(testCase);
            long endTime = System.nanoTime();
            long duration = endTime-startTime;
            System.out.println(duration);
            testCount++;
        }
    }
}

