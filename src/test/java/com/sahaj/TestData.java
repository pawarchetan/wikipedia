package com.sahaj;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static String wikipediaParagraph() {
        return "Zebras are several species of African equids (horse family) united by their distinctive black and white stripes. Their " +
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
    }

    public static List<String> getParagraphContent() {
        List<String> sentences = new ArrayList<>();
        sentences.add("Zebras are several species of African equids (horse family) united by their distinctive black and white stripes");
        sentences.add("Their stripes come in different patterns, unique to each individual");
        sentences.add("They are generally social animals that live in small harems to large herds");
        sentences.add("Unlike their closest relatives, horses and donkeys, zebras have never been truly domesticated");
        sentences.add("There are three species of zebras: the plains zebra, the Grévy's zebra and the mountain zebra");
        sentences.add("The plains zebra and the mountain zebra belong to the subgenus Hippotigris, but Grévy's zebra is the sole species of subgenus Dolichohippus");
        sentences.add("The latter resembles an ass, to which it is closely related, while the former two are more horse-like");
        sentences.add("All three belong to the genus Equus, along with other living equids");
        sentences.add("The unique stripes of zebras make them one of the animals most familiar to people");
        sentences.add("They occur in a variety of habitats, such as grasslands, savannas, woodlands, thorny scrublands, mountains, and coastal hills");
        sentences.add("However, various anthropogenic factors have had a severe impact on zebra populations, in particular hunting for skins and habitat destruction");
        sentences.add("Grévy's zebra and the mountain zebra are endangered");
        sentences.add("While plains zebras are much more plentiful, one subspecies - the Quagga - became extinct in the late 19th century");
        sentences.add("Though there is currently a plan, called the Quagga Project, that aims to breed zebras that are phenotypically " +
                "similar to the Quagga, in a process called breeding back");
        return sentences;
    }

    public static List<String> getTestQuestions() {
        List<String> questions = new ArrayList<>();
        questions.add("Which Zebras are endangered?");
        questions.add("What is the aim of the Quagga Project?");
        questions.add("Which animals are some of their closest relatives?");
        questions.add("Which are the three species of zebras?");
        questions.add("Which subgenus do the plains zebra and the mountain zebra belong to?");
        return questions;
    }

    public static List<String> getTestAnswers() {
        List<String> answers = new ArrayList<>();
        answers.add("subgenus Hippotigris");
        answers.add("the plains zebra, the Grévy's zebra and the mountain zebra");
        answers.add("horses and donkeys");
        answers.add("aims to breed zebras that are phenotypically similar to the quagga");
        answers.add("Grévy's zebra and the mountain zebra");
        return answers;
    }

}
