import java.util.Scanner;


public class CMD {

    public static Scanner sc = new Scanner(System.in);
    public static int x = 0;
    public static void main(String[] args) {


        String osName = System.getProperty("os.name");
        String osused;

        if(x == 0){
            if (osName != null && osName.toLowerCase().contains("windows")) {
            osused = osName;
        }

        else {
            osused = "Not using Windows";
        }

        if (!osused.equals("Not using Windows")){ 

            System.out.println();
            System.out.println("System in use - Microsoft "+osused);
            System.out.println("(c) Microsoft Corporation. All rights reserved.");

            x++;

        }
    }

        int t1 = Integer.MAX_VALUE;
        int t = 1;
        while(t1-- >0){
            while(t -- > 0){
            System.out.println();
            System.out.print(System.getProperty("user.dir")+"> ");
            String command = sc.next();
            String command2 = "";
            String command3 = "";
            String command4 = "";
            if(command.contains("git")){
                command2 = sc.next();
            }

            if(command2.contains("add")){
                command3 = sc.next();
            }

            if(command2.contains("commit")){
                command3 = sc.next();
                command4 = sc.next();
            }

            switch (command) {
                case "dir":
                    Dir.dir();
                    break;

                case "cd":
                    String cd = sc.next();
                    CD.cd(cd);
                    break;
            
                case "q":
                    System.out.println();
                    System.out.println("System Exited");
                    System.out.println();
                    System.exit(0);
                    break;
                
                case "pwd":
                    PWD.pwd();
                    break;

                case "ipconfig":
                    IPconfig.ipconfig();
                    break;

                case "mkdir":
                    String dirname = sc.next();
                    MKDir.mkdir(dirname);
                    break;

                case "git":
                    switch (command2) {
                        case "init":
                            Gitinit.initGitRepository();
                            break;
                        case "add":
                            switch (command3) {
                                case "-A":
                                    GitAddAll.gitaddall();
                                    break;

                                case "--all":
                                    GitAddAll.gitaddall();
                                    break;
                                
                                case ".":
                                    GitAddAll.gitaddall();
                                    break;
                            
                                default:
                                    GitAddFile.gitaddfile(command3);
                                    break;
                            }
                        
                        case "commit":
                            switch (command3) {
                                case "-u":
                                    
                                switch (command4) {
                                    case "-m":
                                        String mess = sc.nextLine();
                                        GitCommitAll.gitcommitall(mess);
                                        break;
                                
                                    default:
                                        GitCommitAll.gitcommitall("");
                                        break;
                                }

                                    break;
                            
                                default:

                                switch (command4) {
                                    case "-m":
                                        String mess = sc.nextLine();
                                        GitCommitFile.gitcommitfile(command3, mess);
                                        break;
                                
                                    default:
                                        GitCommitFile.gitcommitfile(command3, "");
                                        break;
                                }
                                    break;
                            }

                            default:
                                GitHelp.gitdisp();
                                break;

                    }

                    default:
                    Help.disp();
                    break;
            }
            }
        }


    }
}
