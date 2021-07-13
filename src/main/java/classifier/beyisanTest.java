package classifier;


import classifier.bayes.BayesClassifier;

import java.util.Arrays;


public class beyisanTest {
    public static void main(String[] args) {

        final Classifier<String, String> bayes =
                new BayesClassifier<>();

        final String[] positiveText = "나는 맑은 날을 좋아한다".split("\\s");
        bayes.learn("Positive", Arrays.asList(positiveText));

        final String[] negativeText = "나는 비가 싫다".split("\\s");
        bayes.learn("Negative", Arrays.asList(negativeText));

        final String[] unknownText1 = "오늘은 맑은 날이다".split("\\s");
        final String[] unknownText2 = "오늘 비가 온다".split("\\s");

        System.out.println(
                bayes.classify(Arrays.asList(unknownText1)).getCategory());
        System.out.println(
                bayes.classify(Arrays.asList(unknownText2)).getCategory());

        System.out.println(
                bayes.classify(Arrays.asList(unknownText1)));
        System.out.println(
                bayes.classify(Arrays.asList(unknownText2)));

        ((BayesClassifier<String, String>) bayes).classifyDetailed(
                Arrays.asList(unknownText1));

        bayes.setMemoryCapacity(500);
    }

}
