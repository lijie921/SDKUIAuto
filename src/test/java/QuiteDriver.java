import org.junit.AfterClass;
import org.junit.Test;

public class QuiteDriver
{
    PublicFunction pb=new PublicFunction();

    @AfterClass
    public static void tearDown()
    {
        //结束驱动
        DriverInit.driver.quit();
       // System.out.println("结束驱动");
    }
    @Test
    public void removeApp()
    {
        DriverInit.driver.navigate().back();

        //测试完成删除apk
       // DriverInit.driver.removeApp("com.unit.sample_all");
       // pb.screenShot(DriverInit.driver, DriverInit.phoneName, "测试结束删除apk");
       // System.out.println("删除app");
    }
}
