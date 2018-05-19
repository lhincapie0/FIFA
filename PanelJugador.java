package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PanelJugador extends JPanel implements ActionListener {

	

	private JLabel tituloTxt;
	private ImageIcon foto;
	private JLabel nombreLab;
	private JTextArea nombreTxt;
	
	public static final String ANTERIOR = "anterior";
	public static final String PRIMERO= "primero";
	public static final String SIGUIENTE = "siguiente";
	public static final String GUARDAR = "guardar";
	public static final String MODIFICAR = "modificar";
	public static final String PIC = "pic";

	private VentanaPrincipal ventana;
	private JButton anterior;
	private JButton primero;
	private JButton siguiente;
	private JButton guardar;
	private JButton modificar;
	private JPanel botones;
	private JPanel botones2;
	private JPanel sup;
	private JPanel datos;
	
	private JLabel fotoLab;
	
	private JLabel nameLab; 
	private JTextArea nameTxt;
	private JLabel posicionLab;
	private JTextArea posicionTxt;
	private JLabel puntajeLab;
	private JTextArea puntajeTxt;
	private JLabel fechaLab;
	private JTextArea fechaTxt;
	private JLabel alturaLab;
	private JTextArea alturaTxt;
	private JLabel imagenLab;
	private JButton imagenBut;
	
	public PanelJugador(VentanaPrincipal v)
	{
		ventana = v;Font f = new Font("Calibri", Font.BOLD, 18);
		setBorder(BorderFactory.createLineBorder(Color.gray));
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		this.setToolTipText("Jugador");
		String nombre = "James Rodriguez";
	
		
		fotoLab = new JLabel();
	
		guardar = new JButton("");
		guardar.setActionCommand(GUARDAR);
		guardar.addActionListener(this);
		guardar.setBackground(Color.WHITE);
		guardar.setForeground(Color.BLACK);
		guardar.setFont(new Font("calibri", Font.BOLD, 14  ));
		modificar = new JButton("");
		modificar.setActionCommand(MODIFICAR);
		modificar.addActionListener(this);
		modificar.setBackground(Color.WHITE);
		modificar.setForeground(Color.BLACK);
		modificar.setFont(new Font("calibri", Font.BOLD, 14  ));
		
		JLabel jugador = new JLabel(nombre);
		jugador.setForeground(Color.black);
		jugador.setBackground(Color.YELLOW);
		jugador.setBorder(new TitledBorder(nombre));
		jugador.setFont( f);
		sup = new JPanel();
		sup.setLayout(new GridLayout(1,2));
		sup.setBackground(Color.white);
		
	
		sup.add(fotoLab);
		
		
		
		nameLab = new JLabel("          Nombre");
		nameLab.setFont( f);
		nameLab.setForeground(new Color(143,143,143));
		nameLab.setOpaque(true);
		nameLab.setBackground(Color.WHITE);
		nameTxt = new JTextArea();
		nameTxt.setBorder(BorderFactory.createEtchedBorder());
		posicionLab = new JLabel("          Posicion");
		posicionLab.setFont( f);
		posicionLab.setForeground(new Color(143,143,143));
		posicionLab.setOpaque(true);
		posicionLab.setBackground(Color.WHITE);
		posicionTxt = new JTextArea();
		posicionTxt.setBorder(BorderFactory.createEtchedBorder());
		puntajeLab = new JLabel("          Puntaje");
		puntajeLab.setForeground(new Color(143,143,143));
		puntajeLab.setFont( f);
		puntajeLab.setOpaque(true);
		puntajeLab.setBackground(Color.WHITE);
		puntajeTxt = new JTextArea();
		puntajeTxt.setBorder(BorderFactory.createEtchedBorder());
		fechaLab = new JLabel("          Edad");
		fechaLab.setForeground(new Color(143,143,143));
		fechaLab.setFont( f);
		fechaLab.setOpaque(true);
		fechaLab.setBackground(Color.WHITE);
		fechaTxt = new JTextArea();
		fechaTxt.setBorder(BorderFactory.createEtchedBorder());
		alturaLab = new JLabel("          Altura");
		alturaLab.setForeground(new Color(143,143,143));
		alturaLab.setFont( f);
		alturaLab.setOpaque(true);
		alturaLab.setBackground(Color.WHITE);
		alturaTxt = new JTextArea();
		alturaTxt.setBorder(BorderFactory.createEtchedBorder());
		imagenLab = new JLabel("          Imagen");
		imagenLab.setForeground(new Color(143,143,143));
		imagenLab.setFont( f);
		imagenLab.setOpaque(true);
		imagenLab.setBackground(Color.WHITE);
		imagenBut = new JButton();
		imagenBut.setActionCommand(PIC);
		imagenBut.addActionListener(this);
		imagenBut.setBorder(BorderFactory.createEtchedBorder());
		
		 datos = new JPanel();
		datos.setLayout(new GridLayout(7,2));
		sup.setBackground(Color.white);
		datos.add(nameLab);
		datos.add(nameTxt);
		datos.add(posicionLab);
		datos.add(posicionTxt);
		datos.add(puntajeLab);
		datos.add(puntajeTxt);
		datos.add(alturaLab);
		datos.add(alturaTxt);
		datos.add(fechaLab);
		datos.add(fechaTxt);
		datos.add(imagenLab);
		datos.add(imagenBut);
		datos.add(guardar);
		datos.add(modificar);
		
		
	
		botones = new JPanel();
		botones.setLayout(new GridLayout(1,3));
		botones.setBackground(Color.WHITE);
	
		anterior = new JButton("Anterior");
		anterior.setActionCommand(ANTERIOR);
		anterior.setBackground(Color.WHITE);
		anterior.setForeground(Color.BLACK);
		anterior.setFont(new Font("calibri", Font.BOLD, 15  ));
		anterior.addActionListener(this);
		anterior.setBorder(BorderFactory.createRaisedBevelBorder());
		primero = new JButton("Primero");
		primero.setActionCommand(PRIMERO);
		primero.addActionListener(this);
		primero.setBackground(Color.WHITE);
		primero.setForeground(Color.BLACK);
		primero.setFont(new Font("calibri", Font.BOLD, 15  ));
		primero.setBorder(BorderFactory.createRaisedBevelBorder());
		siguiente = new JButton("Siguiente");
		siguiente.setActionCommand(SIGUIENTE);
		siguiente.addActionListener(this);
		siguiente.setBackground(Color.WHITE);
		siguiente.setForeground(Color.BLACK);
		siguiente.setFont(new Font("calibri", Font.BOLD, 15  ));
		siguiente.setBorder(BorderFactory.createRaisedBevelBorder());
		botones.add(anterior);
		botones.add(primero);
		botones.add(siguiente);
		
		
		this.add(BorderLayout.NORTH, sup);
		this.add(BorderLayout.CENTER, datos);
		this.add(BorderLayout.SOUTH, botones);
		
	}
	
	
	
	public void mostrarJugador(String[] datos)
	{
		nameTxt.setText(datos[0]);
		posicionTxt.setText(datos[1]);
		puntajeTxt.setText(datos[2]);
		alturaTxt.setText(datos[3]);
		imagenBut.setText(datos[4]);
		fechaTxt.setText(datos[5]); 
		fotoLab.setIcon(new ImageIcon(datos[4]));
	}
	public void agregarJugador()
	{
		guardar.setText("Guardar cambios");
		nameTxt.setText("");
		fechaLab.setText("Año de nacimiento");
		posicionTxt.setText("");
		puntajeTxt.setText("");
		alturaTxt.setText("");
		imagenBut.setText("");
		fechaTxt.setText("");
		
	}
	
	public void abrirImagen() {
		  String aux="";   
		  String texto="";
		  JFileChooser file = new JFileChooser();
		   file.showOpenDialog(this);
		   File imagen = file.getSelectedFile();
		 
		   
		   if(imagen!=null)
		   { 
			   ImageIcon i = new ImageIcon(""+imagen+"");
			   imagenBut.setText(""+imagen+"");
			   fotoLab.setIcon(i);
			   
		   }
		 
		}
	public void modificarJugador()
	{
		modificar.setText("Guardar Cambios");
		nameTxt.setEditable(false);
	}
	public void borrarJugador()
	{
		nameTxt.setText("");
		posicionTxt.setText("");
		puntajeTxt.setText("");
		alturaTxt.setText("");
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals(ANTERIOR))
		{
			System.out.println("anterior");
			ventana.getJugadorAnterior();
		} else if(e.getActionCommand().equals(PRIMERO))
		{
			ventana.getPrimerJugador();
		} else if(e.getActionCommand().equals(SIGUIENTE))
		{
			ventana.getJugadorSiguiente();
		} else if(e.getActionCommand().equals(GUARDAR))
		{
			ventana.agregarJugador(nameTxt.getText(), posicionTxt.getText(),puntajeTxt.getText(), alturaTxt.getText(), imagenBut.getText(), fechaTxt.getText());
			guardar.setText("");
		} else if(e.getActionCommand().equals(GUARDAR))
		{
			modificar.setText("");
			ventana.cambiarDatosJugador( nameTxt.getText(),posicionTxt.getText(),puntajeTxt.getText(), alturaTxt.getText(), imagenBut.getText(), fechaTxt.getText());
			nombreTxt.setEditable(true);
			fechaLab.setText("Edad");
			
		} else if(e.getActionCommand().equals(PIC))
		{
			abrirImagen();
		}

	}
	
}
