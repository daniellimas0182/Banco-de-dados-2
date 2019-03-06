package internalPanes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Objects.Comunicados;
import Objects.Reunioes;
import bancodados.BancoDados;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
public class opcao05 extends JInternalFrame {
	private JTable table;
	public DefaultTableModel modelo = new DefaultTableModel();
	private String informante;
	
	public opcao05() {
		setClosable(true);
		setTitle("Agenda");
		setBounds(100, 100, 570, 396);
		
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
		
		JLabel lblAlertaDaComunidade = new JLabel("Agenda");
		lblAlertaDaComunidade.setForeground(Color.WHITE);
		lblAlertaDaComunidade.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnConfirmar = new JButton("Confirmar presenca");
		btnConfirmar.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(238, Short.MAX_VALUE)
					.addComponent(lblAlertaDaComunidade)
					.addGap(219))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnConfirmar)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblAlertaDaComunidade)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnConfirmar)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
		table = new JTable(modelo);
		modelo.addColumn("Data");
		modelo.addColumn("Horario");
		modelo.addColumn("Localizacao");
		modelo.addColumn("Assuntos");
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}
	public void carregarTabela() {
		Reunioes dr = new Reunioes();
		for(Reunioes r: BancoDados.consultaReunioes()) {
			modelo.addRow(new Object[]{
				r.getData(),
				r.getHorario(),
				r.getLocalizacao(),
				r.getAssunto()
			});
		}
	}
}
