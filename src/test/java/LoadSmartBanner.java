import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;
public class LoadSmartBanner
{
    @Test
    public void getSmartBanner()
    {
        DriverInit.driver.navigate().back();

        PublicFunction pb=new PublicFunction();
        //请求SmartBanner 广告:先点击SmartBanner 按钮，进入SmartBanner 广告页面
        DriverInit.driver.findElement(By.id("com.unit.sample_all:id/smartBanner")).click();
        pb.screenShot(DriverInit.driver, DriverInit.phoneName, "进入SmartBanner主页");
        //点击Load按钮请求广告
        DriverInit.driver.findElement(By.id("com.unit.sample_all:id/load1")).click();
        pb.screenShot(DriverInit.driver, DriverInit.phoneName, "SmartBanner主页点击Load按钮");
        //点击getview按钮
        WebElement getViewSmartBanner=pb.findElement(DriverInit.driver,"com.unit.sample_all:id/getView1");
        if(getViewSmartBanner.isEnabled())
        {
            getViewSmartBanner.click();
            pb.screenShot(DriverInit.driver, DriverInit.phoneName, "SmartBanner主页点击getView按钮");
            WebElement showSmartBanner=pb.findElement(DriverInit.driver,"com.unit.sample_all:id/show1");
            if(showSmartBanner.isEnabled())
            {
                showSmartBanner.click();
                pb.screenShot(DriverInit.driver, DriverInit.phoneName, "SmartBanner主页点击show按钮");
                WebElement imgSmartBanner;
                imgSmartBanner = DriverInit.driver.findElementByClassName("android.widget.Image");
                if(imgSmartBanner.isEnabled())
                {
                    pb.screenShot(DriverInit.driver, DriverInit.phoneName, "SuccessToLoadSmartBanner");
                }
            }
            else
            {
                try {
                    Thread.sleep(60000);
                    //pb.screenShot(driver,phoneName,"SuccessToShow-Banner");
                }catch (Exception e){}
            }

        }
        else
        {
            System.out.println("SmartBanner广告:get view按钮不可点击，也许请求失败，也可能没有offer返回，需结合抓包工具回归测试");
            pb.screenShot(DriverInit.driver,DriverInit.phoneName,"FailToLoadSmartBanner");
        }
       // assertTrue(getViewSmartBanner.isEnabled());
        //展示完广告后，返回主页
        //DriverInit.driver.navigate().back();
    }
}
