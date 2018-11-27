import org.junit.AfterClass;
import org.junit.Test;

public class QuiteDriver
{

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
        //测试完成删除apk
        DriverInit.driver.removeApp("com.unit.sample_all");
       // System.out.println("删除app");
    }
}
