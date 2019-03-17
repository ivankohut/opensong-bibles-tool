package sk.ivankohut.bibliasktoopensong.bibliask;

import org.junit.jupiter.api.Test;
import sk.ivankohut.bibliasktoopensong.Verse;
import sk.ivankohut.bibliasktoopensong.bibliask.BibliaSkChapter;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static sk.ivankohut.bibliasktoopensong.ResourcesUtils.resourceString;

class BibliaSkChapterTest {

    @Test
    void verseNumbersIgnored() {
        var htmlPage = resourceString("unit/verses.html");
        var sut = new BibliaSkChapter(htmlPage);
        // exercise
        // verify
        Iterator<Verse> iterator = sut.iterator();
        assertThat(iterator.next()).satisfies(verse -> {
            assertThat(verse.number()).isEqualTo(13);
            assertThat(verse.text()).isEqualTo("Meno druhej rieky je Gichón. Tá obteká celú krajinu Kúš.");
        });
        assertThat(iterator.next()).satisfies(verse -> {
            assertThat(verse.number()).isEqualTo(14);
            assertThat(verse.text()).isEqualTo("Meno tretej rieky je Tigris. Tá tečie na východ od Asýrie. Štvrtou riekou je Eufrat.");
        });
    }
}