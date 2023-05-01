package project;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.nio.MappedByteBuffer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame{
    JPanel mapPanel = new JPanel();
    JPanel object = new JPanel();

    Container container = getContentPane();

    int mapWidth = 10;
    int mapHeight = 10;

    View(int width, int height){
        mapHeight = width;
        mapHeight = height;
        design();
    }

    public void Show(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);    
    }

    public void design(){
        setTitle("TEST View: Maze Escape");
        setBounds(200,50,700,700);
        container.setLayout(null);
        
        mapPanel.setBounds(50,50,600,600);
        mapPanel.setBackground(Color.lightGray);
        mapPanel.setLayout(null);

        object.setBounds(1,2,10,10);
        object.setBackground(Color.black);
        mapPanel.add(object);
        
        add(mapPanel);
    }

    public void moveObjectView(int x, int y){
        object.setLocation(x,y);
    }


}
