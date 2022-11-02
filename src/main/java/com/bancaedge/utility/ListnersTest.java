package com.bancaedge.utility;

import org.apache.poi.hssf.record.common.ExtendedColor;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.bancaedge.base.BaseClass;
import com.bancaedge.commonmethods.CommonMethods;

public class ListnersTest extends ExtentManager implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
		test.createNode(result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass Test Case Is :" + result.getName());
		}

	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				test.log(Status.FAIL,
						MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				test.log(Status.FAIL,
						MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
				String imgpath = CommonMethods.screenShot(BaseClass.getDriver(), result.getName());
				test.fail("ScreenShot Is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgpath).build());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test Case Is :" + result.getName());
		}
	}

}
