package com.vg.adventofcode.year2020.enigmas;

import com.vg.adventofcode.year2020.utils.LogExecutionTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://adventofcode.com/2020/day/9
 */
@Component
@RequiredArgsConstructor
public class Enigma9 extends AbstractEnigma {
    @Override
    @LogExecutionTime
    public String computePart1(Stream<String> inputs) {
        return computePart1WithSpecificOffset(inputs, 25);
    }

    public String computePart1WithSpecificOffset(Stream<String> inputs, int offset) {
        List<Long> numbers = inputs.map(Long::parseLong).collect(Collectors.toList());
        return String.valueOf(computePart1WithSpecificOffsetAsLong(numbers, offset));
    }

    private Long computePart1WithSpecificOffsetAsLong(List<Long> numbers, int offset) {
        for (int i = offset; i < numbers.size(); i++) {
            if (!isEntryValid(numbers.subList(i - (offset), i), numbers.get(i)))
                return numbers.get(i);
        }
        return null;
    }

    private boolean isEntryValid(List<Long> subList, Long entry) {
        for (int i = 0; i < subList.size(); i++) {
            long number1 = subList.get(i);
            for (int j = i; j < subList.size(); j++) {
                if (number1 + subList.get(j) == entry)
                    return true;
            }
        }
        return false;
    }

    @Override
    @LogExecutionTime
    public String computePart2(Stream<String> inputs) {
        return computePart2WithSpecificOffset(inputs, 25);
    }

    public String computePart2WithSpecificOffset(Stream<String> inputs, int offset) {
        List<Long> numbers = inputs.map(Long::parseLong).collect(Collectors.toList());
        Long numberToFind = computePart1WithSpecificOffsetAsLong(numbers, offset);
        List<Long> contiguousNumberToSum =  findContiguousSetThatSumsTo(numbers, numberToFind);
        Collections.sort(contiguousNumberToSum);
        return String.valueOf( contiguousNumberToSum.get(0) + contiguousNumberToSum.get(contiguousNumberToSum.size()-1) );
    }

    List<Long> findContiguousSetThatSumsTo(List<Long> numbers, Long expectedSum) {
        int i = 0;
        while (i <= numbers.size()) {
            long sum = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) {
                sum += numbers.get(j);
                if (sum == expectedSum) {
                    return numbers.subList(i, j+1);
                } else if (sum > expectedSum) {
                    i++;
                    break;
                }
            }
        }
        return null;
    }
//
//    List<List<Long>> findPairsThatSumsTo(List<Long> numbers, Long expectedSum) {
//        System.out.println(numbers);
//        System.out.println(expectedSum);
//        List<List<Long>> allSums = recursiveSumWithSublist(0L ,expectedSum, numbers);
//        for (List<Long> s : allSums){
//            System.out.println(s);
//        }
//        return null;
//    }
//
//    private List<List<Long>> recursiveSumWithSublist(Long currentSumResult, Long expectedSum, List<Long> remainingEntries) {
//        if (remainingEntries.isEmpty()) {
//            // no more recursive call
//            return new ArrayList<>();
//        } else {
//            List<List<Long>> result = new ArrayList<>();
//            for (int i = 0; i < remainingEntries.size(); i++) {
//                Long left = remainingEntries.get(i);
//                if (left + currentSumResult == expectedSum){
//                    result.add(Collections.singletonList(left));
//                }
//                if (left + currentSumResult < expectedSum){
//                    List<List<Long>> iterationResult = recursiveSumWithSublist(currentSumResult + left,
//                            expectedSum,
//                            remainingEntries.stream().skip(i + 1).collect(Collectors.toList()));
//                    if (!iterationResult.isEmpty()){
//                        iterationResult.forEach(longs -> {
//                            List<Long> foundSum = new ArrayList<>();
//                            foundSum.add(left);
//                            foundSum.addAll(longs);
//                            result.add(foundSum);
//                        });
//                    }
//                }
//
//            }
//            return result;
//        }
//    }

    @Override
    public int getEnigmaDay() {
        return 9;
    }
}
