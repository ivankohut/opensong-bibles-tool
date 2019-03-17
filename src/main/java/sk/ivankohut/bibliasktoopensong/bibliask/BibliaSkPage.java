package sk.ivankohut.bibliasktoopensong.bibliask;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BibliaSkPage {

    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();

    private final String hostName;
    private final String translation;
    private final String book;
    private final int chapter;

    public BibliaSkPage(String hostName, String translation, String book, int chapter) {
        this.hostName = hostName;
        this.translation = translation;
        this.book = book;
        this.chapter = chapter;
    }

    @Override
    public String toString() {
        var request = HttpRequest.newBuilder()
                .uri(URI.create("http://" + hostName + "/citanie/" + translation + "/" + book + "/" + chapter))
                .header("Accept", "text/html")
                .build();
        try {
            var response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
