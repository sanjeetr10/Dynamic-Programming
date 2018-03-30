package com.dp.solution;

import java.util.Arrays;
import com.dp.problems.skeleton.Fibonacci;

//Calculate the nth FibonacciImplImpl number

public class FibonacciImpl implements Fibonacci {

    @Override
    public int fibRecursion(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibRecursion(n - 1) + fibRecursion(n - 2);
    }

    @Override
    public int fibTopDown(int n, int[] arr) {
        if (n == 0 || n == 1) {
            arr[n] = n;
            return arr[n];
        }

        if (arr[n] != -1) {
            return arr[n];
        }

        arr[n] = fibTopDown(n - 1, arr) + fibTopDown(n - 2, arr);
        return arr[n];
    }

    @Override
    public int fibBottomUp(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    @Override
    public int fibBottomUpConstantSpace(int n) {
        int a = 0;
        int b = 1;
        int c = -1;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        FibonacciImpl fib = new FibonacciImpl();

        //FibonacciImplImpl Recursion Check
        System.out.println("FibonacciImplImpl Recursion Check");
        System.out.println(fib.fibRecursion(5));
        System.out.println(fib.fibRecursion(6));
        System.out.println(fib.fibRecursion(7));

        //FibonacciImplImpl Dynamic Programming (Top Down) Check
        int[] arr = new int[500];
        Arrays.fill(arr, -1);
        System.out.println("FibonacciImplImpl Dynamic Programming (Top Down)");
        System.out.println(fib.fibTopDown(5, arr));
        System.out.println(fib.fibTopDown(6, arr));
        System.out.println(fib.fibTopDown(7, arr));

        //FibonacciImplImpl Dynamic Programming (Bottom Up) Check
        System.out.println("FibonacciImplImpl Dynamic Programming (Bottom Up)");
        System.out.println(fib.fibBottomUp(5));
        System.out.println(fib.fibBottomUp(6));
        System.out.println(fib.fibBottomUp(7));

        //FibonacciImplImpl Dynamic Programming (Bottom Up with Constant Space) Check
        System.out.println("FibonacciImplImpl Dynamic Programming (Bottom Up with Constant space)");
        System.out.println(fib.fibBottomUpConstantSpace(5));
        System.out.println(fib.fibBottomUpConstantSpace(6));
        System.out.println(fib.fibBottomUpConstantSpace(7));
    }
}
