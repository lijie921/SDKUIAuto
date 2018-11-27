import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LaodMedium
{
    @Test
    public void getMedium()
    {
        PublicFunction pb=new PublicFunction();
        //点击medium按钮进入medium广告页面
        DriverInit.driver.findElement(By.id("com.unit.sample_all:id/medium")).click();
        //点击Load按钮，加载广告
        DriverInit.driver.findElement(By.id("com.unit.sample_all:id/load1")).click();
        //点击getview按钮
        WebElement getviewMedium=pb.findElement(DriverInit.driver,"com.unit.sample_all:id/getView1");
        if(getviewMedium.isEnabled())
        {
            getviewMedium.click();
            WebElement showMedium=pb.findElement(DriverInit.driver,"com.unit.sample_all:id/show1");
            if(showMedium.isEnabled())
            {
                showMedium.click();
                WebElement img=DriverInit.driver.findElementByClassName("android.widget.Image");
                if(img.isEnabled())
                {
                    pb.screenShot(DriverInit.driver, DriverInit.phoneName, "SuccessToLoadMedium");
                }
                else
                {
                    try {
                        Thread.sleep(60000);
                        //pb.screenShot(driver,phoneName,"SuccessToShow-Native");
                    } catch (Exception e) {
                    }
                }
            }
        }
        else
        {
            System.out.println("Medium广告:Show按钮不可点击，也许请求失败，也可能没有offer返回，需结合抓包工具回归测试");
            pb.screenShot(DriverInit.driver,DriverInit.phoneName,"FailToLoadMedium");
        }

        //返回主页
        DriverInit.driver.navigate().back();
    }
}
