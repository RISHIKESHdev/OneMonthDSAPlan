package src;

import java.util.Scanner;
import common.input;
import common.qList;

public class dp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        qList.getQList("dynamicprog");
        int n = input.getNum(in);
        switch(n){
            case 1: // Given an index print sum of integers from 0 to index.
                sumPrevQuery(input.getNumArr(in),input.getNumArr(in));
                break;
            case 2: // Maximum sum subset with no two consecutive elements.
                System.out.println(maxSumNoConse(input.getNumArr(in)));
                break;
            case 3: // Maximum sum subset with no two consecutive elements with two Arrays.
                System.out.println(maxSumNoConse2Array(input.getNumArr(in),input.getNumArr(in)));
                break;
            case 4: // Find min cost to fly with (i+1) or (i+3) trip
                System.out.println(minCostToFly(input.getNumArr(in)));
                break;
            case 5: // Frog jump basic (i+1) or (i+2) trip
                System.out.println(basicFrogJumpOne(input.getNumArr(in)));
                break;
            case 6: // Frog jump basic (i+1) or (i+k) trip
                System.out.println(basicFrogJumpTwo(input.getNumArr(in),input.getNum(in)));
                break;
            case 7: // max happy vacation Activity out of three
                System.out.println(maxHappyVacation(input.getNumArr(in),input.getNumArr(in),input.getNumArr(in)));
                break;
        }
        in.close();
    }
    public static void sumPrevQuery(int[] nums,int[] query){
        for(int i=1;i<nums.length;i++)
            nums[i]=nums[i]+nums[i-1];
        for(int i=0;i<query.length;i++){
            if(query[i]>=nums.length && query[i]<0) System.out.println("-1");
            else System.out.println(nums[query[i]]);
        }    
    }
    public static int maxSumNoConse(int[] nums){
        nums[1]=Math.max(nums[1],nums[0]);
        for(int i=2;i<nums.length;i++)
            nums[i]=Math.max(nums[i-1],nums[i]+nums[i-2]);
        return nums[nums.length-1];
    }
    public static int maxSumNoConse2Array(int[] nums,int[] nums1){
        nums[0] = Math.max(nums[0],nums1[0]);
        nums[1] = Math.max(nums[0],Math.max(nums[1],nums1[1]));
        for(int i=2;i<nums.length;i++)
            nums[i]=Math.max(nums[i-1],Math.max(nums[i]+nums[i-2],nums1[i]+nums[i-2]));
        return nums[nums.length-1];
    }
    public static int minCostToFly(int[] cost){
        int[] dp=new int[cost.length];
        dp[1]=Math.abs(cost[1]-cost[0]);
        dp[2]=Math.abs(cost[2]-cost[1])+dp[1];
        for(int i=3;i<cost.length;i++)
            dp[i]=Math.min(Math.abs(cost[i]-cost[i-1])+dp[i-1],cost[i]-cost[i-3]+dp[i-3]);
        return dp[cost.length-1];
    }
    public static int basicFrogJumpOne(int[] cost){
        int[] dp = new int[cost.length];
        dp[1]=Math.abs(cost[0]-cost[1]);
        for(int i=2;i<cost.length;i++)
            dp[i]=Math.min(Math.abs(cost[i]-cost[i-1])+dp[i-1],Math.abs(cost[i]-cost[i-2])+dp[i-2]);
        return dp[cost.length-1];
    }
    public static int basicFrogJumpTwo(int[] cost,int k){
        int[] dp = new int[cost.length];
        dp[1]=Math.abs(cost[0]-cost[1]);
        for(int i=2;i<cost.length;i++)
        {
            int j=1,temp=Integer.MAX_VALUE;
            while(j<=k && i-j>=0){
                temp = Math.min(temp,dp[i-j]+Math.abs(cost[i]-cost[i-j]));
                j++;
            }
            dp[i]=temp;
        }
        return dp[cost.length-1];
    }
    public static int maxHappyVacation(int[] swim,int[] catchBug, int[] homeWork){
        int[] dpSwim=new int[swim.length];
        int[] dpBug=new int[swim.length];
        int[] dpHWork=new int[swim.length];
        dpSwim[0]=swim[0];
        dpBug[0]=catchBug[0];
        dpHWork[0]=homeWork[0];
        for(int i=1;i<swim.length;i++){
            dpSwim[i]=swim[i]+Math.max(dpBug[i-1],dpHWork[i-1]);
            dpBug[i]=catchBug[i]+Math.max(dpSwim[i-1],dpHWork[i-1]);
            dpHWork[i]=homeWork[i]+Math.max(dpBug[i-1],dpSwim[i-1]);
        }
        return Math.max(dpSwim[swim.length-1], Math.max(dpBug[swim.length-1], dpHWork[swim.length-1]));
    }
}
