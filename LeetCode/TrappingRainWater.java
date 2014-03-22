/*
    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

    For example, 
    Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

// get the highest left and right bar, and then calcualte how much water we can trap
// time: O(n); space:O(n)
public class Solution {
    public int trap(int[] A) {
        if (A==null || A.length==0)
            return 0;
        int N = A.length;
        int[] L = new int[N], R = new int[N];
        int lmax = 0, rmax = 0, sum = 0;
        for (int i=N-1; i>=0; i--){
            R[i] = rmax;
            rmax = Math.max(A[i], rmax);
        }
        for (int i=0; i<N; i++){
            L[i] = lmax;
            lmax = Math.max(A[i], lmax);
            int bar = Math.min(L[i], R[i]);
            if (bar>A[i])
                sum += bar - A[i];
        }
        return sum;
    }
}