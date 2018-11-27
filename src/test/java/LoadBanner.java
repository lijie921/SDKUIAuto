import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoadBanner
{
    @Test
    public void getBanner()
    {
        PublicFunction pb=new PublicFunction();
        //请求Banner广告:先点击Banner按钮，进入Banner广告页面
        DriverInit.driver.findElement(By.id("com.unit.sample_all:id/banner")).click();
        //点击Load按钮请求广告
        DriverInit.driver.findElement(By.id("com.unit.sample_all:id/load1")).click();
        //点击getview按钮
        WebElement getViewBanner=pb.findElement(DriverInit.driver,"com.unit.sample_all:id/getView1");
        if(getViewBanner.isEnabled())
        {
            getViewBanner.click();
            WebElement showBanner=pb.findElement(DriverInit.driver,"com.unit.sample_all:id/show1");
            if(showBanner.isEnabled())
            {
                showBanner.click();
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
        //展示完广告后，返回主页
        DriverInit.driver.navigate().back();
    }
}
