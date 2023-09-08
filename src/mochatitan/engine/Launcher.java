package mochatitan.engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

public class Launcher {
    public static final boolean isWindows = true;

    public static void main(String args[]){
        Launcher.openFileInVS("Variables.java");
    }
    public static void openFileInVS(String filepath){
        try {
            runCommand(new File(Variables.Global.program_parent_folder_path+Variables.Global.game_name+"\\src\\"+Variables.Global.developer+"\\"+Variables.Global.game_name.toLowerCase()), "code "+filepath);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void runCommand(File whereToRun, String command) throws Exception {
        System.out.println("Running in: " + whereToRun);
        System.out.println("Command: " + command);
        String[] commands;

        if(isWindows) {
            commands = new String[] {"cmd.exe", "/c", command};
        }else {
            commands = new String[] { "sh", "-c", command };
        }
        System.out.println(whereToRun.getAbsolutePath());
        Process process =  Runtime.getRuntime().exec(commands, null, whereToRun);

        OutputStream outputStream = process.getOutputStream();
        InputStream inputStream = process.getInputStream();
        InputStream errorStream = process.getErrorStream();

        printStream(inputStream);
        printStream(errorStream);

        boolean isFinished = process.waitFor(30, TimeUnit.SECONDS);
        outputStream.flush();
        outputStream.close();

        if(!isFinished) {
            process.destroyForcibly();
        }
    }

    private static void printStream(InputStream inputStream) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        }
    }
}

//"C:\Users\rossilt\Desktop\coding\Engine\src\mochatitan\engine\Variables.java"
//"C:\Users\rossilt\Desktop\codingEngine\src\mochatitan\engine