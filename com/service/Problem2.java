package com.service;
import java.util.Scanner;
import com.utility.*;

public class Problem2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of currency denominations");
        int size = sc.nextInt();
        
        int[] denominations = new int[size];
        int[] counter = new int[size];

        System.out.println("Enter the currency denomination value");
        for(int index=0; index < size ; index++){
            denominations[index] = sc.nextInt();
        }

        System.out.println("Enter the amount you want to pay");
        int amount = sc.nextInt();
        
        MergeSortAlgo.mergeSort(denominations, 0, denominations.length - 1);

        int remainingAmount = countNotes(denominations, counter, 0, size - 1, amount);

        if(remainingAmount != 0) {
            System.out.println("Remaining amount of "+ remainingAmount + " cant be paid in given denominator");
        }
        else {
            System.out.println("Your payment approach in order to give min no of notes will be");
            for(int index = 0; index < size; index ++){
                if(counter[index] > 0){
                    System.out.println(denominations[index]+ ":"+ counter[index]);
                }
            }
        }
        sc.close();
    }

    public static int countNotes(int[] denominations, int[] counter, int low, int high, int amount){
        if(amount == 0){
            return 0;
        }

        if(amount < denominations[high]){
            return amount;
        }

        if(amount >= denominations[low]){
            counter[low] = amount/denominations[low];
            amount = amount % denominations[low];
            return countNotes(denominations, counter, low + 1, high, amount);
        }

        int mid = (low + high)/ 2;
        
        if(amount < denominations[mid]){
            return countNotes(denominations, counter, mid + 1, high, amount);
        }
        return countNotes(denominations, counter, low + 1 , mid, amount);
    }
}