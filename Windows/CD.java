import java.io.File;
import java.io.IOException;

public class CD {
        public static void cd (String newDirectoryPath){

        ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.command("cmd", "/c", "cd", newDirectoryPath);

        processBuilder.redirectErrorStream(true);
        
        try {
                Process process = processBuilder.start();
        

                int exitCode = process.waitFor();
        

                if (exitCode == 0) {
                    System.out.println();
                    System.out.println("Changed working directory to: " + newDirectoryPath);
                    File newCurrentDir = new File(newDirectoryPath);
                    System.setProperty("user.dir", newCurrentDir.getAbsolutePath());
                        CMD.main(null);
                    } else {
                        System.out.println("Failed to change working directory.");
                        System.out.println("Please mention the correct path or complete path");
                        CMD.main(null);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
    }
}
