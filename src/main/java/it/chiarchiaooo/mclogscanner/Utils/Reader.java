package it.chiarchiaooo.mclogscanner.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Reader {

    private enum OperationMode{
        SEPARATED, COMBINE
    }

    private enum scanners {
        ERROR,WARN,CONSOLE,PLAYER_DISCONNECT,PLAYER_JOIN,COMMAND,CHAT_MSG
    }


    private final Map<String, String> DEFAULT_FILTERS = Map.of(
            "[Server thread/ERROR]","errors.txt",
            "[Server thread/WARN]","warns.txt",
            "[Server thread/INFO]","consolelog.txt",
            "lost connection","disclog.txt",
            "logged in with entity id","joinlog.txt",
            "issued server command","cmds.txt",
            "[Async Chat Thread - #","chatlog.txt"

    );


    private final File input, rootDir;
    private final File[] inputDir;
    private final boolean includearchives;
    private final OperationMode operationMode;


    public Reader(File rootDir, File input, OperationMode operationMode) {
        this.rootDir = rootDir;
        this.inputDir = null;
        this.input = input;

        this.operationMode = operationMode;
        this.includearchives = false;
    }

    public Reader(File rootDir, File[] inputDir, OperationMode opMode, boolean includeArchives) {
        this.input = null;

        this.includearchives = includeArchives;
        this.operationMode = opMode;
        this.inputDir = inputDir;
        this.rootDir = rootDir;
    }

    public Reader(File rootDir, File input) {
        this.rootDir = rootDir;
        this.input = input;

        this.operationMode = OperationMode.SEPARATED;
        this.includearchives = false;
        this.inputDir = null;
    }

    private void checkLine(int[] counter, String line) throws IOException {
        for (String s : DEFAULT_FILTERS.keySet()) {

            if (line.startsWith(s)) {

                saveLine(line,DEFAULT_FILTERS.get(s));
            }
        }
    }


    private void updateFilterCounter(int[] counter, String filter) {



    }


    private void saveLine(String line, String scanner) throws IOException {
        File parent = new File(rootDir,scanner), logFile = new File(parent, DEFAULT_SCANNERS.get(scanner));

        FileWriter fw = new FileWriter(logFile);
        fw.write(line);
        fw.close();
    }
    public void readSingleFile() throws IOException {
        Scanner sc = new Scanner(input);

        while (sc.hasNextLine()) checkLine(sc.nextLine());

        sc.close();

    }

    public void readMultipleFiles() throws IOException {
        for (File f : inputDir) {

            //TODO: Aggiungere lettura archivi
            if (f.getName().contains(".log.gz") && !includearchives) continue;

            Scanner sc = new Scanner(f);

            while (sc.hasNextLine()) checkLine(sc.nextLine());

            sc.close();
        }
    }
}
