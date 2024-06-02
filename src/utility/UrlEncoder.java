package utility;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

//Class to encode the URL
public class UrlEncoder 
{
	//Static method which takes the string value and encodes it to URL
	public static String encodeValue(String value)
	{
		try
		{
			return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
		}
		catch(UnsupportedEncodingException e)
		{
			throw new RuntimeException("Error encoding URL: "+e.getMessage());
		}
	}
}
