// COURSE: CSCI1620
// TERM: Fall 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: No external resources were used in writing this file.
package scraper.base;

/**
 * This class stores information about each image found while crawling pages.
 * Image URLs are saved along with the URL for the page on which the image appears.
 * @author mberkland & abdoullatoundji
 *
 */
public class ImageEntry
{
	/**
	 * The selected image's URL.
	 */
	private String imgURL;
	/**
	 * The selected page's URL.
	 */
	private String pageURL;
	/**
	 * Creates a new ImageEntry storing an image URL alongside the source page URL.
	 * @param pageAddress - URL for the page where image was found.
	 * @param imgAddress - Full URL of image itself.
	 */
	public ImageEntry(String pageAddress, String imgAddress)
	{
		this.pageURL = pageAddress;
		this.imgURL = imgAddress;
	}
	
	/**
	 * Retrieves the source page URL.
	 * @return - Web page where image of this ImageEntry can be found.
	 */
	public String getPageLocation()
	{
		return this.pageURL;
	}
	
	/**
	 * Retrieves the direct image URL.
	 * @return - Full URL of image file itself.
	 */
	public String getImgLocation()
	{
		return this.imgURL;
	}
	
	/**
	 * Compares this ImageEntry to another object for
	 * equality based on the URL of the image file.
	 * Two ImageEntries with the same image URL but
	 * different page URLs will be considered equivalent.
	 * @return - true if this ImageEntry and other refer
	 * to the same image as file on the Web; false otherwise.
	 */
	@Override
	public boolean equals(java.lang.Object other)
	{
		if (!(other instanceof ImageEntry))
		{
			return false;
		}
		else
		{
			ImageEntry otherImg = (ImageEntry) other;
			if (otherImg.getImgLocation() != null)
			{
				return otherImg.getImgLocation().equals(this.getImgLocation());
			}
			else
			{
				return false;
			}
		}
	}
	/**
	 * Retrieves a String version of this ImageEntry.
	 * The returned string should only contain the URL for the image file.
	 * @return - The image file URL from this ImageEntry
	 */
	@Override
	public String toString()
	{
		return imgURL;
	}
}
