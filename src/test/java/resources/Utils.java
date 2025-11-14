package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;
	
	public RequestSpecification requestSpecification() throws IOException
	{
		
		String Logfilename="logging_"+System.currentTimeMillis()+".txt";
		PrintStream log=new PrintStream(new FileOutputStream(Logfilename));
		
		req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
				.addQueryParam("key", "qaclick123").addHeader("Content-Type","application/json")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return req;
	
	}
	
	
	public static String getGlobalValue(String key) throws IOException
	
	{
		Properties prop=new Properties();
		
		FileInputStream fis= new FileInputStream("D:\\API Testing\\API BDD Framework\\API BDD Cucumber Framework Code\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		
		return prop.getProperty(key);
	}
	
}
	
	





























