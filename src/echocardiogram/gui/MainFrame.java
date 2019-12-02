
package echocardiogram.gui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class MainFrame extends JFrame implements ActionListener
{
    private JPanel mainPanel, bottomPanel, centerPanel, dataPanel, resultPanel;
    private JButton runButton;
    private JFormattedTextField ageField, lvddField, wmsField;
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

        menu = new MainMenu();
        this.setJMenuBar( menu.getMenuBar() );

        runButton = new JButton( "Run" );
        runButton.addActionListener( this );

        dataPanel = new JPanel();
        dataPanel.setLayout( new BorderLayout() );
        dataPanel.setBorder( BorderFactory.createEmptyBorder( 20, 20, 20, 20 ) );

        JLabel ageLabel = new JLabel( "age" );
        JLabel lvddLabel = new JLabel( "lvdd" );
        JLabel wmsLabel = new JLabel( "wall motion score" );

        ageField = new JFormattedTextField( NumberFormat.getNumberInstance() );
        ageField.setColumns( 10 );
        lvddField = new JFormattedTextField( NumberFormat.getNumberInstance() );
        lvddField.setColumns( 10 );
        wmsField = new JFormattedTextField( NumberFormat.getNumberInstance() );
        wmsField.setColumns( 10 );

        ageLabel.setLabelFor( ageField );
        lvddLabel.setLabelFor( lvddField );
        wmsLabel.setLabelFor( wmsField );

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout( new GridLayout( 0, 1 ) );
        labelPanel.add( ageLabel );
        labelPanel.add( lvddLabel );
        labelPanel.add( wmsLabel );

        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout( new GridLayout( 0, 1 ) );
        fieldPanel.add( ageField );
        fieldPanel.add( lvddField );
        fieldPanel.add( wmsField );

        dataPanel.add( labelPanel, BorderLayout.CENTER );
        dataPanel.add( fieldPanel, BorderLayout.LINE_END );

        resultPanel = new JPanel();
        JLabel resultLabel = new JLabel( "Results" );
        resultPanel.add( resultLabel );
        resultPanel.setBorder( BorderFactory.createLineBorder( Color.BLACK ) );

        bottomPanel = new JPanel();
        bottomPanel.add( runButton );

        centerPanel = new JPanel();
        centerPanel.setLayout( new GridLayout() );
        centerPanel.add( dataPanel );
        centerPanel.add( resultPanel );

        mainPanel = new JPanel();
        mainPanel.setLayout( new BorderLayout() );
        mainPanel.add( centerPanel, BorderLayout.CENTER );
        mainPanel.add( bottomPanel, BorderLayout.SOUTH );

        content.add( mainPanel );
    }

    public void actionPerformed( ActionEvent e )
    {
        if ( e.getSource() == runButton )
        {
            double ageValue = ( (Number) ageField.getValue() ).doubleValue();
            double lvddValue = ( (Number) lvddField.getValue() ).doubleValue();
            double wmsValue = ( (Number) wmsField.getValue() ).doubleValue();

            System.out.println( ageValue );
            System.out.println( lvddValue );
            System.out.println( wmsValue );
        }
    }
}