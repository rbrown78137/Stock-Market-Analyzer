package com.ryanbrown;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class PullWebsiteDataTest {
	@Test
	public void testWebsiteData() {
		// soruce for all website data 
		//sample website https://financialmodelingprep.com/api/v3/historical-price-full/AAPL
		PullWebsiteData platform = new PullWebsiteData("GOOG");
		platform.getStockHistory();
		platform.getArticleData();
		try {
			platform.getStockJSON();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
