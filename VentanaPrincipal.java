package interfaz;


import javax.swing.*;

import modelo.Fifa;
import modelo.Seleccion;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class VentanaPrincipal  extends JFrame{
	
	
	
	public static final int AGREGAR = 1;
	public static final int MODIFICAR = 2;
	public static final int GUARDAR = 3;
	private PanelBotones panelBotones;
	private PanelSelecciones panelSelecciones;
	private PanelJugadores panelJugadores;
	private PanelJugador panelJugador;
	private Fifa fifa;
	
	public VentanaPrincipal() throws ClassNotFoundException, IOException
	{
		super("Copa Mundial De La FIFA");
		setSize(1200,600);
		fifa = cargar();
		
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		JPanel panelCentro = new JPanel(); 
		panelBotones = new PanelBotones(this);
		panelCentro.setLayout(new GridLayout(1,3, 5,5));
		panelCentro.setBackground(Color.white);
		this.setBackground(Color.white);
	
		
		panelSelecciones = new PanelSelecciones(this);
		panelJugadores = new PanelJugadores(this);
		panelJugador = new PanelJugador(this);
		
		panelCentro.add(panelSelecciones);
		panelCentro.add(panelJugadores);
		panelCentro.add(panelJugador);
		
		this.add(BorderLayout.CENTER, panelCentro);
		this.add(BorderLayout.NORTH, panelBotones);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e)
			{
				try {
					guardar();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}

	public Fifa cargar() throws  ClassNotFoundException, FileNotFoundException, IOException
	{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("archivo/fifa.dat")));
		Fifa f = (Fifa)in.readObject();
		in.close();
		return f;
	}
	
	public void guardar() throws FileNotFoundException, IOException
	{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("archivo/fifa.dat")));
		out.writeObject(fifa);
		out.close();
	}
	
	public void cargarDatos()
	{

		fifa.agregarSeleccion("Colombia", 989, "Colombia.png");
		//fifa.agregarSeleccion("Venezuela", 709, "Venezuela.png");
		//fifa.agregarSeleccion("Chile",1146, "Chile.png");
		//fifa.agregarSeleccion("Argentina",1254, "Brasil.png");
		//fifa.agregarSeleccion("Francia",1166, "Brasil.png");
		//fifa.agregarSeleccion("Alemania",1544, "Brasil.png");
		//fifa.agregarSeleccion("Brasil",1384, "Brasil.png");
		//fifa.agregarSeleccion("Portugal",1306, "Brasil.png");

		//fifa.agregarSeleccion("Belgica",1346, "Brasil.png");
		



		fifa.addJugador("Colombia", "David Ospina", "Arquero",10, 1.83, "fotos/DavidOspina.png", 1988);
		
		fifa.addJugador("Colombia", "Santiago Arias", "Lateral",6, 1.77, "fotos/SantiagoArias.png", 1992);
		fifa.addJugador("Colombia", "James Rodriguez", "Centrocampista",10, 1.80, "fotos/JamesRodriguez.png", 1991);
		fifa.addJugador("Colombia", "Oscar Murillo", "Central",10, 1.84, "fotos/OscarMurillo.png",1988);

		//fifa.addJugador("Venezuela", "Dani Alvez", "Defensa",10, 1.72,"fotos/DaniAlves.png", 1983);

	}

	public void agregarSeleccion()
	{
		DialogoAgregarSeleccion d = new DialogoAgregarSeleccion(this, AGREGAR);
		d.setLocationRelativeTo(this);
		d.setVisible(true);
		mostrarSelecciones();
		
	}
	
	public void crearSeleccion(String name, String puntos, String i)
	{
		
		int p = Integer.parseInt(puntos);
		fifa.agregarSeleccion(name,p, i);
		panelSelecciones.agregar(name);
	}
	
	public void buscarSeleccion()
	{
		String nombreSeleccion = JOptionPane.showInputDialog("Ingrese el nombre del pais de la selección buscada:");
		String respuesta = fifa.buscarSeleccion(nombreSeleccion);
		JOptionPane.showMessageDialog(this, respuesta);
	}	
	
	public void buscarJugador()
	{
		String nombreJugador = JOptionPane.showInputDialog("Ingrese el nombre del jugador buscado:");
		String respuesta = fifa.buscarJugadorPorNombre(panelSelecciones.getSeleccionActual(),nombreJugador);
		JOptionPane.showMessageDialog(this, respuesta);
	}	
	
	public String[] mostrarSelecciones()
	{
		
		ArrayList<String> listaNombres = fifa.darNombreSelecciones();
		System.out.println(listaNombres);
		String[] nombres = new String[listaNombres.size()];
		for(int i = 0; i<listaNombres.size(); i++)
		{
			nombres[i] = listaNombres.get(i);
		}
		
		
		return nombres;
	}
	
	public void mostrarJugadores(String nombreSeleccion)
	{
		String [] nomJugadores = fifa.darNombresJugadores(panelSelecciones.getSeleccionActual());
		
		for(int i = 0; i<nomJugadores.length; i++)
			{
				System.out.println(nomJugadores[i]);
			}
		panelJugadores.agregarJugadores(nomJugadores);
	}

	public void cambiarDatos( String p, String i)
	{
		
		fifa.cambiarDatosSeleccion(panelSelecciones.getSeleccionActual(),p,i);
	}
	
	public void modificarSeleccion(String seleccion)
	{
		
		String datos[] = fifa.getDatosSeleccion(panelSelecciones.getSeleccionActual());
		
		System.out.println(panelSelecciones.getSeleccionActual() + "  " + datos);
		DialogoAgregarSeleccion d = new DialogoAgregarSeleccion(this, MODIFICAR);
		d.setLocationRelativeTo(this);
		d.setVisible(true);
		//
	
		
	}
	
	public void modificarJugador()
	{
		panelJugador.modificarJugador();
		
	}
	
	public void cambiarDatosJugador(String name,String posicion, String puntaje, String altura, String imagen, String a)
	{
		String[] datos = {posicion, puntaje, altura, imagen, a};
		fifa.modificarJugador(panelSelecciones.getSeleccionActual(), name,datos);
		
	}
	
	public String[] darDatosSeleccion()
	{
		String datos[] = fifa.getDatosSeleccion(panelSelecciones.getSeleccionActual());
		
		 return datos;
	}
	
	public void mostrarJugador(String nombreJugador)
	{
		String [] datos = fifa.getJugador(panelSelecciones.getSeleccionActual(),nombreJugador);
		panelJugador.mostrarJugador(datos);
	}
	
	public void eliminarSeleccion(String nombreSeleccion)
	{
		fifa.eliminarSeleccion(nombreSeleccion);
		System.out.println(fifa.darNombreSelecciones() + "mm");
	}
	
	public void eliminarJugador(String nombreJugador)
	{
		fifa.eliminarJugador(panelSelecciones.getSeleccionActual(), nombreJugador);
		getPrimerJugador();
		
	}
	
	//Panel Jugadores 
	public void addJugador()
	{
		panelJugador.agregarJugador();

	}
	
	//Panel Jugador
	public void agregarJugador(String nombre, String posicion, String puntaje, String altura, String imagen, String a){
		
		int p = Integer.parseInt(puntaje);
		double al = Double.parseDouble(altura);
		int anio = Integer.parseInt(a);
		fifa.addJugador(panelSelecciones.getSeleccionActual(),nombre, posicion,p, al, imagen,anio);
		panelJugadores.agregarJugador(nombre);
	}
	
	public void getJugadorAnterior()
	{
		
		String anterior = fifa.getJugadorAnterior(panelSelecciones.getSeleccionActual(), panelJugadores.getJugadorActual());
		System.out.println(anterior + " vv ");
		panelJugadores.setJugadorActual(anterior);
		String [] datos = fifa.getJugador(panelSelecciones.getSeleccionActual(),anterior);
		panelJugador.mostrarJugador(datos);
	}
	
	public void setJugadorActual()
	{
		String primer = fifa.getPrimerJugador(panelSelecciones.getSeleccionActual());
		panelJugadores.setJugadorActual(primer);
	}
	
	public void getJugadorSiguiente()
	{
		String siguiente = fifa.getJugadorSiguiente(panelSelecciones.getSeleccionActual(), panelJugadores.getJugadorActual());
	
		panelJugadores.setJugadorActual(siguiente);
		String [] datos = fifa.getJugador(panelSelecciones.getSeleccionActual(),siguiente);
		panelJugador.mostrarJugador(datos);
	}
	

	public void getPrimerJugador()
	{
		String primer = fifa.getJugadorSiguiente(panelSelecciones.getSeleccionActual(), panelJugadores.getJugadorActual());

		panelJugadores.setJugadorActual(primer);
		String [] datos = fifa.getJugador(panelSelecciones.getSeleccionActual(),primer);
		panelJugador.mostrarJugador(datos);
	}
	
	public void mostrarArbolSelecciones()
	{
		DialogoArbol d = new DialogoArbol(this, fifa);
		d.setLocationRelativeTo(this);
		d.setVisible(true);
		
	}
	
	public void simularGanador() throws IOException
	{
		DialogoSimulacion d = new DialogoSimulacion();
		
	}
	
	public static final void main(String[] args) throws ClassNotFoundException, IOException
	{
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
	}

}
