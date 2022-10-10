package kirill.bowkin;


import kirill.bowkin.command.IpCountCommand;
import kirill.bowkin.exceptionHandler.PrintExceptionMessageHandler;
import picocli.CommandLine;

public class App {

    static {
        System.setProperty(
                "java.util.logging.SimpleFormatter.format",
                "%5$s %n");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new IpCountCommand())
                .setExecutionExceptionHandler(new PrintExceptionMessageHandler())
                .execute(args);
        System.exit(exitCode);
    }
}
