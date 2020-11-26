package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension din;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					fondito d = new fondito ("/visual/ty.jpg");
					frame.getContentPane().add(d);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("PRODACOM");
		
		setBackground(UIManager.getColor("Button.focus"));
		setForeground(UIManager.getColor("Button.focus"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/iconos/tecno.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 411);
		din = getToolkit().getScreenSize();  
		super.setSize(din.width,din.height-45);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("Button.focus"));
		menuBar.setForeground(UIManager.getColor("Button.focus"));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("Facturar");
		mnNewMenu_1.setIcon(new ImageIcon(Principal.class.getResource("/iconos/factura.png")));
		mnNewMenu_1.setForeground(SystemColor.textHighlight);
		mnNewMenu_1.setBackground(UIManager.getColor("Button.focus"));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Facturaci\u00F3n");
		mntmNewMenuItem_1.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_1.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_1.setIcon(new ImageIcon(Principal.class.getResource("/iconos/name.png")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facturacion aux = new Facturacion();
				aux.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Listado Facturas");
		mntmNewMenuItem_2.setIcon(new ImageIcon(Principal.class.getResource("/iconos/factu.png")));
		mntmNewMenuItem_2.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_2.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoFacturas aux = new ListadoFacturas();
				aux.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu = new JMenu("Componentes");
		mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/iconos/compo.png")));
		mnNewMenu.setBackground(UIManager.getColor("Button.focus"));
		mnNewMenu.setForeground(SystemColor.textHighlight);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ingreso");
		mntmNewMenuItem.setIcon(new ImageIcon(Principal.class.getResource("/iconos/ingreso.png")));
		mntmNewMenuItem.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem.setBackground(UIManager.getColor("Button.focus"));
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngresoComponentes a = new IngresoComponentes();
				a.setVisible(true);
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Listado Componente");
		mntmNewMenuItem_4.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_4.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_4.setIcon(new ImageIcon(Principal.class.getResource("/iconos/hu.png")));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoComponentes aux = new ListadoComponentes(null,0);
				aux.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("Cliente");
		mnNewMenu_2.setIcon(new ImageIcon(Principal.class.getResource("/iconos/user.png")));
		mnNewMenu_2.setForeground(SystemColor.textHighlight);
		mnNewMenu_2.setBackground(UIManager.getColor("Button.focus"));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listado Cliente");
		mntmNewMenuItem_3.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_3.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_3.setIcon(new ImageIcon(Principal.class.getResource("/iconos/clien.png")));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoClientes aux = new ListadoClientes();
				aux.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_3 = new JMenu("Combos");
		mnNewMenu_3.setBackground(UIManager.getColor("Button.focus"));
		mnNewMenu_3.setForeground(SystemColor.textHighlight);
		mnNewMenu_3.setIcon(new ImageIcon(Principal.class.getResource("/iconos/com.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Registrar Combo");
		mntmNewMenuItem_5.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_5.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_5.setIcon(new ImageIcon(Principal.class.getResource("/iconos/lip.png")));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegCombo aux = new RegCombo();
				aux.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Listado Combo");
		mntmNewMenuItem_6.setIcon(new ImageIcon(Principal.class.getResource("/iconos/ju.png")));
		mntmNewMenuItem_6.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_6.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoComponentes aux = new ListadoComponentes(null,1);
				aux.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_4 = new JMenu("Proveedor");
		mnNewMenu_4.setIcon(new ImageIcon(Principal.class.getResource("/iconos/compras.png")));
		mnNewMenu_4.setForeground(SystemColor.textHighlight);
		mnNewMenu_4.setBackground(UIManager.getColor("Button.focus"));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Registrar Proveedor");
		mntmNewMenuItem_7.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_7.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_7.setIcon(new ImageIcon(Principal.class.getResource("/iconos/list.png")));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegProveedores aux = new RegProveedores();
				aux.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Listado Proveedores");
		mntmNewMenuItem_8.setIcon(new ImageIcon(Principal.class.getResource("/iconos/name.png")));
		mntmNewMenuItem_8.setForeground(SystemColor.textHighlight);
		mntmNewMenuItem_8.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoProveedores aux = new ListadoProveedores();
				aux.setVisible(true);
				
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_8);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("Button.focus"));
		contentPane.setBackground(UIManager.getColor("Button.focus"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
	}

}
