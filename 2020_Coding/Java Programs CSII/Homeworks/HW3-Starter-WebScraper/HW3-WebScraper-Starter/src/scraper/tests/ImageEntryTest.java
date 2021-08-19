// COURSE: CSCI1620
// TERM: FALL 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: No resources other than our own 4 hands and 20 fingers.

package scraper.tests;
  	
 import static org.junit.Assert.*; 	
 import org.junit.Test;  	
 import scraper.base.*;


/**
 * Conducts a series of tests on ImageEntry.
 * @author mberkland and abdoullatoundji
 *
 */
public class ImageEntryTest
{
	final String URL_PAGE_0 = "http://kreestman.unomaha.community/hw3testpage/page0.html";
	
	final String URL_PAGE_1 = "http://kreestman.unomaha.community/hw3testpage/page1.html";
	final String URL_IMAGE_DOG = "http://kreestman.unomaha.community/hw3testpage/imgs/brodieBolt.jpg";
	final String URL_IMAGE_LOGO = "http://kreestman.unomaha.community/hw3testpage/imgs/logo_uno.png";
	
	final String URL_PAGE_2 = "http://kreestman.unomaha.community/hw3testpage/page2.html";
	final String URL_TREE_IMG = "http://kreestman.unomaha.community/hw3testpage/imgs/Palm_Tree_Emoji_42x42.png";
	final String URL_PIZZA_IMG = "http://kreestman.unomaha.community/hw3testpage/imgs/Slice_Of_Pizza_Emoji_42x42.png";
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
	
	
	public void testConstructorValid()
	{
		ImageEntry test = new ImageEntry(URL_PAGE_2, URL_TREE_IMG);
		
		assertEquals(test.getPageLocation(), URL_PAGE_2);
		assertEquals(test.getImgLocation(), URL_TREE_IMG);
	}
	
	@Test
	public void testEqualsValidEqual()
	{
		ImageEntry test = new ImageEntry(URL_PAGE_2, URL_PIZZA_IMG);
		ImageEntry compare = new ImageEntry(URL_PAGE_2, URL_PIZZA_IMG);
		
		boolean result = test.equals(compare);
		
		assertEquals(true, result);
	}
	
	@Test
	public void testEqualsValidDifferent()
	{
		ImageEntry test = new ImageEntry(URL_PAGE_1, URL_IMAGE_DOG);
		ImageEntry compare = new ImageEntry(URL_PAGE_1, URL_IMAGE_LOGO);
		
		boolean result = test.equals(compare);
		
		assertEquals(false, result);
	}

	@Test
	public void testEqualsInValidNull()
	{
		ImageEntry test = new ImageEntry(URL_PAGE_2, URL_HAT_IMG);
		ImageEntry compare = new ImageEntry(URL_PAGE_2, null);
		
		boolean result = test.equals(compare);
		
		assertEquals(false, result);
	}
	
	@Test
	public void testEqualsInValidDifferentObject()
	{
		ImageEntry test = new ImageEntry(URL_PAGE_1, URL_IMAGE_LOGO);
		WebScraper compare = new WebScraper(URL_PAGE_1);
		
		boolean result = test.equals(compare);
		
		assertEquals(false, result);
	}
	
	@Test
	public void testToStringValid()
	{
		ImageEntry test = new ImageEntry(URL_PAGE_2, URL_TURTLE_IMG);
		
		String result = test.toString();
		
		assertEquals(URL_TURTLE_IMG, result);
	}
}




















