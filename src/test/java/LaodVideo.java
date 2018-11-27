import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LaodVideo
{
    @Test
    public void getVideo()
    {
        PublicFunction pb=new PublicFunction();
        //请求video广告:先点击video按钮，进入video广告页面
        DriverInit.driver.findElement(By.id("com.unit.sample_all:id/video")).click();
        //点击Load按钮请求广告
        DriverInit.driver.findElement(By.id("com.unit.sample_all:id/load1")).click();
        try {
            Thread.sleep(20000);
            WebElement msg=pb.findElement(DriverInit.driver,"com.unit.sample_all:id/message1");
            WebElement show=pb.findElement(DriverInit.driver,"com.unit.sample_all:id/show1");
            if(show.isEnabled())
            {
                show.click();
                WebElement closeBtnId=pb.findElement(DriverInit.driver,"closeBtnId");
                if(closeBtnId.isEnabled())
                {
                    pb.screenShot(DriverInit.driver,DriverInit.phoneName,"SuccessToLoadVideo");
                    DriverInit.driver.navigate().back();
                }
                else
                {
                    try {
                        Thread.sleep(60000);
                    }catch (Exception e){}
                }

            }
            else
            {
                System.out.println("Video广告加载失败<"+msg.getText()+">");
                // log.error("Native广告:Show按钮不可点击，也许请求失败，也可能没有offer返回，需结合抓包工具回归测试");
                pb.screenShot(DriverInit.driver,DriverInit.phoneName,"FailToLoadVideo");
            }

        }catch (Exception e){}
        //展示完广告后，返回主页
        DriverInit.driver.navigate().back();
    }
}
