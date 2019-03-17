package sk.ivankohut.bibliasktoopensong.bibliask;

import java.util.Comparator;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class BibliaSkChaptersCount implements Supplier<Integer> {

    private static final Pattern CHAPTER_NUMBER_PATTERN = Pattern.compile("<li class='chapter-number( active-chapter)?'>(\\d+)</li>");

    private final Object htmlPage;

    public BibliaSkChaptersCount(Object htmlPage) {
        this.htmlPage = htmlPage;
    }

    @Override
    public Integer get() {
        String input = htmlPage.toString();
        return CHAPTER_NUMBER_PATTERN
                .matcher(input)
                .results()
                .map(result -> Integer.parseInt(result.group(2)))
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("No chapters detected in page:\n" + input));
    }
}
