// COURSE: CSCI1620
// TERM: Fall 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: No external resources were used in writing this file.
package scraper.base;
import scraper.utils.ResultSet;

import scraper.utils.Document;
import scraper.utils.Element;
import scraper.utils.Elements;
import scraper.utils.PageHistory;

/**
 * This class provides a simple mechanism to crawl a series
 * of webpages recursively and extract all of the images
 * that are found on the pages visited.
 * @author mberkland and abdoullatoundji
 *
 */
public class WebScraper
{
	/**
	 * Depth of crawling page.
	 */
	private int depth;
	/**
	 * The url that will be passed in by the application.
	 */
	private String myURL;
//	/**
//	 * The current Document.
//	 */
//	private Document myDoc;
	/**
	 * The current ResultSet.
	 */
	private ResultSet fullSet;
	/**
	 * The current PageHistory.
	 */
	private PageHistory myHistory;
//	/**
//	 * The current Image that is selected.
//	 */
//	private ImageEntry myImg;
//	/**
//	 * The current Set of Elements.
//	 */
//	private Elements myElements;
//	/**
//	 * The current Element.
//	 */
//	private Element currentElement;
	
	/**
	 * Builds a new WebScraper that should start
	 * at the provided URL and will by default
	 * explore that page at a depth of 0.
	 * This allows extracting just the details
	 * from this page and nothing else.
	 * @param urlIn - The URL to explore for images.
	 */
	public WebScraper(String urlIn)
	{
		//myDoc = new Document();
		fullSet = new ResultSet();
		myHistory = new PageHistory();
		setURL(urlIn);
	}
	
	/**
	 * Builds a new WebScraper that should
	 * start at the provided URL and will
	 * explore recursively to a specified depth.
	 * @param urlIn - URL to begin exploring for images.
	 * @param depthIn - Recursive depth to explore,
	 * must be >= 0. Negatives will be 0.
	 */
	public WebScraper(String urlIn, int depthIn)
	{
		//myDoc = new Document();
		fullSet = new ResultSet();
		myHistory = new PageHistory();
		setDepth(depthIn);
		setURL(urlIn);
	}
	
	/**
	 * Updates this WebScraper to explore to a new depth.
	 * @param depthIn - The recursive depth to explore,
	 * must be >= 0. Negatives will be 0.
	 */
	public void setDepth(int depthIn)
	{
		depth = depthIn >= 0 ? depthIn : 0;
	}
	
	/**
	 * Retrieves the exploration depth of this WebScraper.
	 * @return - The depth stored in this WebScraper.
	 */
	public int getDepth()
	{
		return depth;
	}
	
	/**
	 * Updates the base URL to explore for this WebScraper.
	 * @param url - The new URL to explore. The WebScraper
	 * url is only changed if the url value is valid (not
	 * null or empty).
	 */
	public void setURL(String url)
	{
		Document myDoc = new Document();
		if (url != null && !url.equals("") && myDoc.loadPageFromURL(url))
		{
			myURL = url;
		}
		else if (url != null && !url.equals("") && !myDoc.loadPageFromURL(url))
		{
			myHistory.markVisited(url);
			
		}
	}
	
	/**
	 * Retrieves the base url for exploration by this WebScraper.
	 * @return - Base URL.
	 */
	public String getURL()
	{
		return myURL;
	}
	
	/**
	 * Retrieves the set of images found directly
	 * at the initial base URL for this WebScraper.
	 * This method will not explore any links
	 * found at the base page.
	 * Image information should be stored in the
	 * order in which their corresponding <img>
	 * tags appear in the source HTML code.
	 * If an image appears more than once in a page,
	 * only one entry should appear in the ResultSet.
	 * @return - A collection of ImageEntry objects
	 * for the images found at the base URL location.
	 */
	public ResultSet getImages()
	{
		Document myDoc = new Document();
//		if (!myHistory.visited(myURL))
//		{
//			myHistory.markVisited(myURL);
//		}
		if (!myHistory.visited(myURL) && myDoc.loadPageFromURL(myURL))
		{
			myHistory.markVisited(myURL);
			Elements myImgs = myDoc.getElementsByTag("img");
			while (myImgs.hasNextElement())
			{
				Element myElement = myImgs.getNextElement();
				if (!fullSet.contains(myElement.getAttributeValue("src")))
				{
					ImageEntry newImage = new ImageEntry(myURL,
							myElement.getAttributeValue("src"));
					fullSet.addResult(newImage);
				//	System.out.println("Image: " + newImage);
				}
			}
		}
		return fullSet;
	}
	
	/**
	 * This method will recursively explore pages
	 * starting at the base url defined for this
	 * WebScraper to the depth for which the
	 * scraper is configured.
	 * The ResultSet will contain all images
	 * discovered along the way, with images from
	 * a page being explored stored in the ResultSet
	 * prior to any images found on linked pages.
	 * ImageEntries will always appear in the
	 * ResultSet in the order in which the
	 * corresponding <img> tags are given in the
	 * HTML files. Only the first occurrence of a
	 * particular image (by absolute URL) is stored
	 * in the ResultSet.
	 * Links on a page will be explored in the
	 * sequential order in which their corresponding <a></a>
	 * tags appear in the HTML file. The same URL
	 * should never be crawled more than once, even if
	 * it is linked from itself or another later page.
	 * @return - The set of ImageEntry objects resulting
	 * from this recursive crawl.
	 */
	public ResultSet crawlPage()
	{
		fullSet.merge(getImages());
		Document myDoc = new Document();
		if (myDoc.loadPageFromURL(myURL) && depth > 0)
		{
			Elements a = myDoc.getElementsByTag("a");
			for (int i = 0; i < a.size(); i++)
			{
				Element myElement = a.getNextElement();
				String href = myElement.getAttributeValue("href");
				if (!myHistory.visited(href))
				{
					setURL(href);
					crawlPage();
				}
			}
			setDepth(depth - 1);
		}
//		else if (!myDoc.loadPageFromURL(myURL))
//		{
//			myHistory.markVisited(myURL);
//		}
		
		return fullSet;
	}
	
	/**
	 * Retrieves the historical trail of pages visited
	 * during the last top-level call to crawlPage.
	 * @return - The most recent collection of pages visited.
	 * If the crawlPage method has not been previously called,
	 * the PageHistory object will be empty.
	 */
	public PageHistory getPageHistory()
	{
		return myHistory;
	}
}
