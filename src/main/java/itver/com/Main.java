package itver.com;

import Analizador.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    private static File file;
    public static void main(String[] args) {
        getFile();
        if(file == null){
            System.out.println("File not found");
            System.exit(-1);
        }
        try{
            Sintaxis parser = new Sintaxis(new SintaxisTokenManager(
                    new SimpleCharStream(
                            new FileReader(Main.file)
                    )));
            parser.parse();
            System.out.println("Success");
        }catch(ParseException e){
            System.out.println("Error: " + e.getMessage());
        }catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }catch (TokenMgrError e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void getFile(){
        JFileChooser search = new JFileChooser();
        FileNameExtensionFilter filterTxt = new FileNameExtensionFilter("Text Files", "txt");
        FileNameExtensionFilter filterRb = new FileNameExtensionFilter("Ruby files", "rb");
        search.setFileFilter(filterTxt);
        search.setFileFilter(filterRb);
        int option = search.showOpenDialog(null);
        if(option == JFileChooser.APPROVE_OPTION){
            file = search.getSelectedFile();
        }
    }
}