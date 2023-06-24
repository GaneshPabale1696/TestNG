package DataProviderTestNG;

import org.testng.annotations.DataProvider;

public class DataProviderMethod {

	//1.India Qutub minar
	//2.Agra Taj Mahal
	//3.Hydrabad charmina
	
	@DataProvider(name="SearchDataSet")
	public Object[][] searchData()
	{
		Object[][] searchKeyword = new Object[3][2];
		searchKeyword[0][0] ="India";
		searchKeyword[0][1] ="Qutub minar";
		
		searchKeyword[1][0] ="Agra";
		searchKeyword[1][1] ="Taj Mahal";
		
		searchKeyword[2][0] ="Hydrabad";
		searchKeyword[2][1] ="CharMinar";
		
		return searchKeyword;
	}
	
	
}
