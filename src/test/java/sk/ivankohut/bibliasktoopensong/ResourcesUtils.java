package sk.ivankohut.bibliasktoopensong;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.google.common.io.Resources;
import io.vavr.collection.Map;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class ResourcesUtils {

    public static String resourceString(String classPath) {
        try {
            return Resources.toString(Resources.getResource(classPath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void stubChapter(WireMockServer wireMockServer, String path, String body) {
        wireMockServer.stubFor(get(urlEqualTo(path))
                .withHeader("Accept", equalTo("text/html"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/html; charset=UTF-8")
                        .withBody(body)));
    }

    public static WireMockServer stubLocalhostHttpServer(int port, String translation, Map<String,String> pathToBody) {
        var wireMockServer = new WireMockServer(wireMockConfig().port(port));
        wireMockServer.start();
        pathToBody.forEach((path, body) -> stubChapter(wireMockServer, "/citanie/" + translation + "/" + path, body));
        return wireMockServer;
    }
}
