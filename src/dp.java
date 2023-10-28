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
            case 8: //No of journey that give odd sum with (1 or 2) steps.
                System.out.println(oddSumJourney2(input.getNumArr(in)));
                break;
            case 9: //No of journey that give even sum with (1 or 2) steps.
                System.out.println(evenSumJourney2(input.getNumArr(in)));
                break;
            case 10: //No of journey that give odd sum with (1 or 2 or 3) steps.
                System.out.println(oddSumJourney3(input.getNumArr(in)));
                break;
            case 11: //No of journey that give even sum with (1 or 2 or 3) steps.
                System.out.println(evenSumJourney3(input.getNumArr(in)));
                break;
            case 12: //Save princess with maxpoints.
                System.out.println(savePrincess(input.getNum(in),input.getNumArr(in),in));
                break;
            case 13: //Count no of Palindrome Continuous Substring
                System.out.println(countPalindromeSubstring(input.getString(in)));
                break;
            case 14: //Print longest Palindrome
                System.out.println(LongPalindromeSubstring(input.getString(in)));
                break;
            case 15: //Count no of Palindrome non Continuous Substring
                System.out.println(countPalindromeSubsequence(input.getString(in)));
                break;
            case 16: //Min cost adjacent two element add.
                System.out.println(minCostAdjacentTwoAdd(input.getNumArr(in)));
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
    public static int oddSumJourney2(int[] nums){
        int[][] dp = new int[nums.length][2];
        int i=2;
        dp[0][1]=(nums[0]%2==0)?(1):(dp[0][0]=1);
        if(nums[1]%2==0){
            dp[1][1] = dp[0][1];
            dp[1][0] = dp[0][0];
        } else {
            dp[1][1] = dp[0][0];
            dp[1][0] = dp[0][1];
        }
        while(i<nums.length){
            if (nums[i] % 2 == 0) {
                dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
                dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            } else {
                dp[i][1] = dp[i - 1][0] + dp[i - 2][0];
                dp[i][0] = dp[i - 1][1] + dp[i - 2][1];
            }
            i++;
        }
        return dp[nums.length-1][0];
    }
    public static int evenSumJourney2(int[] nums){
        int[][] dp = new int[nums.length][2];
        int i=2;
        dp[0][1]=(nums[0]%2==0)?(1):(dp[0][0]=1);
        if(nums[1]%2==0){
            dp[1][1] = dp[0][1];
            dp[1][0] = dp[0][0];
        } else {
            dp[1][1] = dp[0][0];
            dp[1][0] = dp[0][1];
        }
        while(i<nums.length){
            if (nums[i] % 2 == 0) {
                dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
                dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            } else {
                dp[i][1] = dp[i - 1][0] + dp[i - 2][0];
                dp[i][0] = dp[i - 1][1] + dp[i - 2][1];
            }
            i++;
        }
        return dp[nums.length-1][1];
    }
    public static int oddSumJourney3(int[] nums){
        int[][] dp = new int[nums.length][2];
        int i=2;
        dp[0][1]=(nums[0]%2==0)?(1):(dp[0][0]=1);
        if(nums[1]%2==0){
            dp[1][1] = dp[0][1];
            dp[1][0] = dp[0][0];
        } else {
            dp[1][1] = dp[0][0];
            dp[1][0] = dp[0][1];
        }
        if(nums[2]%2==0){
            dp[1][1] = dp[0][1]+dp[1][1];
            dp[1][0] = dp[0][0]+dp[1][0];
        } else {
            dp[1][1] = dp[0][0]+dp[1][0];
            dp[1][0] = dp[0][1]+dp[1][1];
        }
        while(i<nums.length){
            if (nums[i] % 2 == 0) {
                dp[i][1] = dp[i - 1][1] + dp[i - 2][1] + dp[i - 3][1];
                dp[i][0] = dp[i - 1][0] + dp[i - 2][0] + dp[i - 3][0];
            } else {
                dp[i][1] = dp[i - 1][0] + dp[i - 2][0] + dp[i - 3][0];
                dp[i][0] = dp[i - 1][1] + dp[i - 2][1] + dp[i - 3][1];
            }
            i++;
        }
        return dp[nums.length-1][0];
    }
    public static int evenSumJourney3(int[] nums){
        int[][] dp = new int[nums.length][2];
        int i=2;
        dp[0][1]=(nums[0]%2==0)?(1):(dp[0][0]=1);
        if(nums[1]%2==0){
            dp[1][1] = dp[0][1];
            dp[1][0] = dp[0][0];
        } else {
            dp[1][1] = dp[0][0];
            dp[1][0] = dp[0][1];
        }
        if(nums[2]%2==0){
            dp[1][1] = dp[0][1]+dp[1][1];
            dp[1][0] = dp[0][0]+dp[1][0];
        } else {
            dp[1][1] = dp[0][0]+dp[1][0];
            dp[1][0] = dp[0][1]+dp[1][1];
        }
        while(i<nums.length){
            if (nums[i] % 2 == 0) {
                dp[i][1] = dp[i - 1][1] + dp[i - 2][1] + dp[i - 3][1];
                dp[i][0] = dp[i - 1][0] + dp[i - 2][0] + dp[i - 3][0];
            } else {
                dp[i][1] = dp[i - 1][0] + dp[i - 2][0] + dp[i - 3][0];
                dp[i][0] = dp[i - 1][1] + dp[i - 2][1] + dp[i - 3][1];
            }
            i++;
        }
        return dp[nums.length-1][1];
    }
    public static String savePrincess(int testCase,int[] nums,Scanner in){
        int n=nums.length;
        String res="";
        while(testCase>=0){
            int[] dp1=new int[n+1];
            int[] dp2=new int[n+1];
            int caseLength=in.nextInt();
            dp1[0]=1;
            dp2[0]=1;
            for(int i=1;i<=caseLength;i++){
                String inStr=in.nextLine();
                char sign = inStr.charAt(0);
                int num=0;
                if(inStr.length()>1) num=(int)(inStr.charAt(1));
                if (sign == '+') {
                    dp1[(int) i] = Math.max(dp1[(int) (i - 1)] + num, Math.max(dp2[(int) (i - 1)] + num, dp1[(int) (i - 1)]));
                    dp2[(int) i] = Math.min(dp1[(int) (i - 1)] + num, Math.min(dp2[(int) (i - 1)] + num, dp2[(int) (i - 1)]));
                } else if (sign == '-') {
                    dp1[(int) i] = Math.max(dp1[(int) (i - 1)] - num, Math.max(dp2[(int) (i - 1)] - num, dp1[(int) (i - 1)]));
                    dp2[(int) i] = Math.min(dp1[(int) (i - 1)] - num, Math.min(dp2[(int) (i - 1)] - num, dp2[(int) (i - 1)]));
                } else if (sign == '*') {
                    dp1[(int) i] = Math.max(dp1[(int) (i - 1)] * num, Math.max(dp2[(int) (i - 1)] * num, dp1[(int) (i - 1)]));
                    dp2[(int) i] = Math.min(dp1[(int) (i - 1)] * num, Math.min(dp2[(int) (i - 1)] * num, dp2[(int) (i - 1)]));
                } else if (sign == '/') {
                    dp1[(int) i] = Math.max(dp1[(int) (i - 1)] / num, Math.max(dp2[(int) (i - 1)] / num, dp1[(int) (i - 1)]));
                    dp2[(int) i] = Math.min(dp1[(int) (i - 1)] / num, Math.min(dp2[(int) (i - 1)] / num, dp2[(int) (i - 1)]));
                } else {
                    dp1[(int) i] = Math.max(-1 * dp1[(int) (i - 1)], Math.max(-1 * dp2[(int) (i - 1)], dp1[(int) (i - 1)]));
                    dp2[(int) i] = Math.min(-1 * dp1[(int) (i - 1)], Math.min(-1 * dp2[(int) (i - 1)], dp2[(int) (i - 1)]));
                }
            }
            --testCase;
            res=res+dp1[n];
        }
        return res;
    }
    public static int countPalindromeSubstring(String str){
        int ans=0,n=str.length();
        boolean[][] dp=new boolean[n][n];
        for(int gap=0; gap<n; gap++){
            for(int i=0, j=gap; i<n && j<n; i++, j++){
                if(gap==0){
                   dp[i][j]=true;
                }else if(gap==1){
                   dp[i][j]=(str.charAt(i)==str.charAt(j));
                }else{
                    if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1]){
                       dp[i][j]=true;
                    }
                }
                if(dp[i][j]) ans++;
            }
        }
        return ans;
    }
    public static String LongPalindromeSubstring(String str){
        int n=str.length(),x=-1,y=-1,aux=-1;
        String ans="";
        boolean[][] dp=new boolean[n][n];
        for(int gap=0; gap<n; gap++){
            for(int i=0, j=gap; i<n && j<n; i++, j++){
                if(gap==0){
                   dp[i][j]=true;
                }else if(gap==1){
                   dp[i][j]=(str.charAt(i)==str.charAt(j));
                }else{
                    if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1]){
                       dp[i][j]=true;
                    }
                }
                if(dp[i][j]){
                    if(j-i>=aux){
                        y=j;
                        x=i;
                        ans=str.substring(x, y+1);
                    }
                }
            }
        }
        return ans;
    }
    public static int countPalindromeSubsequence(String str){
        int n=str.length();
        int[][] dp =new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=1;
            if(i<n-1){
                if(Character.compare(str.charAt(i),str.charAt(i+1))==0) dp[i][i+1]=3;
                else dp[i][i+1]=2;
            }
        }
        for(int i=3;i<=n;i++){
            for(int j=0;j<n-i+1;j++){
                int y=i+j-1;
                if(Character.compare(str.charAt(j),str.charAt(y))==0) dp[j][y]=1+dp[j][y-1]+dp[j+1][y];
                else dp[j][y]=1+dp[j][y-1]+dp[j+1][y]-dp[j+1][y-1];
            }
        }
        return dp[0][n-1];
    }
    public static int minCostAdjacentTwoAdd(int[] nums){
        int n=nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            dp[i+1][i+1]=nums[i];
            if(i<n-1) dp[i+1][i+2]=nums[i]+nums[i+1];
        }
        for(int length=3;length<=n;length++){
            int i=1;
            int j=i+length-1;
            while(j<=n){
                int k=i,ans=Integer.MAX_VALUE;
                while(k<j){
                    int possible = dp[i][k]+dp[k+1][j],axuSum=0;
                    for(int aux=i-1;aux<j-1;aux++){
                        axuSum=axuSum+nums[aux];
                    }
                    possible=possible+axuSum;
                    ans=Math.min(ans,possible);
                    k++;
                }
                dp[i][j]=ans;
                i++;
                j++;
            }
        }
        return dp[1][n];
    }
}