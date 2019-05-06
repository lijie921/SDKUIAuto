import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

public class LoadBanner
{
    @Test
    public void getBanner()
    {
        DriverInit.driver.navigate().back();

        PublicFunction pb=new PublicFunction();
        //请求Banner广告:先点击Banner按钮，进入Banner广告页面
        DriverInit.driver.findElement(By.id("com.unit.sample_all:id/banner")).click();
        pb.screenShot(DriverInit.driver, DriverInit.phoneName, "进入Banner主页");
        //点击Load按钮请求广告
        DriverInit.driver.findElement(By.id("com.unit.sample_all:id/load1")).click();
        pb.screenShot(DriverInit.driver, DriverInit.phoneName, "Banner主页点击Load按钮");
        //点击getview按钮
        WebElement getViewBanner=pb.findElement(DriverInit.driver,"com.unit.sample_all:id/getView1");
        
        Thread.sleep(60000);
        DriverInit.driver.navigate().back();
        /*不做校验
        if(getViewBanner.isEnabled())
        {
            getViewBanner.click();
            pb.screenShot(DriverInit.driver, DriverInit.phoneName, "Banner主页点击getView按钮");
            WebElement showBanner=pb.findElement(DriverInit.driver,"com.unit.sample_all:id/show1");
            if(showBanner.isEnabled())
            {
                showBanner.click();
                pb.screenShot(DriverInit.driver, DriverInit.phoneName, "Banner主页点击Show按钮");
                WebElement elementByClassNameBanner = DriverInit.driver.findElementByClassName("android.widget.Image");
                if(elementByClassNameBanner.isEnabled())
                {
                    pb.screenShot(DriverInit.driver, DriverInit.phoneName, "SuccessToLoadBanner");
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
            System.out.println("Banner广告：get view按钮不可点击，也许请求失败，也可能没有offer返回，需结合抓包工具回归测试");
            pb.screenShot(DriverInit.driver,DriverInit.phoneName,"FailToLoadBanner");
        }
        assertTrue(getViewBanner.isEnabled());
        //展示完广告后，返回主页
       // DriverInit.driver.navigate().back();*/
    }
}
