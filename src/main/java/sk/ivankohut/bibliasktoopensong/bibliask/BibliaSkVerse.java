package sk.ivankohut.bibliasktoopensong.bibliask;

import io.vavr.collection.List;
import sk.ivankohut.bibliasktoopensong.Verse;

import java.util.regex.Pattern;

public class BibliaSkVerse implements Verse {

    private static final String NOTE_PATTERN = "<note.*?</note>";
    private static final String TITLE_PATTERN = "<h3>.*?</h3>";
    private static final String CHAR_START_PATTERN = "<char .*?>";
    private static final String CHAR_END_PATTERN = " ?</char>";
    private static final Pattern UNWANTED_TEXT_PATTERN = Pattern.compile(
            List.of(NOTE_PATTERN, TITLE_PATTERN, CHAR_START_PATTERN, CHAR_END_PATTERN)
                    .map(pattern -> "(" + pattern + ")")
                    .mkString("|")
    );

    private final String number;
    private final String text;

    public BibliaSkVerse(String number, String text) {
        this.number = number;
        this.text = text;
    }

    @Override
    public Integer number() {
        return Integer.parseInt(number);
    }

    @Override
    public String text() {
        return UNWANTED_TEXT_PATTERN.matcher(text).replaceAll("").trim();
    }
}
