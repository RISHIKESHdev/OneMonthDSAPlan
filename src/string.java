package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.*;

public class string {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        qList.getQList("string");
        int n = input.getNum(in);
        switch(n){
            case 1: // find longest comman prefix
                System.out.println(longestCommonPrefix(input.getStringArr(in)));
                break;
            case 2: // find ranges
                System.out.println(summaryRanges(input.getNumArrAsen(in)));
                break;
        }
        in.close();
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String prefix = strs[0];
        for(int i=1;i<=strs.length-1;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
    public static List<String> summaryRanges(int[] nums){
        StringBuilder sb = new StringBuilder();
        List<String> ans = (List<String>) new ArrayList<String>();
        boolean flag = false;
        for(int i=0;i<nums.length;i++){
            if(i+1<nums.length && nums[i] + 1 == nums[i+1]){
                if(!flag){
                    sb.append(nums[i]);
                    flag = true;
                }
            } else{
                if(flag){
                    sb.append("->");
                    flag = false;
                }
                sb.append(nums[i]);
                ((ArrayList<String>) ans).add(sb.toString());
                sb = new StringBuilder();

            }
        }
        return ans;
    }
}
