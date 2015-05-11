package soen.management.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
 

public class FileReader {
    public String getFileData(String filename){
    	String line;
        StringBuilder everything = new StringBuilder();
        
        File file = new File("src/"+filename+".json");

        BufferedReader br = null;
        
        try {
            java.io.FileReader fr = new java.io.FileReader(file);
            br = new BufferedReader(fr);
    
            while( (line = br.readLine()) != null) {
               everything.append(line);
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
        
    	return everything.toString();
    }
    public void saveFileData(String content, String filename){
		try {
			File file = new File("src/"+filename+".json");
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
