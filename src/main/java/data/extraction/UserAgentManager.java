package data.extraction;

import java.util.Random;

public class UserAgentManager {
	private static String[] USERAGENTS /* CONSTANT */ = {
			"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36",
			"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.4 Safari/605.1.15",
			"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36",
			"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/113.0" };
	private static final Random random = new Random();
	public static String getRandomAgent() {
		
		return USERAGENTS[random.nextInt(USERAGENTS.length)];
	}
	public static void randomSleep() {
		try { int sleepTime = 2000 + random.nextInt(3000);
		System.out.println("Bot is sleeping... (" + sleepTime + " ms)");
        Thread.sleep(sleepTime);
		}catch(InterruptedException e){
			Thread.currentThread().interrupt();
		}
	}
}
