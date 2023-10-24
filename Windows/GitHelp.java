
public class GitHelp {

    public static void gitdisp(){
        System.out.println();
        System.out.println("Git Help");
        System.out.println();
        System.out.println("git init");
        System.out.println();
        System.out.println("To add all files");
        System.out.println("git add -A");
        System.out.println("git add --all");
        System.out.println("git add .");
        System.out.println();
        System.out.println("To add specific file -> git add <filename>");
        System.out.println();
        System.out.println("To commit all files");
        System.out.println("git commit -u z -> to commit all files without message" );
        System.out.println("git commit -u -m {message} -> to commit all files with message message without double quotes" );
        System.out.println();
        System.out.println("Commit specific file");
        System.out.println("git commit <file name> z -> to commit all files without message" );
        System.out.println("git commit <File name> -m {message} -> to commit all files with message message without double quotes" );
        System.out.println("q -> exits the terminal");
        System.out.println();
        System.out.println("For CMD related help type {help}");
        System.out.println();
        CMD.main(null);
    }
}
