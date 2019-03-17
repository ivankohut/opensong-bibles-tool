package sk.ivankohut.bibliasktoopensong.bibliask;

import sk.ivankohut.bibliasktoopensong.Chapter;
import sk.ivankohut.bibliasktoopensong.Verse;

import java.util.Iterator;
import java.util.regex.Pattern;

public class BibliaSkChapter implements Chapter {

    private static final Pattern VERSE_PATTERN = Pattern.compile("<a href='.*?'>(\\d+)</a>\\s*<span class='text-verse'>(.*?)</span>");

    private final Object htmlPage;

    public BibliaSkChapter(Object htmlPage) {
        this.htmlPage = htmlPage;
    }

    @Override
    public Iterator<Verse> iterator() {
        return VERSE_PATTERN
                .matcher(htmlPage.toString())
                .results()
                .<Verse>map(result -> new AngleBracketCommentsRemovedVerse(new BibliaSkVerse(result.group(1), result.group(2))))
                .iterator();
    }
}
