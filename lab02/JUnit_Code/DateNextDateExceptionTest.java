import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class DateNextDateExceptionTest
{
	private int day;
	private int month;
	private int year;
	private Date date;
	private Exception e;

	public DateNextDateExceptionTest(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/*
	Set up params for test cases
	*/

	@Parameters
	public static List<Integer[]> data() 
	{	
		List<Integer[]> params = new LinkedList<Integer[]>();
		
		params.add(new Integer[] {1500, 2, 31});
		params.add(new Integer[] {1500,2,29});
		params.add(new Integer[] {-1,10,20});
		params.add(new Integer[] {1458,15,12});
		params.add(new Integer[] {1975,6,-50});

		return params;
	}

	/*
	Test cases
	*/

	//@Test
	@Test(expected = IllegalArgumentException.class)
	public void testDates()
	{
		Date d = new Date(day, month, year);
		Assert.assertEquals(d, d.nextDate());
	}


}