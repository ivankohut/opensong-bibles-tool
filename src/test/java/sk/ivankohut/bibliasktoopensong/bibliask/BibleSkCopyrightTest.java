package sk.ivankohut.bibliasktoopensong.bibliask;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;
import static sk.ivankohut.bibliasktoopensong.ResourcesUtils.resourceString;

class BibleSkCopyrightTest {

    @Test
    void aaaa() {
        var today = LocalDate.of(2019, 3, 17).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        var clock = Clock.fixed(today, ZoneId.systemDefault());
        var sut = new BibleSkCopyright(resourceString("unit/genesis1.html"), clock);
        // exercise
        // verify
        assertThat(sut.toString()).isEqualTo(
                "Slovenská biblická spoločnosť © <a href=\"http://biblickaspolocnost.sk/\" target=\"_blank\">www.biblickaspolocnost.sk</a> | Slovenský ekumenický preklad, 4. opravené vydanie, 2018.\n"
                        + "\n"
                        + "Downloaded from www.biblia.sk on 2019-03-17.");
    }
}
