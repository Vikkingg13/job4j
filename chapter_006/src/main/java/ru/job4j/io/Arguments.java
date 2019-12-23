package ru.job4j.io;

import org.apache.commons.cli.*;

public class Arguments {
    private String[] args;
    private CommandLine commandLine;

    public Arguments(String[] args) {
        this.args = args;
    }

    public void init() {
        Options options = new Options();
        OptionGroup flags = new OptionGroup();
        options.addRequiredOption("d", "directory", true, "Directory");
        options.addRequiredOption("n", "name", true, "Name, mask or regular");
        options.addRequiredOption("o", "output", true, "Output");
        options.getOption("d").setArgs(1);
        options.getOption("n").setArgs(1);
        options.getOption("o").setArgs(1);
        flags.addOption(new Option("m", false, "Mask"));
        flags.addOption(new Option("f", false, "Full name"));
        flags.addOption(new Option("r", false, "Regular expression"));
        flags.setRequired(true);
        options.addOptionGroup(flags);
        CommandLineParser parser = new DefaultParser();
        try {
            commandLine = parser.parse(options, args);
        } catch (ParseException ex) {
            HelpFormatter help = new HelpFormatter();
            help.printHelp("Search Advanced", options);
        }
    }

    public String directory() {
        return commandLine.getOptionValue("d");
    }

    public String output() {
        return commandLine.getOptionValue("o");
    }

    public String name() {
        return commandLine.getOptionValue("n");
    }

    public char flag() {
        char result = 'f';
        char[] flags = {'f', 'r', 'm'};
        for (char flag : flags) {
            if (commandLine.hasOption(flag)) {
                result = flag;
                break;
            }
        }
        return result;
    }
}

