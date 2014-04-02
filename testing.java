//this is a test...
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class MainClass extends JPanel
implements ActionListener 
{
    protected JButton b1, b2, b3;

    public MainClass() 
    {
    	ImageIcon make = new ImageIcon("save.png");
    	ImageIcon delete = new ImageIcon("delete.png");
    	ImageIcon close = new ImageIcon("exit.png");
        b1 = new JButton("Make File", make);
        b1.setActionCommand("make");

        b2 = new JButton("Delete File", delete);
        b2.setActionCommand("delete");

        b3 = new JButton("Close Program", close);
        b3.setActionCommand("close");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        b1.setToolTipText("Makes Text file \"text.txt\"");
        b2.setToolTipText("Deletes \"text.txt\"");
        b3.setToolTipText("Closes program.");
        add(b1);
        add(b2);
        add(b3);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if ("make".equals(e.getActionCommand()))
        {
            File f = new File("text.txt");
            try
            {
                PrintWriter out = new PrintWriter(f);
                out.println("TheBestMacTutorials");
                out.close();
            }
            catch (Exception e2)
            {
                
            }
        } 
        else if ("delete".equals(e.getActionCommand()))
        {
            File f = new File("text.txt");
            f.delete();
        }
        else
        {
            System.exit(0);
        }
    }
    
    private static void createAndShowGUI() 
    {
        JFrame frame = new JFrame("TheBestMacTutorials Tutorial #11");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainClass newContentPane = new MainClass();
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
                public void run() 
                {
                    createAndShowGUI(); 
                }
            });
    }
}