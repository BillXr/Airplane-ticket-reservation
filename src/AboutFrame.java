package Airtickets;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class AboutFrame extends JFrame {

   
	private static final long serialVersionUID = 1L;

	public void prepareui() {
		
		
		
	
        JLabel aboutLbl = new JLabel();
        aboutLbl.setText("<html><h3>Java Application for airplane tickets</h3></html>");
       
        
        this.add(aboutLbl);
     
        //setup the frame
        this.setSize(400, 400);
      
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("About");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
    }

	

}
