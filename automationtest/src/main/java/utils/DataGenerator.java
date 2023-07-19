package utils;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataGenerator 
{
	@DataProvider (name = "data-provider")
	public Object[][] dpMethod(Method m)
	{
		switch (m.getName())
		{
		case "searchForVideo": 

			return new Object[][] {{"Bungee"},{"UNIVERSAL"},{"cream"},{"Kart"},{"snails"}};
			//return new Object[][] {{"Bungee"}};

		default :
			return null;
		}

	}
}
