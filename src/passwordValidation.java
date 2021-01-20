import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//source - https://stackoverflow.com/questions/40074840/reading-a-csv-file-into-a-array
public class passwordValidation {

    public boolean passwordValidationMethod(String user, String pass){

        boolean valid = false;
        String fileName= "login.csv";
        File file= new File(fileName);

        // this gives you a 2-dimensional array of strings
        List<List<String>> lines = new ArrayList<>();
        Scanner inputStream;

        try{
            inputStream = new Scanner(file);

            while(inputStream.hasNext()){
                String line = inputStream.next();
                String[] values = line.split(",");
                // this adds the currently parsed line to the 2-dimensional string array
                lines.add(Arrays.asList(values));
                inputStream.nextLine();
            }

            inputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // the following code lets you iterate through the 2-dimensional array
        int lineNo = 1;
        for(List<String> line: lines) {
            int columnNo = 1;
            for (String value: line) {
                System.out.println("Line " + lineNo + " Column " + columnNo + ": " + value);
                columnNo++;
            }
            lineNo++;
        }

        // checks if user name and password match exists
        for(List<String> line: lines) {
            if ( line.get(0).equals(user) && line.get(1).equals(pass) ){
                valid = true;
            }
        }

        String[][] array2D = new String[lines.size()][];
        for (int i = 0; i < array2D.length; i++) {
            String[] row = lines.get(i).toArray(new String[0]);
            array2D[i] = row;
        }

        return valid;
    }
}