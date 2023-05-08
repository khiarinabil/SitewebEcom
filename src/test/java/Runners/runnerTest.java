package Runners;

import Tests.testbase;
import cucumber.api.CucumberOptions;

@CucumberOptions(features="C:\\Users\\Acer\\eclipse-workspace\\amin\\testautomationf\\src\\test\\java\\Features"
,glue= {"Steps"},plugin = {"pretty","html:target/report"})


public class runnerTest  extends testbase{

}
