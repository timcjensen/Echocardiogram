
package echocardiogram.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataTableFrame extends JFrame
{
    private JPanel mainPanel;
    private JTable dataTable;
    private JScrollPane scrollPane;
    private String[] colNames = { "age", "lvdd", "wall-motion-score"};
    private Dimension windowSize;

    public DataTableFrame()
    {
        windowSize = new Dimension( 800, 600 );

        this.setTitle( "Data" );
        this.setSize( windowSize );

        this.setupTable();
    }

    public void setupTable() {
        Container content = this.getContentPane();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        dataTable = new JTable();
        scrollPane = new JScrollPane( dataTable );

        DefaultTableModel tableModel = new DefaultTableModel( colNames, 0 );

        try
        {
            BufferedReader csvReader = new BufferedReader( new FileReader( "data.csv" ) );

            String row;
            while ( ( row = csvReader.readLine() ) != null )
            {
                String[] data = row.split( "," );

                tableModel.addRow( data );
            }

            csvReader.close();
        } catch( IOException e )
        {
            e.printStackTrace();
        }

        dataTable.setModel( tableModel );
        mainPanel.add( scrollPane );
        content.add( mainPanel );
    }
}