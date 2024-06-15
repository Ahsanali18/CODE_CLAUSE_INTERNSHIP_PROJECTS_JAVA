package BankingSystem;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;	
										//Defining BackgroundPanel Class to add BackgroundPicture 
public class BackgroundPanel extends JPanel {
    public ImageIcon backgroundImage;

    public BackgroundPanel(ImageIcon backgroundImage) {
        this.backgroundImage = backgroundImage;
        setLayout(null); // Use absolute layout for precise positioning
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
 
}
