package internalPanes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Objects.Endereco;
import Objects.Reunioes;
import bancodados.BancoDados;

public class opcao02 extends JInternalFrame {
	private JTextField textFieldAssunto;
	private JTextField textFieldLocal;

	public opcao02(String user) {
		setClosable(true);
		setTitle("Opcao 02");
		setBounds(100, 100, 503, 391);
		
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
		
		JLabel lblAgendamentoDeReunioes = new JLabel("Agendamento de reunioes");
		lblAgendamentoDeReunioes.setBounds(105, 11, 290, 36);
		lblAgendamentoDeReunioes.setForeground(Color.WHITE);
		lblAgendamentoDeReunioes.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblAssunto = new JLabel("Assunto: ");
		lblAssunto.setBounds(46, 91, 59, 14);
		lblAssunto.setForeground(Color.WHITE);
		lblAssunto.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textFieldAssunto = new JTextField();
		textFieldAssunto.setBounds(111, 89, 311, 20);
		textFieldAssunto.setColumns(10);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(72, 135, 33, 14);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setForeground(Color.WHITE);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setBounds(255, 135, 49, 14);
		lblHorario.setForeground(Color.WHITE);
		lblHorario.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JFormattedTextField formattedTextFieldHorario = new JFormattedTextField();
		formattedTextFieldHorario.setBounds(309, 133, 113, 20);
		
		JFormattedTextField formattedTextFieldData = new JFormattedTextField();
		formattedTextFieldData.setBounds(111, 133, 139, 20);
		
		JLabel lblLocal = new JLabel("Localizacao:");
		lblLocal.setBounds(33, 179, 72, 14);
		lblLocal.setForeground(Color.WHITE);
		lblLocal.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textFieldLocal = new JTextField();
		textFieldLocal.setBounds(111, 177, 139, 20);
		textFieldLocal.setColumns(10);
		
		JLabel lblAssuntos = new JLabel("Descricao:");
		lblAssuntos.setBounds(42, 230, 61, 14);
		lblAssuntos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAssuntos.setForeground(Color.WHITE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(107, 215, 315, 79);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		panel.setLayout(null);
		panel.add(lblAgendamentoDeReunioes);
		panel.add(lblAssunto);
		panel.add(textFieldAssunto);
		panel.add(lblData);
		panel.add(formattedTextFieldData);
		panel.add(lblHorario);
		panel.add(formattedTextFieldHorario);
		panel.add(lblLocal);
		panel.add(textFieldLocal);
		panel.add(lblAssuntos);
		panel.add(scrollPane);
		
		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.setBackground(Color.WHITE);
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reunioes re = getDadosReunioes();
				Reunioes r = new Reunioes();
				r.setData(re.getData());
				r.setHorario(re.getHorario());
				r.setLocalizacao(re.getLocalizacao());
				r.setAssunto(re.getAssunto());
				BancoDados.registroReuniao(r, user);
				dispose();
			}

			private Reunioes getDadosReunioes() {
				return new Reunioes(0, formattedTextFieldData.getText(), formattedTextFieldHorario.getText(), textFieldLocal.getText(), textFieldAssunto.getText());
			}
		});
		btnAgendar.setBounds(333, 305, 89, 23);
		panel.add(btnAgendar);
		getContentPane().setLayout(groupLayout);

	}
}
