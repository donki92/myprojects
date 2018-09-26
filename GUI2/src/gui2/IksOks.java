package gui2;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class IksOks extends Frame
{
    public IksOks() 
    {
        super("IksOks");
        setSize(500, 300);
        addWindowListener(
            new WindowAdapter() 
            {
		public void windowClosing(WindowEvent e) { dispose(); }
            });
        IksOksPanel panel = new IksOksPanel();
        add(panel);
    }
    public static void main(String[] args) 
    {
        new IksOks().setVisible(true);
    }
}

