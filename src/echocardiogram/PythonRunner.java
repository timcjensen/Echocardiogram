
package echocardiogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonRunner
{
    String cmd = "";

    public PythonRunner()
    {
        cmd = "python mlp_driver.py";
    }

    public int execute( double ageValue, double lvddValue, double wmsValue ) throws IOException, InterruptedException
    {
        String command = cmd + " " + ageValue + " " + lvddValue + " " + wmsValue;
        System.out.println(command);
        try{
            Process p = Runtime.getRuntime().exec( command );

            p.waitFor();

            BufferedReader in = new BufferedReader( new InputStreamReader( p.getInputStream() ) );
            String line = in.readLine();
            System.out.println(line);
            return (int) Double.parseDouble( line );
        } catch( IOException e )
        {
            e.printStackTrace();
        }
        return 0;
    }
}