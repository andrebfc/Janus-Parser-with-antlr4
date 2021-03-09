import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class manageFileOut {

    File file;

    public void initFile(String fileInput) throws IOException{

        file = new File("./src/out/" + fileInput + ".cpp");

        if(!file.exists()) {
            file.createNewFile();
            //System.err.println("Error file does not exist");
            //System.exit(1);
        }
        //else{ // file exist
            //file.delete();
            //file.createNewFile();
        //}
        file.setWritable(true);
        file.setReadable(true);
        file.setExecutable(true);

    }


    public void writeFile(String a){

        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String lineRead = null;

            List<String> lines = Files.readAllLines(file.toPath());

            int i = 0;
            lineRead = reader.readLine();
            while(lineRead.contains("#include")){
                i++;
                lineRead = reader.readLine();
            }
            //lines.add(i,"/n");
            Files.write(file.toPath(), lines);

        }
        catch (IOException e) {
            System.out.println("exception: " + e);
        }
    }

}
