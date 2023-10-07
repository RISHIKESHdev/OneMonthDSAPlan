package common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class qList {
    public static void getQList(String key){
        try {
            BufferedReader r;
            switch(key){
                case "math":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\questions\\math.txt"));
                    break;
                case "hash":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\questions\\hash.txt"));
                    break;
                case "convert":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\questions\\convert.txt"));
                    break;
                case "trie":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\questions\\trie.txt"));
                    break;
                case "twopointer":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\questions\\twopointer.txt"));
                    break;
                case "string":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\questions\\string.txt"));
                    break;
                case "dynamicprog":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\questions\\dynamicprog.txt"));
                    break;
                case "binarysearch":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\questions\\binarysearch.txt"));
                    break;
                case "bitmanipulation":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\questions\\bitmanipulation.txt"));
                    break;
                case "array":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\questions\\array.txt"));
                    break;
                case "recursion":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\questions\\recursion.txt"));
                    break;
                case "stack":
                    r = new BufferedReader( new FileReader("C:\\Users\\RISHIsquad\\Desktop\\DSA23\\common\\questions\\stack.txt"));
                    break;
                default:
                    r = new BufferedReader( new FileReader( "./math.txt" ));
            }
            String line = null;
            while ((line = r.readLine()) != null) {
                System.out.println("\t"+line);
            }
            r.close();
        } catch (FileNotFoundException e) {
            e.getStackTrace();} 
            catch (IOException e) {
                e.getStackTrace();}
    }
}

