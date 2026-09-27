package main;
import data.extraction.YoutubeExtractor;
import data.model.VideoData;
import data.extraction.YoutubeUrlCrawler;

import data.storage.VideoRepository;
import java.util.ArrayList;
public class Orchestrator {

	public static void main(String[] args) {
		YoutubeExtractor hunter = new YoutubeExtractor();
		VideoRepository warehouse = new VideoRepository();
		YoutubeUrlCrawler crawler = new YoutubeUrlCrawler();
		
		ArrayList<String> urlList = crawler.getLinks("şarkı", 100);
		System.out.println(urlList.size() + " targets located. Excavation operation is beginning...");
		for(String urlRotate : urlList) {
			
			  
					VideoData prototype = hunter.data(urlRotate);
					
			        if(prototype != null) {
			        	warehouse.videoRecord(prototype);
			        	System.out.println(prototype.toString());
			        	
			     
			       
			        }else {
			        	System.out.println("Target is not founded");
			        	
			        } try {
			       System.out.println("Wait 3 seconds for the WAF bypass");
			        	Thread.sleep(3000);
			        	
			        }catch( InterruptedException e) {
			        	System.out.println("Wait interrupted");
			        }
			        System.out.println("Mission complete");
			        System.out.println("Total url in repository : "+warehouse.numberOfVideo());
			
			
			
		}System.out.println("Operation finish");

	}

}
