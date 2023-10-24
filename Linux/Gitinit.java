

public class Gitinit{
    public static void initGitRepository() {
        String repoPath = System.getProperty("user.dir");
        System.out.println(repoPath);
        ExecuteGitCommands.executeGitCommand(repoPath, "init");
        CMD.main(null);
    }
}
