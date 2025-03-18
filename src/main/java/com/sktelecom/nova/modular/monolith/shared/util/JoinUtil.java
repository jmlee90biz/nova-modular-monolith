package com.sktelecom.nova.modular.monolith.shared.util;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JoinUtil {
    public static <K, L, R, O> List<O> joinLists(
            List<L> leftList, Function<L, K> leftKeyExtractor,
            List<R> rightList, Function<R, K> rightKeyExtractor,
            BiFunction<L, R, O> joiner) {

        Map<K, L> leftMap = leftList.stream()
                .collect(Collectors.toMap(leftKeyExtractor, Function.identity()));

        return rightList.stream()
                .map(right -> joiner.apply(leftMap.get(rightKeyExtractor.apply(right)), right))
                .toList();
    }
}