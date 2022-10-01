package kirill.bowkin.command;

import kirill.bowkin.ipCounter.IpCounters;
import kirill.bowkin.ipCounter.IpCounter;
import picocli.CommandLine.Parameters;

import java.nio.file.Path;

import static picocli.CommandLine.*;
import static picocli.CommandLine.Command;

/**
 * @author Кирилл
 */

@Command(name = "ipCount", mixinStandardHelpOptions = true, description = "Prints number of unique ip addresses for a given file")
public class IpCountCommand implements Runnable {

    @Parameters(paramLabel = "<path>", description = "Path to the file")
    private Path path;

    @Option(names = {"-m", "--mode"}, description = {"naive, hll"})
    private String mode = "naive";

    @Override
    public void run() {
        IpCounter ipCounter = getIpCounter();
        System.out.printf("Using %s\n", ipCounter.toString());
        int ipCount = ipCounter.count(path);
        System.out.printf("Number of unique ip addresses: %d", ipCount);
    }

    private IpCounter getIpCounter() {
        IpCounter ipCounter = IpCounters.naive();

        if("naive".equals(mode)) {
            ipCounter = IpCounters.naive();
        }
        if("hll".equals(mode)) {
            ipCounter = IpCounters.hll();
        }
        return ipCounter;
    }
}
