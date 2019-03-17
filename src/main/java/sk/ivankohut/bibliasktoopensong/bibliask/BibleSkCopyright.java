package sk.ivankohut.bibliasktoopensong.bibliask;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BibleSkCopyright {

    private static final Pattern COPYRIGHT_PATTERN = Pattern.compile("<p id=\"copyright_info\" class=\"copyright-info\">(.*?)</p>");

    private final Object htmlPage;
    private final Clock clock;

    public BibleSkCopyright(Object htmlPage, Clock clock) {
        this.htmlPage = htmlPage;
        this.clock = clock;
    }

    @Override
    public String toString() {
        Matcher matcher = COPYRIGHT_PATTERN.matcher(htmlPage.toString());
        if (matcher.find()) {
            MatchResult matchResult = matcher.toMatchResult();
            return matchResult.group(1) + "\n"
                    + "\n"
                    + "Downloaded from www.biblia.sk on " + DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.ofInstant(clock.instant(), ZoneId.systemDefault())) + ".";
        }
        throw new IllegalArgumentException("No copyright information present.");
    }
}
