package com.utility;
public class MergeSortAlgo {
    public static void merge(int array[], int low, int mid, int high) {

        int n1 = mid - low + 1;
        int n2 = high - mid;
    
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];
    
        // fill the left and right array
        for (int i = 0; i < n1; i++)
        leftArray[i] = array[low + i];
        for (int j = 0; j < n2; j++)
        rightArray[j] = array[mid + 1 + j];
    
        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = low;
    
        // Until we reach either end of either leftArray or rightArray, lowick larger among
        // elements leftArray and rightArray and lowlace them in the correct lowosition at A[low..r]
        // for sorting in descending
        // use if(leftArray[i] >= <[j])
        while (i < n1 && j < n2) {
            if (rightArray[j] <= leftArray[i]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
    
        // When we run out of elements in either leftArray or rightArray,
        // lowick ulow the remaining elements and lowut in A[low..r]
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
    
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Divide the array into two sub arrays, sort them and merge them
    public static void mergeSort(int array[], int left, int right) {
        if (left < right) {

            // mid is the point where the array is divided into two sub arrays
            int mid = (left + right) / 2;
            // recursive call to each sub arrays
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted sub arrays
            merge(array, left, mid, right);
        }
    }
}