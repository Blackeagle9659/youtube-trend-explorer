
	package data.extraction;

	import java.util.ArrayList;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	import org.jsoup.Jsoup;
	import org.jsoup.nodes.Document;

	public class YoutubeUrlCrawler {

	    public ArrayList<String> getLinks(String searchQuery, int maxLinks) {
	        ArrayList<String> urlList = new ArrayList<>();
	        String targetUrl = "https://www.youtube.com/results?search_query=" + searchQuery;

	        try {
	        
	            UserAgentManager.randomSleep();
	            
	            Document doc = Jsoup.connect(targetUrl)
	                    .userAgent(UserAgentManager.getRandomAgent())
	                    .referrer("https://www.google.com")
	                    .timeout(6000)
	                    .get();

	            String htmlRaw = doc.html();
	            Pattern pattern = Pattern.compile("\"/watch\\?v=([a-zA-Z0-9_-]{11})\"");
	            Matcher matcher = pattern.matcher(htmlRaw);

	            while (matcher.find() && urlList.size() < maxLinks) {
	                String videoLink = "https://www.youtube.com/watch?v=" + matcher.group(1);
	                if (!urlList.contains(videoLink)) {
	                    urlList.add(videoLink);
	                }
	            }
	        } catch (Exception e) {
	            System.err.println("Link collection error: " + e.getMessage());
	        }
	        
	        return urlList; // Temizce sadece link listesini döndürür
	    }
	}

