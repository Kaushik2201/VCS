
import java.io.File;


public class MKDir{
    public static void mkdir(String dirname) {
        String currentDirectory = System.getProperty("user.dir"); 
        String directoryName = dirname; 

        File directory = new File(currentDirectory, directoryName);

        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Directory created successfully.");
                CMD.main(null);
            } else {
                System.err.println("Failed to create directory.");
                CMD.main(null);
            }
        } else {
            System.out.println("Directory already exists.");
            CMD.main(null);
        }
    }
}
