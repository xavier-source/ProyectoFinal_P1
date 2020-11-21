package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import logico.Cliente;
import logico.Persona;
import logico.Prodacom;


import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ListadoClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnBuscar;
	private JTextField txtBusqueda;
	private JTable table;
	public static DefaultTableModel modelo;
	public static Object[] fila;
	private static Cliente aux = null;
	private JButton btnCrear;
	private JButton btnSeleccionar;
	private int boton = 1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public ListadoClientes() {
		setTitle("Listado Clientes");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 622, 413);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(0, 0, 594, 47);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					btnBuscar = new JButton("Buscar");
					btnBuscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(boton==1) {
								boton=0;
								txtBusqueda.setVisible(true);
								btnBuscar.setText("");
								btnBuscar.setIcon(new ImageIcon(ListadoClientes.class.getResource("/iconos/btnEliminarIcono.png")));
							
							}else {
								boton=1;
								txtBusqueda.setVisible(false);
								txtBusqueda.setText("");
								btnBuscar.setText("Buscar");
								btnBuscar.setIcon(new ImageIcon(ListadoClientes.class.getResource("/iconos/btnBuscar.png")));
							}
						}
					});
					btnBuscar.setIcon(new ImageIcon(ListadoClientes.class.getResource("/iconos/btnBuscar.png")));
					btnBuscar.setBackground(SystemColor.control);
					btnBuscar.setBounds(403, 3, 128, 34);
					panel_1.add(btnBuscar);
				}
				{
					txtBusqueda = new JTextField();
					txtBusqueda.addKeyListener(new KeyAdapter() {
						@Override
						public void keyPressed(KeyEvent e) {
							DefaultTableModel mode = (DefaultTableModel)table.getModel();
							TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(mode);
							table.setRowSorter(tr);
							tr.setRowFilter(RowFilter.regexFilter(txtBusqueda.getText().trim()));
						}
					});
					txtBusqueda.setBounds(0, 0, 368, 41);
					panel_1.add(txtBusqueda);
					txtBusqueda.setColumns(10);
					txtBusqueda.setVisible(false);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(0, 49, 594, 259);
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					panel_1.add(scrollPane, BorderLayout.CENTER);
					{
						modelo = new DefaultTableModel();
						String[] columns = {"Cedula","Nombre","Telefono","Direccion"}; 
						modelo.setColumnIdentifiers(columns);
						table = new JTable();
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int seleccion = table.getSelectedRow();
								int modelrow = table.convertRowIndexToModel(seleccion);
								if(seleccion!=-1){
									btnSeleccionar.setEnabled(true);
									btnCrear.setEnabled(false);
									aux = Prodacom.getInstance().buscarCliente((String)modelo.getValueAt(modelrow, 0));
									
								}else{	
									btnSeleccionar.setEnabled(false);
									btnCrear.setEnabled(true);
									}
								
							}
						});
						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						table.setModel(modelo);
						scrollPane.setViewportView(table);
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCrear = new JButton("Nuevo Cliente");
				btnCrear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						RegCliente a = new RegCliente();
						a.setVisible(true);
						
					}
				});
				buttonPane.add(btnCrear);
			}
			{
				btnSeleccionar = new JButton("Seleccionar");
				btnSeleccionar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Facturacion.CargarCliente(aux);
						dispose();
					}
				});
				btnSeleccionar.setEnabled(false);
				btnSeleccionar.setActionCommand("OK");
				buttonPane.add(btnSeleccionar);
				getRootPane().setDefaultButton(btnSeleccionar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		CargarTabla();
	}

	private void CargarTabla() {
		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];
		for(Persona p : Prodacom.getInstance().getPersonas()){
			if(p instanceof Cliente) {
			Cliente c = (Cliente)p;	
			fila[0]=c.getCedula();
			fila[1]=c.getNombre();
			fila[2]=c.getTelefono();
			fila[3]=c.getDireccion();
			modelo.addRow(fila);
		}
		
	}
	}

}
