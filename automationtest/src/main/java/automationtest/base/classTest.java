package automationtest.base;

import java.util.HashMap;

public class classTest {
	 
	static HashMap<Character, Integer> map = new HashMap<>();
	public static boolean check_input(String str)
	{
		boolean bool = true;
		int count =0;
		if(str.chars().allMatch(Character::isLetterOrDigit))
			//if(str.contains("[0-9]*"))
				for(char c:str.toCharArray())
				{
					if(Character.isDigit(c))
					if(map.containsKey(c))
						map.put(c, map.get(c)+ 1);
					else map.put(c, 1);
				}
		
		for(char c:map.keySet())
		{
			if(map.get(c)>1)
				count++;
		}	
			if(count>=1)
				bool=false;
			
			
			return bool;
		
	}
	public static void main(String args[])
	{
		String str = "abc123";
		System.out.println(check_input(str));
	}

}
