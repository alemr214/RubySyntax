package itver.com;


import java.io.File;

public class Main {
    private static File file;
    public static void main(String[] args) {
        if(file == null){
            System.out.println("File not found");
            System.exit(-1);
        }

        System.out.println("Hello world!");
    }
}