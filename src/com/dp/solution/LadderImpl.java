package com.dp.solution;

//Calculate the Total number of ways to reach the nth position of a ladder from ground,By taking step size of 1,2,3,.....,k.

import java.util.Arrays;
import com.dp.problems.skeleton.Ladder;

public class LadderImpl implements Ladder {

    //Recursive Solution Time Complexity: O(k^n)   Space Complexity: O(n)

    @Override
    public int ladderRecursive(int n, int k){ //n is the Position we need to reach, K is step size from 1,2,....,k
        if(n==0){
            return 1;
        }else if(n <0){
            return 0;
        }

        int ans = 0;

        for(int i=1;i<=k;i++){
            ans += ladderRecursive(n-i,k);
        }
        return ans;
    }

    //Dynamic Programming (Top Down )  Time Complexity: O(kn)   Space Complexity: O(n)

    @Override
    public int ladderTopDown(int n, int k, int[] arr){
        if(n==0){
            arr[n] = 1;
            return arr[n];
        }

        if(arr[n] != -1){
            return arr[n];
        }

        arr[n] = 0;

        for(int step=1;step<=k;step++){
            if(n - step > -1){
                arr[n] += ladderTopDown(n-step,k,arr);
            }
        }

        return arr[n];
    }

    //Dynamic Programming (Bottom Up)   Time Complexity: O(kn)   Space Complexity: O(n)

    @Override
    public int ladderBottomUp(int n, int k){
        int[] arr = new int[n+1];
        arr[0] = 1;

        for(int pos=1;pos<=n;pos++){
            arr[pos] = 0;
            for(int step=1;step<=k;step++){
                if(pos - step > -1){
                    arr[pos] += arr[pos - step];
                }
            }
        }
        return arr[n];
    }

    //Dynamic Programming (Bottom Up Linear time)   Time Complexity: O(n)   Space Complexity: O(n)

    @Override
    public int ladderBottomNTime(int n, int k){
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;

        for(int pos=2;pos<=n;pos++){
            arr[pos] = 2* arr[pos-1];
            if(pos- ( k +1) > -1){
                arr[pos] -= arr[pos - (k +1)];
            }
        }
        return arr[n];
    }

    public static void main(String[] args) {
        LadderImpl ladder = new LadderImpl();
        int noOfWays;

        //Check Ladder recursive
        System.out.println("Ladder recursive");
        noOfWays = ladder.ladderRecursive(5,4);
        System.out.println(noOfWays);

        //Check Ladder Top Down
        int[] arr = new int[500];
        Arrays.fill(arr,-1);
        System.out.println("Ladder Top Down");
        noOfWays = ladder.ladderTopDown(5,4,arr);
        System.out.println(noOfWays);

        //Check for Ladder Bottom up
        System.out.println("Ladder Bottom up");
        noOfWays = ladder.ladderBottomUp(6,3);
        System.out.println(noOfWays);

        //Check for Ladder Bottom up O(n)
        System.out.println("Ladder Bottom up O(N) time");
        noOfWays = ladder.ladderBottomNTime(6,3);
        System.out.println(noOfWays);
    }
}
