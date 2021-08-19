// COURSE: CSCI1620
// TERM: FALL 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: No outside resources were used in the making of this class.

package scraper.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import scraper.base.*;

import scraper.utils.*;

public class WebScraperTest
{
final String URL_PAGE_0 = "http://kreestman.unomaha.community/hw3testpage/page0.html";
	
	final String URL_PAGE_1 = "http://kreestman.unomaha.community/hw3testpage/page1.html";
	final String URL_IMAGE_DOG = "http://kreestman.unomaha.community/hw3testpage/imgs/brodieBolt.jpg";
	final String URL_IMAGE_LOGO = "http://kreestman.unomaha.community/hw3testpage/imgs/logo_uno.png";
	
	final String URL_PAGE_2 = "http://kreestman.unomaha.community/hw3testpage/page2.html";
	final String URL_TREE_IMG = "http://kreestman.unomaha.community/hw3testpage/imgs/Palm_Tree_Emoji_42x42.png";
	final String URL_PIZZA_IMG = "http://kreestman.unomaha.community/hw3testpage/imgs/Slice_Of_Pizza_Emoji_42x42.png";

	final String URL_FACE_IMG = "http://kreestman.unomaha.community/hw3testpage/imgs/Tears_of_Joy_Emoji_Icon_42x42.png";
	final String URL_HAT_IMG = "http://kreestman.unomaha.community/hw3testpage/imgs/Top_Magic_Hat_Emoji_42x42.png";
	final String URL_TURTLE_IMG = "http://kreestman.unomaha.community/hw3testpage/imgs/Turtle_Emoji_42x42.png";
	final String URL_MOON_IMG = "http://kreestman.unomaha.community/hw3testpage/imgs/Waning_crescent_moon_emoji_icon_png_42x42.png";
	
	
	final String URL_PAGE_3 = "http://kreestman.unomaha.community/hw3testpage/page3.html";
	final String URL_DOG_1 = "http://kreestman.unomaha.community/hw3testpage/imgs/puppy1.jpg";
	final String URL_DOG_2 = "http://kreestman.unomaha.community/hw3testpage/imgs/puppy2.jpg";
	final String URL_DOG_3 = "http://kreestman.unomaha.community/hw3testpage/imgs/puppy3.jpg";
	final String URL_DOG_4 = "http://kreestman.unomaha.community/hw3testpage/imgs/puppy4.jpg";
	final String URL_DOG_5 = "http://kreestman.unomaha.community/hw3testpage/imgs/puppy5.jpg";
	final String URL_DOG_6 = "http://kreestman.unomaha.community/hw3testpage/imgs/puppy6.jpg";
	
	final String URL_PAGE_SECRET = "http://kreestman.unomaha.community/hw3testpage/secretpage.html";
	final String URL_HOMECOMING = "http://kreestman.unomaha.community/hw3testpage/imgs/Homecoming-Outtake1.jpg";
	
	final String URL_BROKEN = "http://kreestman.unomaha.community/hw3testpage/brokenlinkhereyay.html";
	
	
	@Test
	public void testConstructorBasicValid()
	{
		WebScraper test = new WebScraper(URL_PAGE_3);
		
		assertEquals(URL_PAGE_3, test.getURL());
		assertEquals(0, test.getDepth());
	}
	
	@Test
	public void testConstructorDepthValid()
	{
		WebScraper test = new WebScraper(URL_PAGE_3, 3);
		
		assertEquals(URL_PAGE_3, test.getURL());
		assertEquals(3, test.getDepth());
	}
	
	@Test
	public void testSetURLValid()
	{
		WebScraper test = new WebScraper(URL_PAGE_3, 3);
		
		test.setURL(URL_PAGE_2);
		
		assertEquals(URL_PAGE_2, test.getURL());
		assertEquals(3, test.getDepth());
	}
	
	@Test
	public void testSetURLInValidNull()
	{
		WebScraper test = new WebScraper(URL_PAGE_3, 3);
		
		test.setURL(null);
		
		assertEquals(URL_PAGE_3, test.getURL());
		assertEquals(3, test.getDepth());
	}
	
	@Test
	public void testSetURLInValidEmpty()
	{
		WebScraper test = new WebScraper(URL_PAGE_3, 3);
		
		test.setURL("");
		
		assertEquals(URL_PAGE_3, test.getURL());
		assertEquals(3, test.getDepth());
	}
	
	@Test
	public void testSetURLInValidLink()
	{
		WebScraper test = new WebScraper(URL_PAGE_3, 3);
		
		test.setURL(URL_BROKEN);
		
		//assertEquals(PAGE_3, test.getURL());
		assertEquals(3, test.getDepth());
	}
	
	@Test
	public void testSetDepthValid()
	{
		WebScraper test = new WebScraper(URL_PAGE_3, 0);
		
		test.setDepth(3);
		
		assertEquals(URL_PAGE_3, test.getURL());
		assertEquals(3, test.getDepth());
	}
	
	@Test
	public void testSetDepthInValidNegative()
	{
		WebScraper test = new WebScraper(URL_PAGE_3, 3);
		
		test.setDepth(-5);
		
		assertEquals(URL_PAGE_3, test.getURL());
		assertEquals(0, test.getDepth());
	}	

	@Test
	public void testGetImagesNonDuplicatedImages()
	{
		WebScraper test = new WebScraper(URL_PAGE_3);
		
		ResultSet result = test.getImages();
		ResultSet answer = new ResultSet();
		
		ImageEntry one = new ImageEntry(URL_PAGE_3, URL_DOG_1);
		ImageEntry two = new ImageEntry(URL_PAGE_3, URL_DOG_2);
		ImageEntry three = new ImageEntry(URL_PAGE_3, URL_DOG_3);
		ImageEntry four = new ImageEntry(URL_PAGE_3, URL_DOG_4);
		ImageEntry five = new ImageEntry(URL_PAGE_3, URL_DOG_5);
		ImageEntry six = new ImageEntry(URL_PAGE_3, URL_DOG_6);
		
		answer.addResult(one);
		answer.addResult(five);
		answer.addResult(two);
		answer.addResult(three);
		answer.addResult(four);
		answer.addResult(six);
		
		ImageEntry[] results = result.getAllResults();
		ImageEntry[] answers = answer.getAllResults();
		
		for (int i = 0; i < 6; i++)
		{
			assertEquals(results[i], answers[i]);
		}
		assertEquals(6, result.getNumEntries());
		
		PageHistory ans = new PageHistory();
		ans.markVisited(URL_PAGE_3);
		String[] history = test.getPageHistory().getHistory();
		String[] correct = ans.getHistory();
		
		for (int a = 0; a < 1; a++)
		{
			assertEquals(history[a], correct[a]);
		}
	}
	
	@Test
	public void testGetImagesDuplicatedImages()
	{
		WebScraper test = new WebScraper(URL_PAGE_2);
		
		ResultSet result = test.getImages();
		ResultSet answer = new ResultSet();
		
		ImageEntry one = new ImageEntry(URL_PAGE_2, URL_TREE_IMG);
		ImageEntry two = new ImageEntry(URL_PAGE_2, URL_PIZZA_IMG);
		ImageEntry three = new ImageEntry(URL_PAGE_2, URL_FACE_IMG);
		ImageEntry four = new ImageEntry(URL_PAGE_2, URL_HAT_IMG);
		ImageEntry five = new ImageEntry(URL_PAGE_2, URL_TURTLE_IMG);
		ImageEntry six = new ImageEntry(URL_PAGE_2, URL_MOON_IMG);
		ImageEntry seven = new ImageEntry(URL_PAGE_2, URL_IMAGE_LOGO);
		
		answer.addResult(one);
		answer.addResult(two);
		answer.addResult(three);
		answer.addResult(four);
		answer.addResult(five);
		answer.addResult(six);
		answer.addResult(seven);
		
		ImageEntry[] results = result.getAllResults();
		ImageEntry[] answers = answer.getAllResults();
		
		for (int i = 0; i < results.length; i++)
		{
			//System.out.println(results[i]);
			assertEquals(results[i], answers[i]);
		}
		assertEquals(7, result.getNumEntries());
		
		PageHistory ans = new PageHistory();
		ans.markVisited(URL_PAGE_2);
		String[] history = test.getPageHistory().getHistory();
		String[] correct = ans.getHistory();
		
		for (int a = 0; a < 1; a++)
		{
			assertEquals(history[a], correct[a]);
		}
	}
	
	@Test
	public void testGetImagesNone()
	{
		WebScraper test = new WebScraper(URL_PAGE_0);
		
		ResultSet result = test.getImages();
		
		assertEquals(0, result.getNumEntries());
	}
	
	@Test
	public void testCrawlPageValid()
	{
		WebScraper test = new WebScraper(URL_PAGE_1, 10);
		ResultSet result = test.crawlPage();
		ResultSet answer = new ResultSet();
		
		
		ImageEntry one = new ImageEntry(URL_PAGE_1, URL_IMAGE_DOG);
		ImageEntry two = new ImageEntry(URL_PAGE_1, URL_IMAGE_LOGO);
		ImageEntry three = new ImageEntry(URL_PAGE_2, URL_TREE_IMG);
		ImageEntry four = new ImageEntry(URL_PAGE_2, URL_PIZZA_IMG);
		ImageEntry five = new ImageEntry(URL_PAGE_2, URL_FACE_IMG);
		ImageEntry six = new ImageEntry(URL_PAGE_2, URL_HAT_IMG);
		ImageEntry seven = new ImageEntry(URL_PAGE_2, URL_TURTLE_IMG);
		ImageEntry eight = new ImageEntry(URL_PAGE_2, URL_MOON_IMG);
		ImageEntry nine = new ImageEntry(URL_PAGE_3, URL_DOG_1);
		ImageEntry ten = new ImageEntry(URL_PAGE_3, URL_DOG_5);
		ImageEntry eleven = new ImageEntry(URL_PAGE_3, URL_DOG_2);
		ImageEntry twelve = new ImageEntry(URL_PAGE_3, URL_DOG_3);
		ImageEntry thirteen = new ImageEntry(URL_PAGE_3, URL_DOG_4);
		ImageEntry fourteen = new ImageEntry(URL_PAGE_3, URL_DOG_6);
		ImageEntry fifteen = new ImageEntry(URL_PAGE_SECRET, URL_HOMECOMING);
		
		answer.addResult(one);
		answer.addResult(two);
		answer.addResult(three);
		answer.addResult(four);
		answer.addResult(five);
		answer.addResult(six);
		answer.addResult(seven);
		answer.addResult(eight);
		answer.addResult(nine);
		answer.addResult(ten);
		answer.addResult(eleven);
		answer.addResult(twelve);
		answer.addResult(thirteen);
		answer.addResult(fourteen);
		answer.addResult(fifteen);
		
		ImageEntry[] results = result.getAllResults();
		ImageEntry[] answers = answer.getAllResults();
		
		for (int i = 0; i < results.length; i++)
		{
			assertEquals(results[i], answers[i]);
		}
		assertEquals(15, result.getNumEntries());
		
		PageHistory ans = new PageHistory();
		ans.markVisited(URL_PAGE_1);
		ans.markVisited(URL_PAGE_2);
		ans.markVisited(URL_PAGE_3);
		ans.markVisited(URL_PAGE_SECRET);
		ans.markVisited(URL_PAGE_0);
		ans.markVisited(URL_BROKEN);
		String[] history = test.getPageHistory().getHistory();
		String[] correct = ans.getHistory();
		
		for (int a = 0; a < 6; a++)
		{
			assertEquals(history[a], correct[a]);
		}
		assertEquals(6, history.length);
	}
	
	@Test
	public void testCrawlPageValidDepthOne()
	{
		WebScraper test = new WebScraper(URL_PAGE_1, 1);
		ResultSet result = test.crawlPage();
		ResultSet answer = new ResultSet();
		
		
		ImageEntry one = new ImageEntry(URL_PAGE_1, URL_IMAGE_DOG);
		ImageEntry two = new ImageEntry(URL_PAGE_1, URL_IMAGE_LOGO);
		ImageEntry three = new ImageEntry(URL_PAGE_2, URL_TREE_IMG);
		ImageEntry four = new ImageEntry(URL_PAGE_2, URL_PIZZA_IMG);
		ImageEntry five = new ImageEntry(URL_PAGE_2, URL_FACE_IMG);
		ImageEntry six = new ImageEntry(URL_PAGE_2, URL_HAT_IMG);
		ImageEntry seven = new ImageEntry(URL_PAGE_2, URL_TURTLE_IMG);
		ImageEntry eight = new ImageEntry(URL_PAGE_2, URL_MOON_IMG);
		ImageEntry nine = new ImageEntry(URL_PAGE_3, URL_DOG_1);
		ImageEntry ten = new ImageEntry(URL_PAGE_3, URL_DOG_5);
		ImageEntry eleven = new ImageEntry(URL_PAGE_3, URL_DOG_2);
		ImageEntry twelve = new ImageEntry(URL_PAGE_3, URL_DOG_3);
		ImageEntry thirteen = new ImageEntry(URL_PAGE_3, URL_DOG_4);
		ImageEntry fourteen = new ImageEntry(URL_PAGE_3, URL_DOG_6);
		ImageEntry fifteen = new ImageEntry(URL_PAGE_SECRET, URL_HOMECOMING);
		
		answer.addResult(one);
		answer.addResult(two);
		answer.addResult(three);
		answer.addResult(four);
		answer.addResult(five);
		answer.addResult(six);
		answer.addResult(seven);
		answer.addResult(eight);
		answer.addResult(nine);
		answer.addResult(ten);
		answer.addResult(eleven);
		answer.addResult(twelve);
		answer.addResult(thirteen);
		answer.addResult(fourteen);
		answer.addResult(fifteen);
		
		
		ImageEntry[] results = result.getAllResults();
		ImageEntry[] answers = answer.getAllResults();
		
		for (int i = 0; i < 15; i++)
		{
			//System.out.println("ANSWER: \n" + answers[i] + "\n vs \n" + results[i] + "\n");
			assertEquals(answers[i], results[i]);
		}
		assertEquals(15, result.getNumEntries());
		
		PageHistory ans = new PageHistory();
		ans.markVisited(URL_PAGE_1);
		ans.markVisited(URL_PAGE_2);
		ans.markVisited(URL_PAGE_3);
		ans.markVisited(URL_PAGE_SECRET);
		ans.markVisited(URL_PAGE_0);
		ans.markVisited(URL_BROKEN);
		String[] history = test.getPageHistory().getHistory();
		String[] correct = ans.getHistory();
		
		for (int a = 0; a < 6; a++)
		{
			//System.out.println(history[a]);
			assertEquals(history[a], correct[a]);
		}
		assertEquals(6, history.length);
	}
	
	@Test
	public void testCrawlPageValidDepthZero()
	{
		WebScraper test = new WebScraper(URL_PAGE_1, 0);
		ResultSet result = test.crawlPage();
		ResultSet answer = new ResultSet();
		
		
		ImageEntry one = new ImageEntry(URL_PAGE_1, URL_IMAGE_DOG);
		ImageEntry two = new ImageEntry(URL_PAGE_1, URL_IMAGE_LOGO);
		
		answer.addResult(one);
		answer.addResult(two);
		
		ImageEntry[] results = result.getAllResults();
		ImageEntry[] answers = answer.getAllResults();
		
		for (int i = 0; i < 2; i++)
		{
			assertEquals(results[i], answers[i]);
		}
		assertEquals(2, result.getNumEntries());
		
		PageHistory ans = new PageHistory();
		ans.markVisited(URL_PAGE_1);
		String[] history = test.getPageHistory().getHistory();
		String[] correct = ans.getHistory();
		
		for (int a = 0; a < 1; a++)
		{
			assertEquals(history[a], correct[a]);
		}
		assertEquals(1, history.length);
	}
	
	@Test
	public void testCrawlPageValidDepthOneDuplicate()
	{
		WebScraper test = new WebScraper(URL_PAGE_2, 1);
		ResultSet result = test.crawlPage();
		ResultSet answer = new ResultSet();
		
		ImageEntry one = new ImageEntry(URL_PAGE_2, URL_TREE_IMG);
		ImageEntry two = new ImageEntry(URL_PAGE_2, URL_PIZZA_IMG);
		ImageEntry three = new ImageEntry(URL_PAGE_2, URL_FACE_IMG);
		ImageEntry four = new ImageEntry(URL_PAGE_2, URL_HAT_IMG);
		ImageEntry five = new ImageEntry(URL_PAGE_2, URL_TURTLE_IMG);
		ImageEntry six = new ImageEntry(URL_PAGE_2, URL_MOON_IMG);
		ImageEntry seven = new ImageEntry(URL_PAGE_1, URL_IMAGE_LOGO);
		ImageEntry eight = new ImageEntry(URL_PAGE_1, URL_IMAGE_DOG);
		ImageEntry nine = new ImageEntry(URL_PAGE_3, URL_DOG_1);
		ImageEntry ten = new ImageEntry(URL_PAGE_3, URL_DOG_5);
		ImageEntry eleven = new ImageEntry(URL_PAGE_3, URL_DOG_2);
		ImageEntry twelve = new ImageEntry(URL_PAGE_3, URL_DOG_3);
		ImageEntry thirteen = new ImageEntry(URL_PAGE_3, URL_DOG_4);
		ImageEntry fourteen = new ImageEntry(URL_PAGE_3, URL_DOG_6);
		ImageEntry fifteen = new ImageEntry(URL_PAGE_SECRET, URL_HOMECOMING);
		
		answer.addResult(one);
		answer.addResult(two);
		answer.addResult(three);
		answer.addResult(four);
		answer.addResult(five);
		answer.addResult(six);
		answer.addResult(seven);
		answer.addResult(eight);
		answer.addResult(nine);
		answer.addResult(ten);
		answer.addResult(eleven);
		answer.addResult(twelve);
		answer.addResult(thirteen);
		answer.addResult(fourteen);
		answer.addResult(fifteen);
		
		ImageEntry[] results = result.getAllResults();
		ImageEntry[] answers = answer.getAllResults();
		
		for (int i = 0; i < 15; i++)
		{
			assertEquals(results[i], answers[i]);
		}
		assertEquals(15, result.getNumEntries());
		
		PageHistory ans = new PageHistory();
		ans.markVisited(URL_PAGE_2);
		ans.markVisited(URL_PAGE_1);
		ans.markVisited(URL_PAGE_3);
		ans.markVisited(URL_PAGE_0);
		ans.markVisited(URL_BROKEN);
		ans.markVisited(URL_PAGE_SECRET);
		String[] history = test.getPageHistory().getHistory();
		String[] correct = ans.getHistory();
		
		for (int a = 0; a < 6; a++)
		{
			assertEquals(history[a], correct[a]);
		}
		assertEquals(6, history.length);
	}
}


























































































