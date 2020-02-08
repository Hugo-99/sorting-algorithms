// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
        double element = 0;
        for(int i=1; i<a.length; i++)
        {
            element = a[i];
            int j = i-1;
            while(j>=0 && a[j]>element)
            {
                a[j+1] = a[j];
                j = j-1;
            }
            a[j+1]=element;
        }
        return a;
    }//end insertionsort
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
        for(int i=0; i<a.length; i++) {
            int minIndex = i;
            int j = i+1;
            while(j<a.length && a[j]<a[minIndex]){
                minIndex = j;
                j++;
            }
            double tmp = a[i];
            a[i]=a[minIndex];
            a[minIndex]=tmp;
        }
        return a;
    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
	    quickSort(a,0,a.length-1);
        return a;
    }//end quicksort

    static int partition(double a[], int low, int high){
        int i = low;
        int j = high+1;
        double pivot = a[low];

        while(true){
            while(a[i++]<pivot){
                if(i==high){
                    break;
                }
            }
            while(a[--j]>pivot){
                if(j==low){
                    break;
                }
            }
            if(i==j){
                break;
            }
            double tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        a[low]=a[j];
        a[high]=pivot;
        return j;
    }

    static void quickSort (double a[], int low, int high){
        if(high<=low){
            return;
        }
        int pivotPosition = partition(a,low,high);
        quickSort(a,low,pivotPosition-1);
        quickSort(a,pivotPosition+1,high);
    }

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {

        double aux[] = new double[a.length];
        mergeSortIterative(a,aux,0,a.length-1);

        return a;
    }//end mergesortIterative

    static void mergeSortIterative (double a[], double aux[], int low, int high) {

        for(int s = 1; s<=high-low; s = s*2){
            for(int z = low; z<high; z+= s*2){
                int start = z;
                int mid = z+s-1;
                int end = ((z+s-1)>high) ? high:(z+s-1);
                iterativeMerge(a,aux,start,mid,end);
            }
        }
    }

    static void iterativeMerge(double a[], double aux[], int low, int mid, int high){

        int k = low, i = low, j = mid+1;
        while(i<=mid && j<=high){
            if(a[i]<a[j]) {
                aux[k++] = a[i++];
            }
            else {
                aux[k++] = a[j++];
            }
        }
        for(;i<=mid;i++){
            aux[k++]=a[i];
        }
        for(;j<=high;j++){
            aux[k++]=a[j];
        }
        for(k=0; k<aux.length; k++){
            a[k]=aux[k];
        }
    }
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {

    	double[] aux = new double[a.length-1];
    	mergeSortRecursive(a,aux,0,a.length-1);
        return a;
   }//end mergeSortRecursive

    static void mergeSortRecursive (double a[], double aux[], int low, int high) {

        if(high<=low){
            return;
        }
        int mid = low + (high-low)/2;
        mergeSortRecursive(a,aux, low,mid);
        mergeSortRecursive(a,aux,mid+1,high);
        recursiveMerge(a,aux,low,mid,high);
    }

    static void recursiveMerge (double a[], double aux[], int low, int mid, int high){

        for(int i=0; i<a.length; i++){
            aux[i]=a[i];
        }

        int m = low;
        int n = mid+1;
        for(int j=low; j<=high; j++){
            if(m<mid){
                a[j]=aux[n++];
            }
            else if(n>high){
                a[j]=aux[m++];
            }
            else if(aux[m]<aux[n]){
                a[j]=aux[m++];
            }
            else{
                a[j]=aux[n++];
            }
        }
    }







    public static void main(String[] args) {


    }

 }//end class

