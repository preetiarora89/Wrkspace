/**
 * 
 */
package com.test;

/**
 * @author preeti
 *
 */
class CompanyShare {
	   private String name;
	   private String year;
	   private String month;
	   private double sharePrice;

	   public CompanyShare(String name, String year, String month, double price) {
	      super();
	      this.name = name;
	      this.year = year;
	      this.month = month;
	      this.sharePrice = price;
	   }
	   public String getName() {
	      return name;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }
	   public String getYear() {
	      return year;
	   }
	   public void setYear(String year) {
	      this.year = year;
	   }
	   public String getMonth() {
	      return month;
	   }
	   public void setMonth(String month) {
	      this.month = month;
	   }
	   public double getSharePrice() {
	      return sharePrice;
	   }
	   public void setPrice(double price) {
	      this.sharePrice = price;
	   }

	   @Override
	   public String toString() {
	      return "Company [name=" + name + ", year=" + year + ", month=" + month + ", share price=" + sharePrice + "]";
	   }
	}
