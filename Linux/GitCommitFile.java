import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class GitCommitFile {

    public static void gitcommitfile(String file, String mess) {
        try {

            String repositoryPath = System.getProperty("user.dir");
            String commitMessage = mess ; 
            String fileName = file; 

            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.directory(new File(repositoryPath));


            processBuilder.command("git", "rev-parse", "--abbrev-ref", "HEAD");
            Process branchProcess = processBuilder.start();
            String branchName = readProcessOutput(branchProcess).trim();


            processBuilder.command("git", "status", "--porcelain");
            Process statusProcess = processBuilder.start();
            String statusOutput = readProcessOutput(statusProcess);

            if (!statusOutput.contains(fileName)) {
                System.out.println("No such file exist or it has already been commited");
                CMD.main(null);
            } else {

                processBuilder.command("git", "add", fileName);

                Process addProcess = processBuilder.start();
                waitForProcess(addProcess);

                processBuilder.command("git", "commit", "-m", "[" + branchName + "] " + commitMessage);

                Process commitProcess = processBuilder.start();
                waitForProcess(commitProcess);

                System.out.println("Commit successful for '" + fileName + "' on branch '" + branchName + "'.");
                CMD.main(null);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String readProcessOutput(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append(System.lineSeparator());
        }
        return output.toString();
    }

    private static void waitForProcess(Process process) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        int exitCode = process.waitFor();

        if (exitCode != 0) {
            System.err.println("Error: Commit failed " );
            CMD.main(null);
        }
    }
}
