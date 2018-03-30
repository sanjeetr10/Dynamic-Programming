package com.dp.problems.skeleton;

public interface Ladder {
    int ladderRecursive(int n, int k);

    int ladderTopDown(int n, int k, int[] arr);

    int ladderBottomUp(int n, int k);

    int ladderBottomNTime(int n, int k);
}
