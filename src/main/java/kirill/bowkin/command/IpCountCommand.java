package kirill.bowkin.command;

import kirill.bowkin.exception.FileReadException;
import kirill.bowkin.ipCounter.IpCounter;
import kirill.bowkin.ipCounter.IpCounters;
import kirill.bowkin.util.FileReader;
import picocli.CommandLine.Parameters;

import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

import static picocli.CommandLine.Command;
import static picocli.CommandLine.Option;

/**
 * @author Кирилл
 */

@Command(name = "ipCount", mixinStandardHelpOptions = true, description = "Prints number of unique ip addresses for a given file")
public class IpCountCommand implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(IpCountCommand.class.getName());
    public static final String NAIVE = "naive";
    public static final String HLL = "hll";

    @Parameters(paramLabel = "<path>", description = "Path to the file")
    private Path path;

    @Option(names = {"-m", "--mode"}, description = {"naive, hll"})
    private String mode = "naive";

    @Override
    public void run() {
        try (var ipStream = FileReader.read(path)){
            IpCounter ipCounter = getIpCounter();
            LOGGER.log(Level.INFO, "Using {0}", ipCounter.toString());
            int ipCount = ipCounter.countUnique(ipStream);
            LOGGER.log(Level.INFO, "Number of unique ip addresses: {0}", ipCount);
        } catch (FileReadException e) {
            LOGGER.log(Level.SEVERE, e.toString());
        }
    }

    private IpCounter getIpCounter() {
        if (HLL.equals(mode)) {
            return IpCounters.hll();
        }
        return IpCounters.naive();
    }
}
