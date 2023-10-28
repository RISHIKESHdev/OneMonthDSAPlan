package src;

import java.util.Scanner;
import common.input;
import common.qList;

public class auxilary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        qList.getQList("dynamicprog");
        int n = input.getNum(in);
        switch(n){
            case 1:
                System.out.println(findMissOneRepeate(input.getNumArr(in)));
                break;
        }
        in.close();   
    }
    public static int findMissOneRepeate(int[] nums){
        int j=0,n=nums.length,countN=0,total=0,sum=0,temp=0;
        total=(n*(n+1)/2);
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
            if(nums[i]==n) countN++;
        }
        if(countN==0) return(n);
        else if(countN>=2) return(total-sum+n);
        else{
            for(int i=0;i<n;i++){
                if (nums[i]==n) continue;
                if(nums[i]>n){
                    temp=nums[i]-n;
                    if(temp>n){
                        j=i+1;
                        break;
                    }else if(nums[temp]>n){
                        j=temp;
                        break;
                    }
                    nums[temp]=nums[temp]+n;
                }else nums[nums[i]]=nums[nums[i]]+n;
            }
            return(j+total-sum);
        }
    }
}
