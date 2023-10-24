import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExecuteGitCommands {
        public static void executeGitCommand(String repoPath, String... command) {
        try {
            List<String> commandList = new ArrayList<>();
            commandList.add("git");
            commandList.addAll(List.of(command));

            ProcessBuilder processBuilder = new ProcessBuilder(commandList);
            processBuilder.directory(new java.io.File(repoPath));
            Process process = processBuilder.start();


            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.err.println("Command failed");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
