package cn.pigpi;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Test {
	//菜单栏微信坐标
	static int wx_x = 240;
	static int wx_y = 1055;
	//微信通讯录坐标
	static int mail_list_x = 22;
	static int mail_list_y = 118;
	//公众号按钮坐标
	static int gzh_x = 170;
	static int gzh_y = 185;
	//公众号起点坐标
	static int dy_icon_start_x = 380;
	static int dy_icon_start_y = 95;
	//相邻公众号坐标差
	static int dy_icon_plus_x = 70;
	//两排公众号坐标差
	static int dy_icon_plus_y = 115;
	//公众号点开页面“查看历史消息” 相对坐标偏移
	static int yl_x = 100;
	static int yl_y = 275;
	//历史消息页面“x”按钮坐标
	static int list_cancel_x = 1320;
	static int list_cancel_y = 155;
	
	//默认停顿时间
	static int default_stop_time = 1000;
	//一行公众号数量
	static int row_count = 21;
	//默认判断颜色范围
	static int color_range = 10;
	
	//0x2c90ff 0xe0 9ff  0x7bdbff 0xffdbff 0x9da3ff
	

    //java robot 点击微信桌面版 挨个点击公众号的历史文章 捕捉key
    public static void main(String []args) throws AWTException {
    	//点击菜单栏微信
    	Robot robot = new Robot();	
    	robot.mouseMove(wx_x, wx_y);
    	robot.mousePress(KeyEvent.BUTTON1_MASK);  
        robot.mouseRelease(KeyEvent.BUTTON1_MASK);
        robot.delay(default_stop_time); 
        
        //点击微信通讯录
        robot.mouseMove(mail_list_x, mail_list_y);
        robot.mousePress(KeyEvent.BUTTON1_MASK);  
        robot.mouseRelease(KeyEvent.BUTTON1_MASK);
        robot.delay(default_stop_time); 
        
        //点击通讯录中公众号图标
        robot.mouseMove(gzh_x, gzh_y);
        robot.mousePress(KeyEvent.BUTTON1_MASK);  
        robot.mouseRelease(KeyEvent.BUTTON1_MASK);
        robot.delay(default_stop_time); 
        
        int dy_icon_x = dy_icon_start_x;
        int dy_icon_y = dy_icon_start_y;
        //挨个点击公众号，打开公众号信息页，点击“查看历史消息”，然后点击“x”
        for (int i = 1; i <= 5; i++) {
        	//点击公众号图标
        	robot.mouseMove(dy_icon_x, dy_icon_y);
            robot.mousePress(KeyEvent.BUTTON1_MASK);  
            robot.mouseRelease(KeyEvent.BUTTON1_MASK);
            robot.delay(default_stop_time); 
            
            //“查看历史消息” 按钮
            robot.mouseMove(dy_icon_x + yl_x, dy_icon_y + yl_y);
            for (int j = 0; j < color_range; j++) {
            	Color color = robot.getPixelColor(dy_icon_x + yl_x, dy_icon_y + yl_y);
            	color.
            	if () {
            		
				}
			}
            robot.mousePress(KeyEvent.BUTTON1_MASK);  
            robot.mouseRelease(KeyEvent.BUTTON1_MASK);
            
            robot.delay(default_stop_time); 
            
            //“x” 按钮
            robot.mouseMove(list_cancel_x, list_cancel_y);
            robot.mousePress(KeyEvent.BUTTON1_MASK);  
            robot.mouseRelease(KeyEvent.BUTTON1_MASK);
            robot.delay(default_stop_time); 
            
            dy_icon_x += dy_icon_plus_x;
            if (i % row_count == 0) {
            	dy_icon_y += dy_icon_plus_y;
            	dy_icon_x = dy_icon_start_x;
			}
            System.out.println("dy_icon_x:" + dy_icon_x);
            System.out.println("dy_icon_y:" + dy_icon_y);
		}
    }

  
}