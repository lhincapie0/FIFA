package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class PanelBotones extends JPanel implements ActionListener{
	
	
	public static final String ARBOL ="ver arbol selecciones";
	public static final String CLASIFICACION ="ver arbol clasificacion";
	
	private VentanaPrincipal ventana;
	private JLabel tituloTxt;
	private JButton verArbolBut;
	private JButton verClasBut;
	
	public PanelBotones(VentanaPrincipal v)
	{
		ventana = v;
		setLayout(new GridLayout(1,3,100,100));
		this.setBackground(Color.white);
		tituloTxt = new JLabel("Nuevas funciones");
		verArbolBut = new JButton("Ver arbol de las selecciones registradas");
		verArbolBut.setActionCommand(ARBOL);
		verArbolBut.addActionListener(this);
		verClasBut = new JButton("Simular posible ganador");
		verClasBut.setActionCommand(CLASIFICACION);
		verClasBut.addActionListener(this);
		this.add(tituloTxt);
		this.add(verArbolBut);
		this.add(verClasBut);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(ARBOL))
		{
			ventana.mostrarArbolSelecciones();
		} else if(e.getActionCommand().equals(CLASIFICACION))
		{
			try {
				ventana.simularGanador();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}
