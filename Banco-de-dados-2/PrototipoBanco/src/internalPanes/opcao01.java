package internalPanes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Objects.Comunicados;
import Objects.Localizacao;
import bancodados.BancoDados;

public class opcao01 extends JInternalFrame {
	private JTextField textFieldComplemento;
	private JTextField textFieldRua;
	private String comboBoxC, comboBoxM, comboBoxH;
	private JTextArea textArea;

	public opcao01(String user) {
		setTitle("Opcao 01");
		setClosable(true);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 567, 437);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 102));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabelAlerta = new JLabel("Area de Comunicados");
		lblNewLabelAlerta.setBounds(166, 11, 215, 31);
		lblNewLabelAlerta.setForeground(Color.WHITE);
		lblNewLabelAlerta.setFont(new Font("Sylfaen", Font.BOLD, 20));
		
		JComboBox comboBoxComuni = new JComboBox();
		comboBoxComuni.setBounds(141, 80, 314, 20);
		comboBoxComuni.setBackground(Color.WHITE);
		comboBoxComuni.setModel(new DefaultComboBoxModel(new String[] {"", "Atividade suspeita", "Assalto a mao armada", "outros"}));
		comboBoxComuni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				comboBoxC = (String) comboBoxComuni.getSelectedItem();
			}
		});
		
		JLabel lblNewLabel_1Comuni = new JLabel("Comunicado:\r\n");
		lblNewLabel_1Comuni.setBounds(52, 80, 79, 19);
		lblNewLabel_1Comuni.setForeground(Color.WHITE);
		lblNewLabel_1Comuni.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblMoradores = new JLabel("Moradores:");
		lblMoradores.setBounds(62, 120, 69, 22);
		lblMoradores.setForeground(Color.WHITE);
		lblMoradores.setBackground(Color.BLACK);
		lblMoradores.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox comboBoxMoradores = new JComboBox();
		comboBoxMoradores.setBounds(141, 122, 314, 20);
		//comboBoxMoradores.setModel(new DefaultComboBoxModel(new String[] {"", "Todos moradores", "Morador 01", "Morador 02", "Morador 03", "Morador 04"}));
		DefaultComboBoxModel defaultComboBox = new DefaultComboBoxModel(BancoDados.populaMoradores().toArray());
		comboBoxMoradores.setModel(defaultComboBox);
		comboBoxMoradores.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				comboBoxM = (String) comboBoxMoradores.getSelectedItem();
			}
		});
		comboBoxMoradores.setBackground(Color.WHITE);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Localizacao lcl = getDadosLocali();
				Localizacao local = new Localizacao();
				local.setRua(lcl.getRua());
				local.setComplemento(lcl.getComplemento());
				local.setPonto(lcl.getPonto());
				BancoDados.RegistroLocalizacao(local);
				
				Comunicados cm = getDadosComuni();
				Comunicados c = new Comunicados();
				c.setNome(cm.getNome());
				c.setComunicado(cm.getComunicado());
				c.setMoradores(cm.getMoradores());
				c.setHorasDispo(cm.getHorasDispo());
				c.setDescricao(cm.getDescricao());
				BancoDados.registroComuni(c, local, user);
				dispose();
			}

			private Comunicados getDadosComuni() {
				return new Comunicados(0, user, comboBoxC, comboBoxM, comboBoxH, textArea.getText());
			}

			private Localizacao getDadosLocali() {
				return new Localizacao(0, textFieldRua.getText(), textFieldComplemento.getText(), 1);
			}
		});
		btnEnviar.setBounds(258, 347, 87, 27);
		btnEnviar.setBackground(Color.WHITE);
		
		JLabel lblAninomato = new JLabel("Aninomato:");
		lblAninomato.setBounds(59, 169, 72, 15);
		lblAninomato.setForeground(Color.WHITE);
		lblAninomato.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JCheckBox chckbxMarqueAqui = new JCheckBox("Marque aqui");
		chckbxMarqueAqui.setForeground(Color.BLACK);
		chckbxMarqueAqui.setBounds(141, 169, 106, 21);
		chckbxMarqueAqui.setBackground(Color.WHITE);
		
		JLabel lblDescricao = new JLabel("Descricao:");
		lblDescricao.setBounds(70, 264, 61, 15);
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescricao.setForeground(Color.WHITE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(141, 259, 314, 77);
		
		JLabel lblTempo = new JLabel("Horas disponivel:");
		lblTempo.setBounds(253, 169, 104, 15);
		lblTempo.setForeground(new Color(255, 255, 255));
		lblTempo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox comboBoxHrs = new JComboBox();
		comboBoxHrs.setBounds(367, 167, 88, 20);
		comboBoxHrs.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		comboBoxHrs.setBackground(new Color(255, 255, 255));
		comboBoxHrs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				comboBoxH = (String) comboBoxHrs.getSelectedItem();
			}
		});
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		panel.setLayout(null);
		panel.add(lblTempo);
		panel.add(comboBoxHrs);
		panel.add(lblNewLabelAlerta);
		panel.add(lblNewLabel_1Comuni);
		panel.add(comboBoxComuni);
		panel.add(lblDescricao);
		panel.add(lblAninomato);
		panel.add(lblMoradores);
		panel.add(scrollPane);
		panel.add(chckbxMarqueAqui);
		panel.add(comboBoxMoradores);
		panel.add(btnEnviar);
		
		JLabel lblLocalizacao = new JLabel("Rua:");
		lblLocalizacao.setForeground(Color.WHITE);
		lblLocalizacao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLocalizacao.setBounds(103, 205, 28, 14);
		panel.add(lblLocalizacao);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblComplemento.setForeground(Color.WHITE);
		lblComplemento.setBounds(280, 205, 89, 14);
		panel.add(lblComplemento);
		
		textFieldComplemento = new JTextField();
		textFieldComplemento.setBounds(369, 203, 86, 20);
		panel.add(textFieldComplemento);
		textFieldComplemento.setColumns(10);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(141, 203, 106, 20);
		panel.add(textFieldRua);
		textFieldRua.setColumns(10);
		getContentPane().setLayout(groupLayout);

	}
	
	public void verificaRua() {
		
	}
}
