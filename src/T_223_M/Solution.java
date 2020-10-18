package T_223_M;

import java.awt.Rectangle;

public class Solution {
	//投机取巧，就为了用Rect的intersection方法 ,	效率很低
    public static int computeArea0(int A, int B, int C, int D, int E, int F, int G, int H) {
        Rectangle rect1=new Rectangle();
        int rect1_width=Math.abs(A-C);
        int rect1_height=Math.abs(B-D);
        rect1.setSize(rect1_width, rect1_height);
        rect1.setLocation(A, B);
        
        Rectangle rect2=new Rectangle();
        int rect2_width=Math.abs(E-G);
        int rect2_height=Math.abs(H-F);
        rect2.setSize(rect2_width,rect2_height);
        rect2.setLocation(E,F);
        
        Rectangle rectInter= rect2.intersection(rect1);
        int interSection=0;
        if(rectInter.getHeight()<0||rectInter.getWidth()<0)
        {
        	interSection=0;
        }
        else {
			interSection=rectInter.height*rectInter.width;
		}
        
        return (int) (rect1_width*rect1_height+rect2_width*rect2_height-interSection);
    }
    
    public static int computeArea1(int A, int B, int C, int D, int E, int F, int G, int H) {
    	int rect1Width=Math.abs(A-C);
    	int rect1Height=Math.abs(B-D);
    	int rect2Width=Math.abs(E-G);
    	int rect2Height=Math.abs(F-H);
    	
    	int interHeight=getInter(B, D, F, H);
    	int interWidth=getInter(A, C, E, G);
    	return rect1Width*rect1Height+rect2Width*rect2Height-interHeight*interWidth;
    }
    
    //这个太扯了？ 想想还有更多简单的方法    
    private static int getInter(int line1X1,int line1X2,int line2X1,int line2X2) {
    	if (line1X1<line2X1) {
			if (line1X2<line2X1) {
				return 0;
			}
			else {
				if (line1X2>line2X2) {
					return Math.abs(line2X2-line2X1);
				}
				else {
					return Math.abs(line1X2-line2X1);
				}
			}
		}
    	else {
			if (line1X1>line2X2) {
				return 0;
			}
			else {
				if (line1X2>line2X2) {
					return Math.abs(line2X2-line1X1);
				}
				else {
					return Math.abs(line1X2-line1X1);
				}
			}
		}
    }
}
