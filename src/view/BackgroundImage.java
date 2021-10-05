package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class BackgroundImage extends JLabel{
    public BackgroundImage(String Path) {
    	Image image = new ImageIcon(Path).getImage();
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        image = image.getScaledInstance(screenSize.width,screenSize.height,Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(image));
        setPreferredSize(screenSize);
    }
    public void changeImage(String path)
    {
    	Image image = new ImageIcon(path).getImage();
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        image = image.getScaledInstance(screenSize.width,screenSize.height,Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(image));
        setPreferredSize(screenSize);
    }
}
