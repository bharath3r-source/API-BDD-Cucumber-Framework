package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Addplace;
import pojo.GetLocation;

public class TestDataBuild {

	
	
	public Addplace addPlacePayLoad(String Name, String Language, String Address)
	{
		
		Addplace p=new Addplace();
		p.setAccuracy(50);
		p.setAddress(Address);
		p.setLanguage(Language);
		p.setName(Name);
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://rahulshettyacademy.com");
		
		List<String> al=new ArrayList<String>();
		al.add("Shoe Park");
		al.add("Shop");
		
		p.setTypes(al);
		
		GetLocation l=new GetLocation();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		
		return p;
	}
	
	
}
