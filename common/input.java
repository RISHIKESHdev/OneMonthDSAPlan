package common;

import java.util.Arrays;
import java.util.Scanner;

public class input {
    public static int getNum(Scanner in){
        System.out.print("Enter an Integer value: ");
        int n=in.nextInt();
        return n;
    }
    public static int[] getNumArr(Scanner in){
        System.out.print("Enter Array size: ");
        int n=in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=getNum(in);
        }
        System.out.print("Array: ");
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public static int[][] get2dNumArr(Scanner in){
        int n,m;
        System.out.print("Enter Row Array size: ");
        m=in.nextInt();
        System.out.print("Enter Column Array size: ");
        n=in.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=getNum(in);
            }
        }
        System.out.print("Array: ");
        for(int i=0;i<n;i++) System.out.println(Arrays.toString(arr[i]));
        return arr;
    }
    public static String getString(Scanner in){
        System.out.print("Enter a String value: ");
        String ss = in.next();
        return ss;
    }
    public static char getChar(Scanner in){
        System.out.print("Enter a String value: ");
        char ss = in.next().charAt(0);
        return ss;
    }
    public static String[] getStringArr(Scanner in){
        System.out.print("Enter Array size: ");
        int n=in.nextInt();
        String arr[] = new String[n];
        for(int i=0;i<n;i++){
            arr[i]=getString(in);
        }
        System.out.print("Array: ");
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public static char[] getCharArr(Scanner in){
        System.out.print("Enter Array size: ");
        int n=in.nextInt();
        char arr[] = new char[n];
        for(int i=0;i<n;i++){
            arr[i]=getChar(in);
        }
        System.out.print("Array: ");
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public static int[] getNumArrAsen(Scanner in){
        System.out.print("Enter Array size: ");
        int n=in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=getNum(in);
        }
        Arrays.sort(arr);
        System.out.print("Array: ");
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
