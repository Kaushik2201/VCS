import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Dir {
        public static void dir (){
        // Get the current working directory
         Path currentDirectory = Paths.get(System.getProperty("user.dir"));

        try {
            System.out.println("Files and directories in the current directory:");

            // List files and directories using a DirectoryStream
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(currentDirectory)) {
                for (Path entry : directoryStream) {
                    if (Files.isDirectory(entry)) {
                        System.out.println("Directory: " + entry.getFileName());
                    } else if (Files.isRegularFile(entry)) {
                        System.out.println("File: " + entry.getFileName());
                    } else {
                        System.out.println("Other: " + entry.getFileName());
                    }
                }
                    CMD.main(null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
