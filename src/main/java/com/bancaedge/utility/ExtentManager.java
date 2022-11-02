package com.bancaedge.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() {
		//htmlreporter=new ExtentHtmlReporter("/BancaEdge/test-output/ExtentReports/BancaEdgeReport.html");
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+"Extentrep.html");
		//htmlreporter=new ExtentHtmlReporter("/BancaEdge/test-output/BancaEdgeReport.html");
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");		
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Project Name", "BancaEdge");
		extent.setSystemInfo("Tester Name", "Subhash");
		/*htmlreporter.config().setChartVisibilityOnOpen(true);
		htmlreporter.config().setDocumentTitle("Extent Report Demo");
		htmlreporter.config().setReportName("Test Report");
		htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlreporter.config().setTheme(Theme.STANDARD);
		htmlreporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");*/
	}
	
	public static void endReport(){
		extent.flush();
	}

}
