
package echocardiogram.gui;

import echocardiogram.PythonRunner;

import java.io.IOException;

public class GUI
{
    private PythonRunner python;
    private MainFrame frame;

    public GUI( PythonRunner pr )
    {
        this.python = pr;

        frame = new MainFrame( this );
        frame.setVisible( true );
    }

    public void showDataTable()
    {
        DataTableFrame dtf = new DataTableFrame();
        dtf.setVisible( true );
    }

    public int execPython( double ageValue, double lvddValue, double wmsValue )
    {
        try
        {
            return python.execute( ageValue, lvddValue, wmsValue );
        } catch( IOException e )
        {

        } catch ( InterruptedException e )
        {

        }

        return 0;
    }
}