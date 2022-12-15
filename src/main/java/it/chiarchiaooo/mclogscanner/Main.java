package it.chiarchiaooo.mclogscanner;

import java.io.File;

/**
 * @Author:Chiarchiaooo
 * @Description:Auto MC server log file scanner
 */


public class Main {
    private void start(String[] args) {
        new File("output").mkdirs();
        createDir("ciao",0);


    }

    private File createDir(String name, int counter) {
        File dir = new File(name);

        if (dir.exists() && counter >= 1) createDir(name.replaceAll(".$", String.valueOf(counter)),++counter);

        else if (dir.exists() && counter == 0) createDir(name+"-"+counter, 1);

        else {
            dir.mkdirs();
            System.out.println("Uscito dopo "+counter+" iterazioni");
            return dir;

        }

        return null;
    }



    public static void main(String[] args) {new Main().start(args);}

}


