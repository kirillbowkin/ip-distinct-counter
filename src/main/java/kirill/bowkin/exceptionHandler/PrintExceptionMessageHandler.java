package kirill.bowkin.exceptionHandler;

import picocli.CommandLine;

/**
 * @author Кирилл
 */
public class PrintExceptionMessageHandler implements CommandLine.IExecutionExceptionHandler {
    @Override
    public int handleExecutionException(Exception e, CommandLine cmd, CommandLine.ParseResult parseResult) throws Exception {
        cmd.getErr().println(cmd.getColorScheme().errorText(e.getMessage()));

        return cmd.getExitCodeExceptionMapper() != null
                ? cmd.getExitCodeExceptionMapper().getExitCode(e)
                : cmd.getCommandSpec().exitCodeOnExecutionException();
    }
}
