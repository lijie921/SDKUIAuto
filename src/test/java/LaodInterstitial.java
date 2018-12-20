import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

public class LaodInterstitial
{
    @Test
    public void getInterstitial()
    {
        DriverInit.driver.navigate().back();

        PublicFunction pb=new PublicFunction();
        //点击interstitial按钮，进入插屏广告页面
        DriverInit.driver.findElement(By.id("com.unit.sample_all:id/interstitial")).click();
        pb.screenShot(DriverInit.driver,DriverInit.phoneName,"进入插屏主页");
        //点击Load按钮，加载广告
        DriverInit.driver.findElement(By.id("com.unit.sample_all:id/load1")).click();
        pb.screenShot(DriverInit.driver,DriverInit.phoneName,"插屏页面点击load按钮");
        //展示广告
        try
        {
            Thread.sleep(20000);
            WebElement msgInt=pb.findElement(DriverInit.driver,"com.unit.sample_all:id/message1");
            WebElement showInt=pb.findElement(DriverInit.driver,"com.unit.sample_all:id/show1");
            assertTrue(showInt.isEnabled());
            if(showInt.isEnabled())
            {
                showInt.click();
                Thread.sleep(20000);
                pb.screenShot(DriverInit.driver,DriverInit.phoneName,"SuccessToLoadVideo");
                DriverInit.driver.navigate().back();
            }
            else
            {
                System.out.println("插屏广告加载失败<"+msgInt.getText()+">");
                pb.screenShot(DriverInit.driver,DriverInit.phoneName,"FailToLoadInterstitial");
            }

        }
        catch (Exception e){}
        //展示完广告后，返回主页
        //DriverInit.driver.navigate().back();
    }
}
