package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import modelo.Fifa;

public class DialogoAgregarSeleccion extends JDialog implements ActionListener {

	public static final String GUARDAR = "guardar";
	public static final String PIC = "pic";
	
	//private Fifa fifa;
	private JButton guardar;
	private VentanaPrincipal ventana;
	private int opcion;
	
	private JLabel paisLab;
	private JTextArea paisTxt;
	private JLabel puntosLab;
	private JTextArea puntosTxt;
	private JLabel promALab;
	private JTextArea promATxt;
	private JLabel promELab;
	private JTextArea promETxt;
	private JLabel promFifaLab;
	private JTextArea promFifaTxt;
	private JLabel imagenLab;
	private JButton imagenBut;
	private JLabel pic;
	private JPanel foto;
	
	public DialogoAgregarSeleccion(VentanaPrincipal v, int o)
	{
		super(v, true);
		this.setSize(800, 400);
		ventana = v;
		this.setBackground(Color.white);
		opcion = o;
	
		this.setLayout(new GridLayout(1, 2));
		
		Font fuente = new Font("Calibri", Font.PLAIN, 18);
		Font fuente2 = new Font("Calibri", Font.PLAIN, 14);
		Color colorLetra = new Color(143,143,143);
		foto = new JPanel();
		foto.setLayout(new GridLayout(1, 1));
		TitledBorder border = new TitledBorder("Seleccion");
	    border.setTitleJustification(TitledBorder.LEFT);
	    border.setTitlePosition(TitledBorder.TOP);
	    border.setTitleFont(new Font("Calibri", Font.BOLD, 18));
	    border.setTitleColor(colorLetra);
		foto.setBorder(border);
		foto.setBackground(Color.WHITE);
	
		
		
		ImageIcon i = new ImageIcon("fotos/paises.png");
		pic = new JLabel(i);
		
		foto.add(pic);
		this.add(foto);
		
		JPanel datos = new JPanel();
		datos.setLayout(new GridLayout(7,2));
		
		paisLab = new JLabel("        Pais", SwingConstants.LEFT);
		paisLab.setBackground(Color.WHITE);
		paisLab.setForeground(colorLetra);
		paisLab.setOpaque(true);
		paisLab.setFont(fuente);
		
		paisTxt = new JTextArea();
		paisTxt.setFont(fuente2);
		paisTxt.setBorder(BorderFactory.createEtchedBorder());

		puntosLab = new JLabel("        Puntos",SwingConstants.LEFT);
		puntosLab.setForeground(colorLetra);
		puntosLab.setBackground(Color.WHITE);
		puntosLab.setOpaque(true);
		puntosLab.setFont(fuente);
		
		puntosTxt = new JTextArea();
		puntosTxt.setFont(fuente2);
		puntosTxt.setBorder(BorderFactory.createEtchedBorder());

		promALab = new JLabel("        Promedio Altura",SwingConstants.LEFT);
		promALab.setForeground(colorLetra);
		promALab.setBackground(Color.WHITE);
		promALab.setFont(fuente);
		promALab.setOpaque(true);
		
		promATxt = new JTextArea();
		promATxt.setEditable(false);
		promATxt.setFont(fuente2);
		promATxt.setBorder(BorderFactory.createEtchedBorder());

		promELab = new JLabel("        Promedio Edad",SwingConstants.LEFT);
		promELab.setBackground(Color.WHITE);
		promELab.setFont(fuente);
		promELab.setForeground(colorLetra);
		promELab.setOpaque(true);

		promETxt = new JTextArea();
		promETxt.setEditable(false);
		promETxt.setFont(fuente2);
		promETxt.setBorder(BorderFactory.createEtchedBorder());
		
		promFifaLab = new JLabel("        Promedio Fifa",SwingConstants.LEFT);
		promFifaLab.setForeground(new Color(143,143,143));
		promFifaLab.setFont(fuente);
		promFifaLab.setOpaque(true);
		promFifaLab.setBackground(Color.WHITE);
		
		promFifaTxt = new JTextArea();
		promFifaTxt.setEditable(false);
		promFifaTxt.setFont(fuente2);
		promFifaTxt.setBorder(BorderFactory.createEtchedBorder());
		
		imagenLab = new JLabel("        Imagen",SwingConstants.LEFT);
		imagenLab.setFont(fuente);
		imagenLab.setForeground(colorLetra);
		imagenLab.setBackground(Color.WHITE);
		imagenLab.setOpaque(true);
		
		imagenBut = new JButton();
		imagenBut.setFont(fuente2);
		imagenBut.setBorder(BorderFactory.createEtchedBorder());
		imagenBut.setActionCommand(PIC);
		imagenBut.addActionListener(this);

		
		
		datos.add(paisLab);
		datos.add(paisTxt);
		datos.add(puntosLab);
		datos.add(puntosTxt);		
		datos.add(promALab); 
		datos.add(promATxt );
		datos.add(promELab);
		datos.add(promETxt);
		datos.add(promFifaLab);
		datos.add(promFifaTxt);
		datos.add(imagenLab);
		datos.add(imagenBut);
		
		JLabel e = new JLabel("");
		e.setBackground(Color.WHITE);
		e.setOpaque(true);
		datos.add(e);
		
		guardar = new JButton("Agregar Seleccion");
		guardar.setActionCommand(GUARDAR);
		guardar.addActionListener(this);
		guardar.setForeground(Color.WHITE);
		guardar.setFont( new Font("Calibri", Font.BOLD, 18));
		guardar.setBorder(BorderFactory.createRaisedBevelBorder());
		guardar.setBackground(new Color(4, 120, 239));
		
		datos.add(guardar);
		
		this.add(datos);
		
		if( o == ventana.MODIFICAR)
		{
			String dat[] = ventana.darDatosSeleccion();
			paisTxt.setText(dat[0]);
			puntosTxt.setText(dat[1]);
			promATxt.setText(dat[2]);
			promETxt.setText(dat[3]);
			promFifaTxt.setText(dat[4]);
			ImageIcon im = new ImageIcon(""+dat[5]+"");
			pic.setIcon(im);

			imagenBut.setText(dat[5]);
			guardar.setText("Guardar cambios");
			paisTxt.setEditable(false);
			JOptionPane.showMessageDialog(this,"Por cuestiones de manejo, el nombre de las Selecciones no esta habilitado para ser cambiado");
			
		}
	}
	
	public void modificarSeleccion()
	{	
		String n = paisTxt.getText();
		
		
		String i = imagenBut.getText();
		String p = puntosTxt.getText();
		ventana.cambiarDatos(p,i);
	}
	
	public void agregarSeleccion()
	{
		String n = paisTxt.getText();
		String i = imagenBut.getText();
		String p = puntosTxt.getText();

		ventana.crearSeleccion(n, p, i);
	}
	
	
	private String abrirImagen() {
		  String aux="";   
		  String texto="";
		  JFileChooser file = new JFileChooser();
		   file.showOpenDialog(this);
		   File imagen = file.getSelectedFile();
		 
		   
		   if(imagen!=null)
		   { 
			   ImageIcon i = new ImageIcon(""+imagen+"");
			   imagenBut.setText(""+imagen+"");
			   pic.setIcon(i);
		   }
		  return texto;//El texto se almacena en el JTextArea
		}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals(GUARDAR))
		{
			if(opcion == ventana.AGREGAR)
			{
				dispose();
				agregarSeleccion();
			}
			else if(opcion == ventana.MODIFICAR)
			{
				dispose();
				modificarSeleccion();
			}
			
			//dispose();
		} else if(e.getActionCommand().equals(PIC))
		{
			abrirImagen();
		}
	}
}
