package gui2;
import java.awt.*;
import java.awt.event.*;
public class GUI2 extends Frame {
	
	private TextField[] tf = new TextField[8];
	
	private double xmn = -1,
				   xmx = 1,
				   ymn = -1,
				   ymx = 1,
				   a = 1,
				   b = 1,
				   c = 1,
				   d = 1;
		

	
	private class Platno extends Canvas {	
		public void paint(Graphics g) {
		}
	}
	
	private Platno platno = new Platno();
	
	private GUI2() {
		super("Funkcije");
		setSize(500, 300);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { dispose(); }
		});
		setLayout(new BorderLayout());
		setBackground(Color.lightGray);		
		
		add(platno, "Center");
		
		Panel plo = new Panel();
		CheckboxGroup grupa = new CheckboxGroup();
		RadioPromena osmatrac = new RadioPromena();
		Checkbox radio1 = new Checkbox("sinus");
		radio1.addItemListener(osmatrac);
		radio1.setCheckboxGroup(grupa);
		radio1.setState(true);
		Checkbox radio2 = new Checkbox("poli");
		radio2.addItemListener(osmatrac);
		radio2.setCheckboxGroup(grupa);
		Checkbox radio3 = new Checkbox("razl");
		radio3.addItemListener(osmatrac);
		radio3.setCheckboxGroup(grupa);
		Checkbox radio4 = new Checkbox("oscil");
		radio4.addItemListener(osmatrac);
		radio4.setCheckboxGroup(grupa);
		plo.add(radio1);
		plo.add(radio2);
		plo.add(radio3);
		plo.add(radio4);
		add(plo, "North");
		
		TekstPromena osmat = new TekstPromena();
		
		plo = new Panel();
		plo.setLayout(new GridLayout(4,2,4,2));
		plo.add(new Label("xmin:")); 
		plo.add(tf[0] = new TextField(""+xmn));
		plo.add(new Label("xmax:")); 
		plo.add(tf[1] = new TextField(""+xmx));
		plo.add(new Label("ymin:")); 
		plo.add(tf[2] = new TextField(""+ymn));
		plo.add(new Label("ymax:")); 
		plo.add(tf[3] = new TextField(""+ymx));
		for(int i=0; i<4; i++) tf[i].addTextListener(osmat);
		add(plo, "West");
		
		plo = new Panel();
		plo.setLayout(new GridLayout(4,2,4,2));
		plo.add(new Label("a:")); 
		plo.add(tf[4] = new TextField(""+a));
		plo.add(new Label("b:")); 
		plo.add(tf[5] = new TextField(""+b));
		plo.add(new Label("c:")); 
		plo.add(tf[6] = new TextField(""+c));
		plo.add(new Label("d:")); 
		plo.add(tf[7] = new TextField(""+d));
		for(int i=4; i<8; i++) tf[i].addTextListener(osmat);
		add(plo, "East");
		
		plo = new Panel();
		setBackground(Color.lightGray);
		Button crtaj = new Button("Crtaj");
		plo.add(crtaj);
		crtaj.addActionListener(new Dugme());
		add(plo, "South");
	}
	
	private class RadioPromena implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			String naziv = ((Checkbox)e.getSource()).getLabel();
			/*if(naziv.equals("sinus")) platno.setFun(s);
			else if(naziv.equals("poli")) platno.setFun(p);
			else if(naziv.equals("razl")) platno.setFun(r);
			else if(naziv.equals("oscil")) platno.setFun(o);*/
		}
	}
	
	private class TekstPromena implements TextListener {
		public void textValueChanged (TextEvent e) {
			xmn = Double.parseDouble(tf[0].getText());
			xmx = Double.parseDouble(tf[1].getText());
			ymn = Double.parseDouble(tf[2].getText());
			ymx = Double.parseDouble(tf[3].getText());
			a = Double.parseDouble(tf[4].getText());
			b = Double.parseDouble(tf[5].getText());
			c = Double.parseDouble(tf[6].getText());
			d = Double.parseDouble(tf[7].getText());
		}
	}
	
	private class Dugme implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			platno.repaint();
		}
	}
	
	public static void main(String[] args) {
		new GUI2().setVisible(true);
	}
	
}