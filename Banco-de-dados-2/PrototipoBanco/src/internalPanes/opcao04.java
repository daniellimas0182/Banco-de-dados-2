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
import Objects.DadosRegistro;
import bancodados.BancoDados;
/*Aquisicao de equipamentos de segurança online opcao 5*/
public class opcao04 extends JInternalFrame {
	private JTable table;
	public DefaultTableModel modelo = new DefaultTableModel();
	private String informante;
	
	public opcao04() {
		setClosable(true);
		setTitle("Area de alertas");
		setBounds(100, 100, 570, 379);
		
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
		
		JLabel lblAlertaDaComunidade = new JLabel("Area de Alertas");
		lblAlertaDaComunidade.setForeground(Color.WHITE);
		lblAlertaDaComunidade.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(197, Short.MAX_VALUE)
					.addComponent(lblAlertaDaComunidade)
					.addGap(182))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(lblAlertaDaComunidade)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		
		table = new JTable(modelo);
		modelo.addColumn("Informante");
		modelo.addColumn("Comunicado");
		modelo.addColumn("Descricao");
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}
	public void carregarTabela() {
		DadosRegistro dr = new DadosRegistro();
		for(Comunicados c: BancoDados.consultas()) {
			modelo.addRow(new Object[]{
				c.getNome(),
				c.getComunicado(),
				c.getDescricao()
			});
		}
	}
}
