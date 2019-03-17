package acceptance;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.vavr.collection.HashMap;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import org.junit.jupiter.api.Test;
import sk.ivankohut.bibliasktoopensong.BibliaSkToOpenSong;
import sk.ivankohut.bibliasktoopensong.ResourcesUtils;
import sk.ivankohut.bibliasktoopensong.bibliask.SimpleBookCoordinate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static sk.ivankohut.bibliasktoopensong.ResourcesUtils.resourceString;

class AcceptanceTest {

    @Test
    void bibliaSkToOpenSong() throws IOException {
        var translation = "seb";
        var port = 8089;
        var httpServer = stubLocalhostHttpServer(port, translation, HashMap.of(
                "gn/1", "genesis1",
                "gn/2", "genesis2",
                "ex/1", "exodus1",
                "mt/1", "matus1",
                "mk/1", "marek1",
                "mk/2", "marek2"
        ));
        // exercise
        new BibliaSkToOpenSong(
                "localhost:" + port,
                translation,
                List.of(new SimpleBookCoordinate("gn", "Genezis"), new SimpleBookCoordinate("ex", "Exodus")),
                List.of(new SimpleBookCoordinate("mt", "Matúš"), new SimpleBookCoordinate("mk", "Marek"))
        ).writeTo("output.xml");
        // verify
        var result = Files.readString(Paths.get("output.xml"), StandardCharsets.UTF_8)
                .replaceAll("(Downloaded from www\\.biblia\\.sk on )\\d{4}-\\d{2}-\\d{2}(\\.)", "$12019-03-17$2");

        assertThat(result).isEqualTo(resourceString("acceptance/result.xml"));
        // teardown
        httpServer.stop();
    }

    private static WireMockServer stubLocalhostHttpServer(int port, String translation, Map<String, String> chapters) {
        return ResourcesUtils.stubLocalhostHttpServer(
                port,
                translation,
                chapters
                        .mapValues(fileName -> resourceString("acceptance/" + fileName + ".html"))
        );
    }
}
