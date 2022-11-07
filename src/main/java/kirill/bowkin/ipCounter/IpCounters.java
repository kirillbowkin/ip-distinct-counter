package kirill.bowkin.ipCounter;

import kirill.bowkin.util.HllFillers;

/**
 * @author Кирилл
 */
public class IpCounters {
    public static IpCounter naive() {
        return new NaiveIpCounter();
    }

    public static IpCounter hll() {
        return new HllIpCounter(HllFillers.hllFiller());
    }
}
