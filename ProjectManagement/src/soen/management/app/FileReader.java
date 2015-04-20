package soen.management.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
 

public class FileReader {
/*
	Scanner input;
	
	input = new Scanner(new File(""));
	while (input.hasNext()){
		String something = (String)input.nextLine();
		System.out.println(something);
	}
	*/
    public static void main(String[] args) {
    	
    }
    
    public String getFileData(){
    	System.out.println("did shit");
        File file = new File("src/hej.txt");

        BufferedReader br = null;

        String line = "";
        
        try {
            java.io.FileReader fr = new java.io.FileReader(file);
            br = new BufferedReader(fr);

            

            while( (line = br.readLine()) != null ) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.toString());
        } catch (IOException e) {
            System.out.println("Unable to read file: " + file.toString());
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Unable to close file: " + file.toString());
            }
            catch(NullPointerException ex) {
            }
        }
        
    	return line;
    }
}
