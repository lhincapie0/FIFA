package interfaz;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;

public class PanelJugadores extends JPanel implements ActionListener
{
	
	
	public static final String AGREGAR = "agregar";
	public static final String ELIMINAR= "eliminar";
	public static final String BUSCAR = "buscar";
	public static final String MODIFICAR = "modificar";

	public static final String VER = "ver";
	
	private VentanaPrincipal ventana;
	private JButton agregar;
	private JButton eliminar;
	private JButton buscar;
	private JButton modificar;
	private JButton ver;
	
	private JList<String> jugadores;
	private DefaultListModel<String>  listModel;
	
	private String jugadorActual;
	private int numSeleccion;
	
	public PanelJugadores( VentanaPrincipal v) 
	{
		
		ventana = v;
		Font fuente = new Font("Calibri", Font.BOLD, 15);
		setLayout(new BorderLayout());
		
		this.setBackground(Color.white);

		this.setToolTipText("Jugadores");

		setBorder(BorderFactory.createLineBorder(Color.gray));
		
		//Titulo
		JPanel tit = new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		tit.setBackground(Color.WHITE);
		tit.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		JLabel selecciones = new JLabel("Jugadores");
		selecciones.setFont(new Font("Calibri", Font.BOLD, 20 ));
		selecciones.setForeground(new Color(0, 127, 255));
		selecciones.setBackground(Color.WHITE);
		tit.add(selecciones);
		this.add(BorderLayout.NORTH, tit);
		
		JPanel botones = new JPanel();
		botones.setBackground(Color.WHITE);
		botones.setLayout(new GridLayout(1,5));
		
		this.add(BorderLayout.SOUTH, botones);
		
		agregar = new JButton("Agregar");
		agregar.setActionCommand(AGREGAR);
		agregar.setBackground(Color.blue);
		agregar.setForeground(Color.WHITE);
		agregar.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		agregar.setFont(fuente);
		agregar.addActionListener(this);
		eliminar = new JButton("Eliminar");
		eliminar.setActionCommand(ELIMINAR);
		eliminar.addActionListener(this);
		eliminar.setFont(fuente);
		eliminar.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		buscar = new JButton("Buscar");
		buscar.setActionCommand(BUSCAR);
		buscar.addActionListener(this);
		buscar.setFont(fuente);
		buscar.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		modificar = new JButton("Modificar");
		modificar.setActionCommand(MODIFICAR);
		modificar.addActionListener(this);
		modificar.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		modificar.setFont(fuente);
		ver = new JButton("Ver");
		ver.setActionCommand(VER);
		ver.addActionListener(this);
		ver.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		ver.setFont(fuente);
		botones.add(agregar);
		botones.add(eliminar);
		botones.add(buscar);
		botones.add(modificar);
		botones.add(ver);
		JPanel centro = new JPanel();
		centro.setLayout(new BorderLayout());
		
		
		jugadorActual ="";
		listModel = new DefaultListModel<>();
	
		jugadores = new JList<String>(listModel);
		jugadores.setFont(new Font("Calibri", Font.PLAIN, 18));
		centro.add(jugadores);
		centro.add(new JScrollPane(jugadores));
		jugadores.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		
		centro.add(BorderLayout.CENTER,jugadores);	
		this.add(BorderLayout.CENTER,centro);
		jugadores.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting())
				{
					jugadorActual = jugadores.getSelectedValue();
					numSeleccion = jugadores.getSelectedIndex();
				}
				
			}
		});
		
	}
	
	public void agregarJugadores(String[] nombre)
	{
		if (listModel!= null)
		{
			listModel.removeAllElements();
		}
		if(nombre != null)
		{
			for(int i = 0;i<nombre.length;i++)
			{
				listModel.addElement(nombre[i]);
			}
		}
	}
	
	public void agregarJugador(String nuevo)
	{
		listModel.addElement(nuevo);
	}
	
	public String getJugadorActual()
	{
		return jugadorActual;
	}
	
	public void setJugadorActual(String jugadorActual)
	{
		this.jugadorActual = jugadorActual;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals(AGREGAR))
		{
			ventana.addJugador();
			System.out.println("Aqui no");
		} else if(e.getActionCommand().equals(ELIMINAR))
		{
		
			ventana.eliminarJugador(jugadorActual);
			ventana.setJugadorActual();
			System.out.println( numSeleccion);
			listModel.remove(numSeleccion);
			
		} else if(e.getActionCommand().equals(BUSCAR))
		{
			ventana.buscarJugador();
		}else if(e.getActionCommand().equals(MODIFICAR))
		{
			
		}else if(e.getActionCommand().equals(VER))
		{
			ventana.mostrarJugador(jugadorActual);
		}
		
		

	}
	

			
}
