package com.dp.solution;

import com.dp.problems.skeleton.MinCoin;
import java.util.Arrays;

//Calculate the minimum number of coins needed to get the given Amount, using the given Currency
public class MinCoinImpl implements MinCoin {

    //Coin Change Recursive
    @Override
    public int minCoinRecursive(int[] coins, int amount, int n){
        if(amount==0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int temp;

        for(int i=0;i<n;i++){
            if(amount-coins[i] > -1){
                temp = minCoinRecursive(coins,amount-coins[i],n);
                if(temp + 1 < min){
                    min = temp + 1;
                }
            }
        }
        return min;
    }

    //Coin change Top Down
    @Override
    public int minCoinTopDown(int[] coins, int amount, int n, int[] arr){
        if(amount==0){
            arr[amount] = 0;
            return arr[amount];
        }

        try{
            if(arr[amount] != -1){
                return arr[amount];
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ERROR---> " + amount);
            System.out.println(e.getMessage());
        }

        int min = Integer.MAX_VALUE;
        int temp;

        for(int i=0;i<n;i++){
            if((amount-coins[i]) > -1){
                temp = minCoinTopDown(coins,amount-coins[i],n,arr);
                if(temp + 1 < min){
                    min = temp + 1;
                }
            }
        }
        arr[amount] = min;
        return arr[amount];

    }

    //Coin change Bottom Up

    @Override
    public int minCoinBottomUp(int[] coins, int amount, int n){
        int[] arr = new int[amount+1];
        arr[0] = 0;
        int min = Integer.MAX_VALUE;
        int temp;

        for(int money=1;money<=amount;money++){
            min = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                if(money-coins[i] > -1){
                    temp = arr[money-coins[i]];
                    if(temp + 1 < min){
                        min = temp +1;
                    }
                }
            }
            arr[money] = min;
        }

//        System.out.println(Arrays.toString(arr));
        return arr[amount];
    }

    public static void main(String[] args) {
        MinCoinImpl minCoin = new MinCoinImpl();
        int min;
        int[] coins = {1,7,10};
        int[] coinsIndian = {1,2,5,10,50};
        int nIndian = 5;
        int amountIndian =13;
        int n = 3;
        int amount = 23;

        //Coin change Recursive Check
        System.out.println("Coin change Recursive Check");
        min = minCoin.minCoinRecursive(coins,amount,n);
        System.out.println(min);

        //Coin change Top Down
        System.out.println("Coin change Top Down");
        int[] arr = new int[500];
        Arrays.fill(arr,-1);
        min = minCoin.minCoinTopDown(coins,amount,n,arr);
        System.out.println(min);

        //Coin change Bottom Up
        System.out.println("Coin change Bottom Up");
        min = minCoin.minCoinBottomUp(coins,amount,n);
        System.out.println(min);

        //Indian Coin
        System.out.println("Checking for Indian Coin");
        //Coin change Recursive Check
        System.out.println("Coin change Recursive Check");
        min = minCoin.minCoinRecursive(coinsIndian,amountIndian,nIndian);
        System.out.println(min);

        //Coin change Top Down
        System.out.println("Coin change Top Down");
        Arrays.fill(arr,-1);
        min = minCoin.minCoinTopDown(coinsIndian,amountIndian,nIndian,arr);
        System.out.println(min);

        //Coin change Bottom Up
        System.out.println("Coin change Bottom Up");
        min = minCoin.minCoinBottomUp(coinsIndian,amountIndian,nIndian);
        System.out.println(min);
    }
}
