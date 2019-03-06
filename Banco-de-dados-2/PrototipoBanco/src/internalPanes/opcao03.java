package internalPanes;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class opcao03 extends JInternalFrame {
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();

	public opcao03() {
		setClosable(true);
		setTitle("Opcao 03");
		setBounds(100, 100, 563, 379);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 102));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblAreasOndeO = new JLabel("Areas onde o indice de ocorrencia de atividades");
		lblAreasOndeO.setForeground(new Color(255, 255, 255));
		lblAreasOndeO.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblIlicitas = new JLabel("ilicitas e maior.");
		lblIlicitas.setForeground(new Color(255, 255, 255));
		lblIlicitas.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnGerarRelatorio = new JButton("Gerar Relatorio");
		btnGerarRelatorio.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(46, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(29))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnGerarRelatorio)
							.addGap(204))))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(106, Short.MAX_VALUE)
					.addComponent(lblAreasOndeO)
					.addGap(96))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(205)
					.addComponent(lblIlicitas)
					.addContainerGap(223, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAreasOndeO, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblIlicitas)
					.addGap(45)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnGerarRelatorio)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
		table = new JTable(model);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(34, 139, 34), new Color(34, 139, 34), new Color(34, 139, 34), new Color(34, 139, 34)));
		scrollPane.setViewportView(table);
		model.addColumn("Local");
		model.addColumn("Pontuacao");
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}
}
