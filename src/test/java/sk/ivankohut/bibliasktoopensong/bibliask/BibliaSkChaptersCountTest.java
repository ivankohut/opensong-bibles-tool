package sk.ivankohut.bibliasktoopensong.bibliask;

import org.junit.jupiter.api.Test;
import sk.ivankohut.bibliasktoopensong.bibliask.BibliaSkChaptersCount;

import static org.assertj.core.api.Assertions.assertThat;
import static sk.ivankohut.bibliasktoopensong.ResourcesUtils.resourceString;

class BibliaSkChaptersCountTest {

    @Test
    void aaa() {
        Object htmlPage = resourceString("acceptance/genesis1.html");
        var sut = new BibliaSkChaptersCount(htmlPage);
        // exercise
        Integer result = sut.get();
        // verify
        assertThat(result).isEqualTo(2);
    }
}