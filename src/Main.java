import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setTitle("Sorting Visualizer");
        frame.add(new SortingPanel());
        frame.setVisible(true);

        ImageIcon image=new ImageIcon("img.png");
        frame.setIconImage(image.getImage()); //change frame icon
        frame.getContentPane().setBackground(Color.lightGray); //or new color(0,0,0)

    }
}
