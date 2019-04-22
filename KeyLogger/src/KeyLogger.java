import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KeyLogger {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private static Date today = new Date();

//    public static void main(String[] args) throws IOException {
//        String name = "D:\\Misc\\Logs\\" + dateFormat.format(today) + ".txt";
//        FileWriter writer = new FileWriter(name,true);
//
//        while (true) {
//            String line = reader.readLine();
//            if (line.equals("escape"))
//                break;
//            writer.write(line + "\r" + "\n");
//            writer.flush();
//        }
//
//        reader.close();
//        writer.close();
//    }
}