package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.ScrollPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import modelo.Fifa;
import modelo.Seleccion;


public class DialogoArbol extends JDialog implements MouseListener{
	
	
	private Graphics2D g2D;
	private VentanaPrincipal ventana;
	private Fifa f;
	
	public DialogoArbol(VentanaPrincipal v, Fifa f) {
		
		ventana = v;
		this.setSize(getToolkit().getScreenSize());
		this.setBackground(Color.white);
		this.addMouseListener(this);
	
		this.f = f;
		
	}
	
	@Override
	public void paint(Graphics g)
	{
		
		super.paint(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0,2000,2000);
		g.setColor(Color.black);
		ImageIcon i = new ImageIcon(f.getRaiz().getImagen());
		g.drawImage(i.getImage(), 10, this.getHeight()/2, 80, 50, this);
		
	
		dibujar(f.getRaiz(),10, this.getHeight()/2,250,g);
	}
	
	public void dibujar(Seleccion s, int x, int y, int sep, Graphics g)
	{
		
		
		System.out.println(s.getName() + " "+x +";"+y);
		if(s.getDerecha() != null)
		{	
			g.drawLine(x+80,y+25, x+200, y-sep+25);
			ImageIcon i = new ImageIcon(s.getDerecha().getImagen());
			g.drawImage(i.getImage(), x+200, y-sep, 80, 50, this);
			
			
			dibujar(s.getDerecha(), x+200, y - sep,sep-(sep/2), g);
		}
		if(s.getIzquierda() != null)
		{g.drawLine(x+80,y+25, x+200, y+sep+25);

			ImageIcon i = new ImageIcon(s.getIzquierda().getImagen());
			g.drawImage(i.getImage(), x+200, y+sep, 80, 50, this);
			
			dibujar(s.getIzquierda(), x+200, y +sep,sep-(sep/2), g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("x: "+arg0.getX());
		System.out.println("y: "+arg0.getY());

		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
