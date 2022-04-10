package com.service;
import java.util.Scanner;

public class Problem1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of transaction");
        int nTrans = sc.nextInt();
        
        
        int[] array = new int[nTrans];
        int[] cValues = new int[nTrans];
        System.out.println("Enter the values of transaction");
        for(int index=0; index < nTrans ; index++){
            array[index] = sc.nextInt();
            cValues[index] =  index == 0 ? 0 : (cValues[index - 1] + array[index]);
        }
        
        System.out.println("Enter the target value");
        int target = sc.nextInt();

        int noOfTransactions = linearApproachTrans(cValues, 0, nTrans, target);
        if(noOfTransactions < 1){
            System.out.println("Given target is not achieved");
        } else {
            System.out.println("Transactions Taken"+ noOfTransactions);
        }
        
        sc.close();
    }

    public static int linearApproachTrans(int[] cValues, int low, int high, int target){
        if(cValues[cValues.length - 1] < target){
            return -1;
        }

        if(cValues[0] > target){
            return 1;
        }

        if(low > high){
            return -1;
        }
        
        int mid = (low + high) /2;
        
        if(target<= cValues[mid]){
            if(target > cValues[mid]){
                return mid + 1;
            } else {
                return linearApproachTrans(cValues, low, mid -1, target);
            }
        }
        
        return linearApproachTrans(cValues, mid + 1, high, target);
    }    
}