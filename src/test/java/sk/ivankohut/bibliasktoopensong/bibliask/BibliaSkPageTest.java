package sk.ivankohut.bibliasktoopensong.bibliask;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.vavr.collection.HashMap;
import org.junit.jupiter.api.Test;
import sk.ivankohut.bibliasktoopensong.ResourcesUtils;
import sk.ivankohut.bibliasktoopensong.bibliask.BibliaSkPage;

import static org.assertj.core.api.Assertions.assertThat;

class BibliaSkPageTest {

    @Test
    void aaa() {
        var port = 8089;
        var translation = "seb";
        var httpServer = stubLocalhostHttpServer(port, translation, "gn/1", "page");
        var sut = new BibliaSkPage("localhost:" + port, translation, "gn", 1);
        // exercise
        // verify
        assertThat(sut).hasToString("page");
        // teardown
        httpServer.stop();
    }

    private static WireMockServer stubLocalhostHttpServer(int port, String translation, String path, String page) {
        return ResourcesUtils.stubLocalhostHttpServer(port, translation, HashMap.of(path, page));
    }
}
