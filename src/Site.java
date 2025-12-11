public class Site{
	private char siteCode;
	private String siteName;
	private int xValue;
	private int yValue;

	public Site(char siteCode, String siteName, int xValue, int yValue){
		this.siteCode = siteCode;
		this.siteName = siteName;
		this.xValue = xValue;
		this.yValue = yValue;
	}

	public char getSiteCode(){return siteCode;}
	public String getSiteName(){return siteName;}
	public int getXValue(){return xValue;}
	public int getYValue(){return yValue;}

	@Override
	public String toString(){
		return "\nSite Code: " + siteCode
		+ "\nSite Name: "	+ siteName
		+ "\nValue of x: " + xValue
		+ "\nValue of y: " + yValue;
	}
}
