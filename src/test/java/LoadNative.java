import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoadNative
{
    @Test
    public void getNative()
    {
        PublicFunction pb=new PublicFunction();

        //请求native广告:先点击native按钮，进入native广告页面
        DriverInit.driver.findElement(By.id("com.unit.sample_all:id/Native")).click();
        //点击Load按钮请求广告
        DriverInit.driver.findElement(By.id("com.unit.sample_all:id/load1")).click();
        //点击show展示广告
        WebElement show=pb.findElement(DriverInit.driver,"com.unit.sample_all:id/show1");
        if(show.isEnabled())
        {
            show.click();
            WebElement img=pb.findElement(DriverInit.driver,"com.unit.sample_all:id/img_big");
            if(img.isEnabled())
            {
                pb.screenShot(DriverInit.driver,DriverInit.phoneName,"SuccessToLoadNative");
            }
            else
            {
                try {
                    Thread.sleep(60000);
                    //pb.screenShot(driver,phoneName,"SuccessToShow-Native");
                }catch (Exception e){}
            }

        }
        else
        {
            System.out.println("Native广告:Show按钮不可点击，也许请求失败，也可能没有offer返回，需结合抓包工具回归测试");
            // log.error("Native广告:Show按钮不可点击，也许请求失败，也可能没有offer返回，需结合抓包工具回归测试");
            pb.screenShot(DriverInit.driver,DriverInit.phoneName,"FailToLoadNative");
        }

        //展示完广告后，返回主页
        DriverInit.driver.navigate().back();
    }
}
