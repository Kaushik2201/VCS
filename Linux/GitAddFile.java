import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class GitAddFile {

    public static void gitaddfile(String str) {

        try {

            String repositoryPath = System.getProperty("user.dir") ;

            String fileName = str;

            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.directory(new File(repositoryPath));


            processBuilder.command("git", "add", fileName);

            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("File with name '" + fileName + "' added to staging.");
                CMD.main(null);
            } else {
                System.err.println("File Not Found !");
                CMD.main(null);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
