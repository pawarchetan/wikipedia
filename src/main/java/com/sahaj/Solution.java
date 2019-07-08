package com.sahaj;

import com.sahaj.wikipedia.Answer;
import com.sahaj.wikipedia.Wikipedia;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {

    private static final String wikipediaContent = "Zebras are several species of African equids (horse family) united by their distinctive black and white stripes. Their " +
            "stripes come in different patterns, unique to each individual. They are generally social animals that live in small " +
            "harems to large herds. Unlike their closest relatives, horses and donkeys, zebras have never been truly domesticated. " +
            "There are three species of zebras: the plains zebra, the Grévy's zebra and the mountain zebra. The plains zebra and the" +
            " mountain zebra belong to the subgenus Hippotigris, but Grévy's zebra is the sole species of subgenus Dolichohippus. The" +
            " latter resembles an ass, to which it is closely related, while the former two are more horse-like. All three belong to " +
            "the genus Equus, along with other living equids. The unique stripes of zebras make them one of the animals most familiar" +
            " to people. They occur in a variety of habitats, such as grasslands, savannas, woodlands, thorny scrublands, mountains, " +
            "and coastal hills. However, various anthropogenic factors have had a severe impact on zebra populations, in particular " +
            "hunting for skins and habitat destruction. Grévy's zebra and the mountain zebra are endangered. While plains zebras are " +
            "much more plentiful, one subspecies - the Quagga - became extinct in the late 19th century. Though there is currently a " +
            "plan, called the Quagga Project, that aims to breed zebras that are phenotypically similar to the Quagga, in a process " +
            "called breeding back.\n" +
            "Which Zebras are endangered?\n" +
            "What is the aim of the Quagga Project?\n" +
            "Which animals are some of their closest relatives?\n" +
            "Which are the three species of zebras?\n" +
            "Which subgenus do the plains zebra and the mountain zebra belong to?\n" +
            "subgenus Hippotigris; the plains zebra, the Grévy's zebra and the mountain zebra;horses and donkeys;aims to breed zebras" +
            " that are phenotypically similar to the quagga; Grévy's zebra and the mountain zebra";

    public static void main(String[] args) {
        List<String> inputSentences = Arrays.asList(wikipediaContent.split("\n"));
        List<String> answers = parseAnswers(inputSentences);
        Wikipedia wikipedia = Wikipedia.of(inputSentences, answers);

        List<String> questions =  parseQuestions(inputSentences);

        for(String question: questions) {
            Optional<Answer> optionalAnswer = wikipedia.ask(question);
            optionalAnswer.ifPresent(answer -> System.out.println(answer.getContent()));
        }
    }

    private static List<String> parseQuestions(List<String> inputSentences) {
        return inputSentences.stream()
                .skip(1)
                .limit(inputSentences.size() - 2)
                .collect(Collectors.toList());
    }

    private static List<String> parseAnswers(List<String> inputSentences) {
        return inputSentences.stream()
                .filter(Objects::nonNull)
                .skip(inputSentences.size() - 1)
                .flatMap(Pattern.compile(";")::splitAsStream)
                .collect(Collectors.toList());
    }

}
