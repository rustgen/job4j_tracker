package ru.job4j.stream;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(s -> s.getSubjects().stream())
                .mapToInt(s -> s.getScore())
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(s -> new Tuple(s.getName()
                        , s.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0)
                        ))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return  stream
                .flatMap(s -> s.getSubjects().stream())
                        .collect(Collectors.groupingBy(Subject::getName),
                                LinkedHashMap::new,
                                Collectors.averagingDouble(Subject::getScore)
                        )
                        );
    }
}
