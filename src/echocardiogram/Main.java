
// Echocardiogram Machine Learning Projcet
// Data source: https://archive.ics.uci.edu/ml/datasets/Echocardiogram

package echocardiogram;

import echocardiogram.gui.GUI;

public class Main
{
    public static void main( String[] args )
    {
        PythonRunner pr = new PythonRunner();
        GUI gui = new GUI( pr );
    }
}
