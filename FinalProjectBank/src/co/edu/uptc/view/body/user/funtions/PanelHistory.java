package co.edu.uptc.view.body.user.funtions;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import co.edu.uptc.view.Constants;
import co.edu.uptc.view.body.login.ShapedPanelLoginUI;

public class PanelHistory extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable history;
	private JScrollPane scroll;
	private JLabel lblNoTransactions;
	
	public PanelHistory() {
		setUI(new ShapedPanelLoginUI(Constants.COLORPANELFUNTION));
		setBorder(new EmptyBorder(35, 33, 35, 33));
		initComponents();
	}

	private void initComponents() {
		DefaultTableModel model = new DefaultTableModel();
		String[] dates = new String[3];
		dates[0] = "2022-21-10";
		dates[1] = "2022-21-10";
		dates[2] = "2022-21-10";
		model.addColumn("Fecha");
		model.addColumn("Motivo");
		model.addColumn("Cantidad");
		String[] motivo = new String[3];
		motivo[0] = "Egreso";
		motivo[1] = "Ingreso";
		motivo[2] = "Retiro";
		String[] amounts = new String[3];
		amounts[0] = "2000";
		amounts[1] = "500000";
		amounts[2] = "100000";
		model.addRow(motivo);
		model.addRow(dates);
		model.addRow(amounts);
		history = new JTable(model);
		history.setBackground(Constants.COLORPANELLOGIN);
		history.setAlignmentX(SwingConstants.CENTER);
		styleTable();
		setLayout(new GridBagLayout());
		scroll = new JScrollPane(history, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(240, 355));
		GridBagConstraints gbc = new GridBagConstraints();
		add(scroll, gbc);
		scroll.setVisible(false);
		
		lblNoTransactions = new JLabel("<html><body style=\"text-align: center\">"
				+ "No se han registrado movimientos<br>en esta cuenta hasta el momento"
				+ "</body></html>");
		lblNoTransactions.setFont(Constants.FONTNAMEUSER);
		add(lblNoTransactions, gbc);
	}
	
	public void styleTable() {
		JTableHeader jth = history.getTableHeader();
		jth.setDefaultRenderer(new TableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				JComponent jc = null;
				jc = new JLabel((String) value);
				((JLabel)jc).setHorizontalAlignment(SwingConstants.CENTER);
		        ((JLabel)jc).setSize(jc.getWidth()+5, jc.getHeight()+10);   
		        ((JLabel)jc).setPreferredSize( new Dimension(jc.getWidth()+5, jc.getHeight()+10));
		        jc.setFont(Constants.FONTNORMAL);
		        jc.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, Color.LIGHT_GRAY));
		        jc.setOpaque(true);
				jc.setBackground(Constants.GREEN);
				jc.setForeground(Color.WHITE);
				jc.setToolTipText("Tabla de Resultados");
				return jc;
			}
		});
		history.setTableHeader(jth);
	}

}
