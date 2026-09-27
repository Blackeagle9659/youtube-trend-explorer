package data.extraction;

import java.io.IOException;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup; // İçeri giriş
import org.jsoup.nodes.Document; // Veriyi işleme
import org.jsoup.nodes.Element; // Bireysel anlamda veriyi işleme
import data.model.VideoData;
import java.util.regex.Matcher; // Aranan bölge yazılır
import java.util.regex.Pattern; // Neyi aradığın yazılır

public class YoutubeExtractor {

	public VideoData data(String targetUrl) {

		System.out.println("Starting scan");

		System.out.println("Approaching the target video : " + targetUrl);

		try {
			UserAgentManager.randomSleep();
			Document doc = Jsoup.connect(targetUrl).userAgent(UserAgentManager.getRandomAgent()).referrer("https://www.google.com").timeout(3000).get();
					
				
			String textVideo = doc.title();
			String dates = null;
			String views = null;
			String likes = null;
			String secretLabel = null;

			Element date = doc.selectFirst("meta[itemprop=datePublished]");
			if (date != null) {
				dates = date.attr("content");

			} else {
				System.out.println("Not found");
			}

			Element like = doc.selectFirst("meta[itemprop=userInteractionCount]");
			if (like != null) {
				likes = like.attr("content");

			} else {
				System.out.println("Not found");
			}
			Element labelElement = doc.selectFirst("meta[name=keywords]");
			if (labelElement != null) {
				secretLabel = labelElement.attr("content");

			} else {
				System.out.println("Not found");
			}
			String pageCode = doc.html(); // Alanı String olarak tanımlıyoruz.

			Pattern signature = Pattern.compile("\"viewCount\":\"(\\d+)\""); // Aranan şeyi pattern ile yazıyoruz.
																				// (d+ sayı demek)
			Matcher seeker = signature.matcher(pageCode); // Aranan bölgeyi matcher içine yazıp matcher ile
															// resmileştiriyoruz.
			if (seeker.find()) {
				// group(1) diyerek parantez içine aldığımız o rakamları koparıyoruz.
				views = seeker.group(1);
			}
			VideoData target = new VideoData(textVideo, dates, views, likes, secretLabel); // Constructor zorunluluğu.

			System.out.println("Operation succesfull");

			System.out.println("WAF bypass is expected in 3 seconds.");
			return target; // Kullanmak isteyen için veriyi fırlatıyor.
		} catch (HttpStatusException e) {
			System.out.println("the target blocked us");
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.out.println("internet connection lost");
			e.printStackTrace();
			return null;
		}

	}

}
