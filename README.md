# ip-distinct-counter
Counts unique ip addresses in a given file.

First file is being read with java.nio `Files.lines()` method which returns `Stream<String>` as the result.
Then this stream is being proccessed according to one of two modes: naive or hll(HyperLogLog)

## Naive mode
Naive mode implementation is done with only using default java `Stream` methods, so it just applies `distinct()` and then `count()` to the stream of data

## Hll mode
Hll mode implementation is more sophisticated and it based on [HyperLogLog algorithm](https://en.wikipedia.org/wiki/HyperLogLog) using [java-hll](https://github.com/aggregateknowledge/java-hll) - a java implementation of HyperLogLog algorithm

## How to build

```bash
mvn package
```

## How to run
```
java -jar ./target/ip-distinct-counter-1.0-SNAPSHOT-jar-with-dependencies.jar [-hV] [-m=<mode>] <path>
```

Parameters:
*  `<path>` - path to a file

Options:
*  `-m`, `--mode` = `<mode>` - naive(default), hll
*  `-h`, `--help` - Show this help message and exit
*  `-v`, `--version` - Print version information and exit

## Examples
Naive counter
```
java -jar ./target/ip-distinct-counter-1.0-SNAPSHOT-jar-with-dependencies.jar ./ip.txt
```
```console
Using Naive counter
Number of unique ip addresses: 4
```

HyperLogLog counter
```
java -jar ./target/ip-distinct-counter-1.0-SNAPSHOT-jar-with-dependencies.jar ./ip.txt -m hll
```
```console
Using Hll counter
Number of unique ip addresses: 4
```

