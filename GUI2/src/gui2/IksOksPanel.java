package gui2;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class IksOksPanel extends Panel
{
    public IksOksPanel() 
    {
        this.setBackground(Color.red);
        this.setLayout(new GridLayout(2,2));
        DugmeOsluskivac d = new DugmeOsluskivac();
        Button b1 = new Button("\tb1");
        add(b1);
        b1.addActionListener(d);
        Button b2 = new Button("\tb2");
        add(b2);
        b2.addActionListener(d);
        Button b3 = new Button("\tb3");
        add(b3);
        b3.addActionListener(d);
        Button b4 = new Button("\tb4");
        add(b4);
        b4.addActionListener(d);
    }
    private class DugmeOsluskivac implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            System.out.println("Kliknuto");
	}
    }
}
