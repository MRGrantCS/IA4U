import java.io.FileWriter;
import java.io.IOException;

public class appendCSV {
    public appendCSV(){
        String fileName= "login.csv";
        String pass = "1234";
        String user = "Bob";
        try {
            FileWriter file = new FileWriter(fileName, true);
            file.append("\n");
            file.append(user + "," + pass);
            file.flush();
            file.close();
        }
         catch (IOException e) {
            e.printStackTrace();
        }

    }
}
