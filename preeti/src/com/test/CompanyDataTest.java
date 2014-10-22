/**
 * 
 */
package com.test;

import java.util.List;

/**
 * @author preeti
 *
 */
public class CompanyDataTest {

	/**
	 * @param args
	 */
	/*provide file name as command line argument*/
	public static void main(String[] args) {
		if(args.length<1)
		{
			System.out.println("Please provide csv file path and run again");
			System.exit(0);
		}
		String filePath=args[0];
		List<CompanyShare>companymaxShareList=CompanyShareData.readAndFindMaxShare(filePath, 2);
		if(companymaxShareList==null)
			System.out.println("No results to display");
		else
		{
			System.out.println("Max price for each company : ");
			for(CompanyShare cs:companymaxShareList)
			{
				System.out.println(cs);
			}
		}
		
	}

}
