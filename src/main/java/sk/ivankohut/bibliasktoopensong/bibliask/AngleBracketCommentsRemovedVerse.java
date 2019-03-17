package sk.ivankohut.bibliasktoopensong.bibliask;

import sk.ivankohut.bibliasktoopensong.Verse;

import java.util.regex.Pattern;

/**
 * Required for Rohacek translation.
 */
public class AngleBracketCommentsRemovedVerse implements Verse {

    private static final Pattern COMMENT_PATTERN = Pattern.compile(" ?<.*?>");

    private final Verse verse;

    public AngleBracketCommentsRemovedVerse(Verse verse) {
        this.verse = verse;
    }

    @Override
    public Integer number() {
        return verse.number();
    }

    @Override
    public String text() {
        return COMMENT_PATTERN.matcher(verse.text()).replaceAll("");
    }
}
