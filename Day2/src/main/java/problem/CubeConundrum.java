package problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.Utils.readFile;

public class CubeConundrum {
    record ColorCube(int gameNumber, Stream<Map<String, Integer>> colorMaps) {
    }

    Function<String, ColorCube> toCubesMap = str -> {
        var gameNumber = Integer.parseInt(str.split(":")[0].split(" ")[1]);
        var colorMaps = Arrays.stream(str.split(":")[1].split(";")).map(t -> {
            final Map<String, Integer> colorMap = new HashMap<>();
            Arrays.stream(t.trim().split(",")).forEach(c -> {
                var cc = c.trim().split(" ");
                colorMap.put(cc[1], Integer.valueOf(cc[0].trim()));

            });
            return colorMap;
        });
        return new ColorCube(gameNumber, colorMaps);
    };

    public Integer problem1(String filePath) {
        var limits =
                new HashMap<String, Integer>() {
                    {
                        put("red", 12);
                        put("green", 13);
                        put("blue", 14);

                    }
                };
        List<String> lines = readFile(filePath);
        return lines.stream().map(toCubesMap).filter(e -> e.colorMaps.flatMap(m -> m.entrySet().stream())
                        .noneMatch(b -> b.getValue() > limits.get(b.getKey())))
                .mapToInt(ColorCube::gameNumber).sum();
    }

    public Integer problem2(String filePath) {
        List<String> lines = readFile(filePath);
        return lines.stream().map(toCubesMap).mapToInt(e -> e.colorMaps.flatMap(m -> m.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey)).values().stream().mapToInt(entries -> entries.stream().mapToInt(Map.Entry::getValue)
                        .max().orElse(0)).reduce(1, (a, b) -> a * b)).sum();
    }


}
