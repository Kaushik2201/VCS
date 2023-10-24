import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IPconfig {
    public static void ipconfig (){
        try {

            ProcessBuilder processBuilder = new ProcessBuilder("ipconfig");

            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();


            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }


           
            CMD.main(null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
