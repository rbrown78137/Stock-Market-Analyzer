package com.ryanbrown;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PullWebsiteData {
	private String company;
	public PullWebsiteData(String company){
		this.company = company;
	}

	public void getStockHistory() {
	try {
		//https://seekingalpha.com/symbol/AAPL
		//https://financialmodelingprep.com/api/v3/historical-price-full/AAPL
		Document doc = Jsoup.connect("https://seekingalpha.com/symbol/AAPL").get();
		Elements elements = doc.getAllElements();
		Elements testNews = doc.getElementsByClass("symbol_article");
		ArrayList<String> links = new ArrayList<String>();
		ArrayList<String> articleTitles = new ArrayList<String>();
		ArrayList<String> articleDates = new ArrayList<String>();
		java.util.Iterator<Element> newsIterator = testNews.iterator();
		for(;newsIterator.hasNext();) {
			Element newsSection = newsIterator.next();
			if(newsSection.childNodeSize() ==2) {
			List<Node> children = newsSection.childNodes();
			org.jsoup.nodes.Attributes articleAttributes = children.get(0).attributes();
			java.util.Iterator<Attribute> attributeIterator = articleAttributes.iterator();

			Attribute linkAttribute = attributeIterator.next();
			String link = linkAttribute.getValue();
			links.add(link);
			//what is provided /news/3519874-berkshire-trims-well-fargo-buys-occidental-petroleum
			//full link example https://seekingalpha.com/news/3519874-berkshire-trims-well-fargo-buys-occidental-petroleum
			Node articleTitleNode = children.get(0).childNodes().get(0);
			String articleTitle = articleTitleNode.toString();
			articleTitles.add(articleTitle);
			Node dateNode = children.get(1).childNodes().get(2).childNode(0);
			String articleDate = dateNode.toString();
			articleDates.add(articleDate);
			}
			if(newsSection.childNodeSize() ==1) {
				String time = newsSection.attr("time");
				articleDates.add(time);
				Node articleTitleNode = newsSection.childNode(0).childNode(0);
				String articleTitle = articleTitleNode.toString();
				articleTitles.add(articleTitle);
				Node articleLinkNode = newsSection.childNode(0);
				String link = articleLinkNode.attr("href");
				links.add(link);
				int test2 = 1;
			}
			int test = 1;
			}
		int i = 0;
		
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void getArticleData() {
		try {
			//https://seekingalpha.com/symbol/AAPL
			//https://financialmodelingprep.com/api/v3/historical-price-full/AAPL
			Document doc = Jsoup.connect("https://seekingalpha.com/article/4313226-apple-chance-for-blowout-earnings-trading-above-fair-value").get();
			Elements elements = doc.getAllElements();
			Element testNews = doc.getElementById("a-cont");
			String runningInformation = "";
			runningInformation = getSubElementInformation(testNews.childNode(0).parent());
			int test = 1;
			
			
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	public String getSubElementInformation(Node node) {
		String returnString = "";
		for(Node child: node.childNodes()) {
			if(child instanceof TextNode) {
				returnString += child.toString();
			}
			returnString+=getSubElementInformation(child);
		}
			
		return returnString;
	}
	public void getStockJSON() throws IOException {
		String link = "https://financialmodelingprep.com/api/v3/historical-price-full/AAPL";
		 URL url = new URL(link);
		    URLConnection request = url.openConnection();
		    request.connect();

		    // Convert to a JSON object to print data
		    JsonParser jp = new JsonParser(); //from gson
		    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
		    JsonObject rootobj = root.getAsJsonObject();
		    int test = 1;
	}
}
