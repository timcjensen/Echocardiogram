
package echocardiogram.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

public class MainFrame extends JFrame
{
    private JPanel mainPanel;
    private MainMenu menu;
    private Dimension windowSize;

    public MainFrame()
    {
        // default window size
        this.windowSize = new Dimension( 800, 600 );

        this.setTitle( "Echocardiogram Data Set" );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setSize( windowSize );

        this.setupPanels();

        // put the window in the center of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int windowX = (int) ( ( screenSize.getWidth() - this.getWidth() ) / 2 );
        int windowY = (int) ( ( screenSize.getHeight() - this.getHeight() ) / 2 );

        this.setLocation( windowX, windowY );
    }

    private void setupPanels()
    {
        Container content = this.getContentPane();

        mainPanel = new JPanel();
        mainPanel.setLayout( new BorderLayout() );

        menu = new MainMenu();
        this.setJMenuBar( menu.getMenuBar() );

        content.add( mainPanel );
    }
}