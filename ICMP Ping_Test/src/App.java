import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {

    // method for finding the ping statistics of website
    static void commands(ArrayList<String> commandList) throws Exception {

        // creating the sub process, execute system command
        ProcessBuilder builder = new ProcessBuilder(commandList);
        Process process = builder.start();

        // to read the output
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String s = null;

        System.out.println("Standart output: ");
        while ((s = input.readLine()) != null) {
            System.out.println(s);
        }
        System.out.println("Printing error (if any): ");
        while ((s = error.readLine()) != null) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Exception {

        // creating list for commands
        ArrayList<String> commandList = new ArrayList<String>();

        commandList.add("ping");
        // can be replaced by IP
        commandList.add("www.oracle.org");
        App.commands(commandList);

    }
}
