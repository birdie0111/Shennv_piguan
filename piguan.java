import org.opencv.core.Core;
import java.lang.Thread;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Shennv {
	public static void wait(int ms) {
		try {
			Thread.sleep(ms);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        int i = 1;
        Mat dst = new Mat();
        Mat x = new Mat();
        Mat y = new Mat();
        Mat xy = new Mat();
        double scale_x = 0.9, scale_y = 0.5;
        
        for (i = 101; i <=3283; i++) {
        	if(i%10 == 0) {
        		wait(1000);
        	}
        	Mat src = Imgcodecs.imread("D:\\bird\\Genshin\\Shennv_Piguan\\out"+i+".png");
            
            Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2GRAY);
            
            Imgproc.Sobel(dst, x, -1, 1, 0, 3, Core.BORDER_DEFAULT);
            //Imgcodecs.imwrite("D:\\academy\\eclipse_data\\Piguan\\childe_x.png", x);
            
            
            Imgproc.Sobel(dst, y, -1, 0, 1, 3, Core.BORDER_DEFAULT);
            //Imgcodecs.imwrite("D:\\academy\\eclipse_data\\Piguan\\childe_y.png", y);
            
            
            
            /*
            int i = 0;
            for(i=0;i<5;i++) {
            	Core.addWeighted(x, scale_x, y, scale_y, 0, xy);
            	scale_x += 0.1;
            	//scale_y -= 0.1;
                Imgcodecs.imwrite("D:\\academy\\eclipse_data\\Piguan\\childe_xy"+i+".png", xy);
            }
            */
            Core.addWeighted(x, scale_x, y, scale_y, 0, xy);
            Imgcodecs.imwrite("D:\\bird\\Genshin\\out\\piguan"+i+".png", xy);
        }
        

	}

}
