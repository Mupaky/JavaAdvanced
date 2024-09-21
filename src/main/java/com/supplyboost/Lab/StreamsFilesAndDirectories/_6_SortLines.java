package com.supplyboost.Lab.StreamsFilesAndDirectories;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _6_SortLines {

    private static final String URLS_CSV = "urls.csv";
    private static final String CONTENT_CSV = "content.csv";

    private Set<String> visitedUrls = new HashSet<>();
    private Queue<UrlDepthPair> urlQueue = new LinkedList<>();
    private HttpClient httpClient = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.NORMAL)
            .build();

    public static void main(String[] args) {
        _6_SortLines crawler = new _6_SortLines();

        // Starting URL (Replace with your target URL)
        String startUrl = "https://github.com/Mupaky"; // Starting from Mupaky's GitHub page

        int maxDepth = 2; // Limit the crawling depth

        crawler.startCrawling(startUrl, maxDepth);
    }

    public void startCrawling(String startUrl, int maxDepth) {
        urlQueue.add(new UrlDepthPair(startUrl, 0));

        while (!urlQueue.isEmpty()) {
            UrlDepthPair current = urlQueue.poll();
            String url = normalizeUrl(current.getUrl());
            int depth = current.getDepth();

            if (!visitedUrls.contains(url) && depth <= maxDepth) {
                try {
                    visitedUrls.add(url);
                    processPage(url, depth);

                    // Sleep between requests (rate-limiting)
                    Thread.sleep(2000); // 2 seconds
                } catch (IOException | InterruptedException e) {
                    System.err.println("Error processing URL: " + url);
                    e.printStackTrace();
                }
            }
        }
    }

    private void processPage(String url, int depth) throws IOException, InterruptedException {
        System.out.println("Processing URL: " + url);

        // Fetch the page content
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", "MyCrawler/1.0 (my-email@example.com)")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        String htmlContent = response.body();

        // Parse the HTML content with Jsoup
        Document doc = Jsoup.parse(htmlContent, url);

        // Extract and process all relevant content
        String textContent = extractAllTextContent(doc);

        if (!textContent.isEmpty()) {
            // Save the URL and content to CSV
            saveContent(url, textContent);
        }

        // Extract links and add to the queue
        extractLinks(doc, url, depth);
    }

    /**
     * Extract all the visible text content from the page, excluding scripts, styles, and other non-human-readable parts.
     */
    private String extractAllTextContent(Document doc) {
        // Remove all script, style, and other non-visible elements
        doc.select("script, style, nav, footer, header, noscript, iframe").remove();

        // Extract all the visible text from the body of the HTML document
        return doc.body().text();
    }

    private void saveContent(String url, String content) {
        // Save to content.csv
        try (PrintWriter out = new PrintWriter(new FileWriter(CONTENT_CSV, true))) {
            // Escape double quotes in content
            content = content.replace("\"", "\"\"");
            out.printf("\"%s\",\"%s\"%n", url, content);
        } catch (IOException e) {
            System.err.println("Error saving content for URL: " + url);
            e.printStackTrace();
        }

        // Save URL to urls.csv
        try (PrintWriter out = new PrintWriter(new FileWriter(URLS_CSV, true))) {
            out.println(url);
        } catch (IOException e) {
            System.err.println("Error saving URL: " + url);
            e.printStackTrace();
        }
    }

    private void extractLinks(Document doc, String baseUrl, int currentDepth) {
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            String absUrl = link.attr("abs:href");
            absUrl = normalizeUrl(absUrl);

            if (isValidUrl(absUrl)) {
                if (!visitedUrls.contains(absUrl)) {
                    urlQueue.add(new UrlDepthPair(absUrl, currentDepth + 1));
                }
            }
        }
    }

    private boolean isValidUrl(String url) {
        return url != null && !url.isEmpty()
                && (url.startsWith("http://") || url.startsWith("https://"))
                && !url.startsWith("mailto:");
    }

    private String normalizeUrl(String url) {
        if (url.endsWith("/")) {
            url = url.substring(0, url.length() - 1);
        }
        return url;
    }

    private static class UrlDepthPair {
        private String url;
        private int depth;

        public UrlDepthPair(String url, int depth) {
            this.url = url;
            this.depth = depth;
        }

        public String getUrl() {
            return url;
        }

        public int getDepth() {
            return depth;
        }
    }
}