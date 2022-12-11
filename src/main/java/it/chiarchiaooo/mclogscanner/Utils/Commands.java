package it.chiarchiaooo.mclogscanner.Utils;

import java.util.HashMap;
import java.util.Map;

public class Commands {

    private enum comandi {
        INPUTFILE, INPUTDIR, OUTPUTDIR, CUSTOM_FILTERS
    }

    public Map<String, String[]> getCommandsAndArguments(String[] args) {
        Map<String, String[]> commandsAndArguments = new HashMap<>();
        String commands = "", arguments = "";
        boolean inizializzato = false;

        for (String s : args) {

            if (s.startsWith("--") && !inizializzato) {
                commands += s + ",";
                inizializzato = true;

            } else if (s.startsWith("--") && inizializzato) {
                commands += s + ",";
                arguments += ",";

            } else arguments += s + ":";

        }
        arguments = arguments.replace(":,", ",").replaceAll(".$", "");

        String[] cmds = commands.split(","), cargs = arguments.split(",");
        for (int i = 0; i < cmds.length; i++) commandsAndArguments.put(cmds[i], cargs[i].split(":"));

        return commandsAndArguments;
    }

    
}
