import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class GitAddAll {

    public static void gitaddall() {
        try {

            String repositoryPath = System.getProperty("user.dir");

            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.directory(new File(repositoryPath));

            processBuilder.command("git", "add", "--all");

            Process process = processBuilder.start();


            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("All changes added to staging.");
                CMD.main(null);
            } else {
                System.err.println("Error: Failed to add changes to staging.");
                CMD.main(null);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

