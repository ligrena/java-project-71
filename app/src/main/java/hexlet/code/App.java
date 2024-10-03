package hexlet.code;

import picocli.CommandLine;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true)
public final class App implements Callable<Integer> {

    @Parameters(index = "0", description = "Path to first file")
    private String filepath1;

    @Parameters(index = "1", description = "Path to second file")
    private String filepath2;

    @Option(names = {"-f", "--format"}, description = "output format")
    private String format = "stylish";

    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate(filepath1, filepath2, format));
        return 0;
    }

    public static void main(String[] args) {
        int exit = new CommandLine(new App()).execute(args);
        System.exit(exit);
    }
}
