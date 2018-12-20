//CreateFile
import java.io.*;

//waitForElement
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

//截图
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class PublicFunction
{
    //创建文件夹
    public void CreateFolders(String folderName)
    {
        String filePath = "screenShots\\"+folderName;
        File fp = new File(filePath);

        if(fp.exists())
        {
            deleteFolder(filePath);//如果目录存在，先清空里面的内容
        }
        else if (!fp.exists()) {
            fp.mkdirs();// 目录不存在的情况下，创建目录。
        }
    }

    //清空指定文件夹里面的内容
    public static boolean deleteFolder(String path)
    {
        File file = new File(path);
        if(!file.exists()){//判断是否待删除目录是否存在
            System.err.println("The dir are not exists!");
            return false;
        }
        String[] content = file.list();//取得当前目录下所有文件和文件夹
        for(String name : content){
            File temp = new File(path, name);
            if(temp.isDirectory()){//判断是否是目录
                deleteFolder(temp.getAbsolutePath());//递归调用，删除目录里的内容
                temp.delete();//删除空目录
            }else{
                if(!temp.delete()){//直接删除文件
                    System.err.println("Failed to delete " + name);
                }
            }
        }
        return true;
    }

    //检查元素是否存在
    public WebElement findElement(AndroidDriver driver, String ele)
    {
        WebDriverWait wait=new WebDriverWait(driver,120);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ele)));

    }

    //截图功能
    public  void screenShot(AndroidDriver driver,String folderName,String ScreenshotName)
    {
        String filePath = "screenShots\\"+folderName;
        File destFile=new File(filePath+"\\"+ScreenshotName+".png");
        File sourceFile=driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, destFile);
        }
        catch (Exception e)
        {

        }
    }
}
