package it.chiarchiaooo.mclogscanner.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.ZipFile;

public class Reader {

    private final Map<String, String> DEFAULT_SCANNERS = Map.of(
            "errors:[Server thread/ERROR]","errors.txt",
            "warns:[Server thread/WARN]","warns.txt",
            "console-msgs:[Server thread/INFO]","consolelog.txt",
            "disconnects:lost connection","disclog.txt",
            "joins:logged in with entity id","joinlog.txt",
            "commands:issued server command","cmds.txt",
            "chat-msgs:[Async Chat Thread - #","chatlog.txt"

    );

    private final File input, rootDir;
    private final File[] inputDir;
    private final boolean includearchives;


    public Reader(File rootDir, File input) {
        this.includearchives = false;
        this.inputDir = null;

        this.rootDir = rootDir;
        this.input = input;
    }

    public Reader(File rootDir, File[] inputDir, boolean includeArchives) {
        this.input = null;

        this.includearchives = includeArchives;
        this.inputDir = inputDir;
        this.rootDir = rootDir;
    }

    private void checkLine(String line) throws IOException {

        for (String s : DEFAULT_SCANNERS.keySet()) {
            String[] scanner = s.split(":");

            if (line.startsWith(scanner[1])) saveLine(line,scanner[0]);
        }
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
