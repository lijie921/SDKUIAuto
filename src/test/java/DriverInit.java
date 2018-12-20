import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.junit.Test;
import java.io.*;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DriverInit
{
    public static AndroidDriver driver;
    public static String phoneName="";

    public static PublicFunction pb=new PublicFunction();
    @BeforeClass
    public static void setUp()
    {

        //加载配置文件
        InputStream inStream = DriverInit.class.getClassLoader().getResourceAsStream("BaseConfig");
        Properties prop = new Properties();
        try {
            prop.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        phoneName=prop.getProperty("phoneName");
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("automationName","Appium");
        cap.setCapability("platformName","Android");
        cap.setCapability("deviceName","Android Emulator");
        cap.setCapability("app","D:\\Users\\SDK\\apps\\Sample_All_Mnt_3.4.2_debug_1811022021.apk");

        //运行case前,先卸载已存app,并安装新app,打开app
        cap.setCapability(MobileCapabilityType.FULL_RESET,"true");

        try
        {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        }
        catch (Exception e){}

        //关闭文件
        try {
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void init()
    {
        //先创建指定手机目录，用于存放截图文件
        pb.CreateFolders(phoneName);
        //=======================初始化================================//
        pb.findElement(driver,"com.unit.sample_all:id/init").click();
        pb.screenShot(driver,phoneName,"HomePage");
    }

}
