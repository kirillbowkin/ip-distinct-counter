package kirill.bowkin.ipCounter;

import java.util.stream.Stream;

/**
 * @author Кирилл
 */
public class NaiveIpCounter implements IpCounter {
    @Override
    public int count(Stream<String> s) {
        return (int) s.distinct().count();
    }

    @Override
    public String toString() {
        return "Naive counter";
    }
}
