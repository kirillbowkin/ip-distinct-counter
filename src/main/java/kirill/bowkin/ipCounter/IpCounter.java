package kirill.bowkin.ipCounter;

import java.util.stream.Stream;

/**
 * @author Кирилл
 */
public interface IpCounter {
    int countUnique(Stream<String> s);
}
