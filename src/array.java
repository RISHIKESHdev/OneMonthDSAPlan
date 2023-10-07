package src;

import java.util.Scanner;

import common.*;

public class array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        qList.getQList("array");
        int n = input.getNum(in);
        switch(n){
            case 1: // 3rd max
                System.out.println(thirdMax(input.getNumArr(in)));
                break;
        }
        in.close();
    }

    public static int thirdMax(int[] nums){
        long firstmax=Long.MIN_VALUE;
        long secondmax=Long.MIN_VALUE;
        long thirdmax=Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>firstmax){
                thirdmax=secondmax;
                secondmax=firstmax;
                firstmax=nums[i];
            }else if(nums[i]>secondmax && nums[i]<firstmax){
                thirdmax=secondmax;
                secondmax=nums[i];
            }else if(nums[i]>thirdmax && nums[i]<secondmax) thirdmax =nums[i];
        }
        return (int)(thirdmax==Long.MIN_VALUE?firstmax:thirdmax);
    }
}
