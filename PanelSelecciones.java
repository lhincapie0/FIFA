package interfaz;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelSelecciones extends JPanel implements ActionListener {
	
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
	
	private JPanel centro;
	private JList<String> paises;
	private JPanel listaSelecciones;
	private DefaultListModel<String>  listModel;
	
	private String seleccionActual;
	private int numSeleccion;
	
	public PanelSelecciones(VentanaPrincipal v)
	{
		
		seleccionActual = "";
		ventana = v;
		setLayout(new BorderLayout());
		this.setToolTipText("Selecciones");
		this.setBackground(Color.WHITE);

		Font fuente = new Font("Calibri", Font.BOLD, 15);
		setBorder(BorderFactory.createLineBorder(Color.gray));
		
		JPanel tit = new JPanel((LayoutManager) new FlowLayout(FlowLayout.CENTER));
		tit.setBackground(Color.WHITE);
		tit.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		JLabel selecciones = new JLabel("Selecciones");
		selecciones.setFont(new Font("Calibri", Font.BOLD, 20 ));
		selecciones.setForeground(new Color(0, 127, 255));
		selecciones.setBackground(Color.WHITE);
		tit.add(selecciones);
		this.add(BorderLayout.NORTH, tit);
		
		
		listaSelecciones = new JPanel();
		
		JPanel botones = new JPanel();
		botones.setBackground(Color.WHITE);
		botones.setLayout(new GridLayout(1,4));
		
		
		
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
		this.add(BorderLayout.SOUTH, botones);
		JPanel centro = new JPanel();
		centro.setLayout(new BorderLayout());
		
	
		
		String[] nombres = ventana.mostrarSelecciones();
		
		listModel = new DefaultListModel<>();
	
		if(nombres != null) {
			for(int i = 0; i<nombres.length; i++)
			{
				listModel.addElement(nombres[i]);
			}
		}
		
		paises = new JList<String>(listModel);
		
		paises.setFont(new Font("Calibri", Font.PLAIN, 18));
		centro.add(paises);
		centro.add(new JScrollPane(paises));
		paises.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		paises.setFocusable(true);
		
		centro.add(BorderLayout.CENTER,paises);	
		this.add(BorderLayout.CENTER,centro);
		paises.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting())
				{
					seleccionActual = paises.getSelectedValue();
					numSeleccion = paises.getSelectedIndex();
					System.out.println(seleccionActual);  
					System.out.println(numSeleccion);
					//ventana.mostrarJugadores(seleccionActual);
				}
			
				
			}
		});
		
		
		
	}
	
	public void agregar(String nombre)
	{
		listModel.addElement(nombre);
	}
	
	public String getSeleccionActual()
	{
		return seleccionActual;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(AGREGAR))
		{
			ventana.agregarSeleccion();
		} else if(e.getActionCommand().equals(ELIMINAR))
		{
			ventana.eliminarSeleccion(seleccionActual);
			listModel.remove(numSeleccion);
			
			} else if(e.getActionCommand().equals(BUSCAR))
		{
			ventana.buscarSeleccion();
		}else if(e.getActionCommand().equals(MODIFICAR))
		{
			ventana.modificarSeleccion(seleccionActual);
		} else if(e.getActionCommand().equals(VER))
		{
			ventana.mostrarJugadores(seleccionActual);
		}
		
	}
	
	
	
	
	
	
	
	
	
}
	

