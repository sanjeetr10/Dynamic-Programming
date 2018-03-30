package com.dp.problems.skeleton;

public interface MinCoin {
    //Coin Change Recursive
    int minCoinRecursive(int[] coins, int amount, int n);

    //Coin change Top Down
    int minCoinTopDown(int[] coins, int amount, int n, int[] arr);

    int minCoinBottomUp(int[] coins, int amount, int n);
}
