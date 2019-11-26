
package echocardiogram.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener
{
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem importMenuItem, exportMenuItem, exitMenuItem;

    public MainMenu()
    {
        menuBar = new JMenuBar();

        fileMenu = new JMenu( "File" );

        importMenuItem = new JMenuItem( "Import Data" );
        importMenuItem.addActionListener( this );

        exportMenuItem = new JMenuItem( "Export Data" );
        exportMenuItem.addActionListener( this );

        exitMenuItem = new JMenuItem( "Exit" );
        exitMenuItem.addActionListener( this );

        fileMenu.add( importMenuItem );
        fileMenu.add( exportMenuItem );
        fileMenu.add( exitMenuItem );

        menuBar.add( fileMenu );
    }

    public void actionPerformed( ActionEvent e )
    {
        if ( e.getSource() == exitMenuItem )
            System.out.println( "EXIT" );

        if ( e.getSource() == exportMenuItem )
            System.out.println( "EXPORT" );

        if ( e.getSource() == importMenuItem )
            System.out.println( "IMPORT" );
    }

    public JMenuBar getMenuBar()
    {
        return this.menuBar;
    }
}