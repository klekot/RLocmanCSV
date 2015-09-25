package info.poligon.rlocmancsv;

/**
 * Created by kataev on 25.09.2015.
 */
public class Main {
    public static String inFile;
    public static String outFile;
    public static void main(String[] args) {
        inFile = args[0];
        outFile = args[1];
        System.out.print(inFile + " -> " + outFile);
    }
}
