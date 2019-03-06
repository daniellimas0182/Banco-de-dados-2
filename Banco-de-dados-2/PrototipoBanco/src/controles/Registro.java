package controles;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Objects.DadosRegistro;
import Objects.Endereco;
import bancodados.BancoDados;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldRua;
	private JTextField textFieldBairro;
	private JTextField textFieldComple;
	private JTextField textFieldCidade;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	private String comboBoxUFG;
	private int cold;

	public Registro() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 363);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBounds(35, 16, 378, 301);
		panel.setBackground(new Color(255, 99, 71));

		JLabel lblAreaDeRegistro = new JLabel("Area de Registro");
		lblAreaDeRegistro.setBounds(129, 24, 115, 17);
		lblAreaDeRegistro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAreaDeRegistro.setForeground(Color.WHITE);

		JLabel lblNome = new JLabel("Usuario:");
		lblNome.setBounds(22, 71, 45, 13);
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 10));

		textFieldNome = new JTextField();
		textFieldNome.setBounds(71, 67, 260, 20);
		textFieldNome.setColumns(10);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(45, 133, 22, 13);
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblRua.setForeground(Color.WHITE);

		textFieldRua = new JTextField();
		textFieldRua.setBounds(71, 129, 260, 20);
		textFieldRua.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(32, 164, 35, 13);
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblBairro.setForeground(Color.WHITE);

		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(71, 160, 86, 20);
		textFieldBairro.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(159, 164, 71, 13);
		lblComplemento.setForeground(Color.WHITE);
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 10));

		textFieldComple = new JTextField();
		textFieldComple.setBounds(236, 160, 95, 20);
		textFieldComple.setColumns(10);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(31, 195, 36, 13);
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 10));

		JComboBox comboBoxUF = new JComboBox();
		comboBoxUF.setBounds(71, 191, 86, 20);
		comboBoxUF.setBackground(Color.WHITE);
		comboBoxUF.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA",
						"PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" }));
		comboBoxUF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				comboBoxUFG = (String) comboBoxUF.getSelectedItem();
			}
		});

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(193, 195, 37, 13);
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 10));

		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(236, 191, 95, 20);
		textFieldCidade.setColumns(10);

		JButton btnRegistrarse = new JButton("Proseguir");
		btnRegistrarse.setBounds(236, 253, 95, 23);
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cold = Calculo.Calcular(textFieldNome.getText(), textFieldBairro.getText(), textFieldCidade.getText(), textFieldEmail.getText());
				Endereco ed = getDadosEndereco();
				Endereco end = new Endereco();
				end.setRua(ed.getRua());
				end.setBairro(ed.getBairro());
				end.setUf(ed.getUf());
				end.setCidade(ed.getCidade());
				end.setComplemento(ed.getComplemento());
				BancoDados.RegistroEndereUser(end);
				
				DadosRegistro dr = getDadosRegistro();
				DadosRegistro dadosR = new DadosRegistro();
				dadosR.setNome(dr.getNome());
				dadosR.setSenha(dr.getSenha());
				dadosR.setEmail(dr.getEmail());
				dadosR.setCold(cold);
				BancoDados.RegistroUser(dadosR, end);
				/*DadosRegistro dr = getDadosRegistro();
				Mail.enviar(dr.getEmail(), cold);*/
				dispose();
			}
		});
		contentPane.setLayout(null);
		btnRegistrarse.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(lblAreaDeRegistro);
		panel.add(lblEstado);
		panel.add(lblBairro);
		panel.add(lblRua);
		panel.add(lblNome);
		panel.add(textFieldNome);
		panel.add(comboBoxUF);
		panel.add(textFieldBairro);
		panel.add(lblComplemento);
		panel.add(lblCidade);
		panel.add(textFieldComple);
		panel.add(btnRegistrarse);
		panel.add(textFieldCidade);
		panel.add(textFieldRua);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 253, 45, 37);
		lblNewLabel.setIcon(new ImageIcon("img\\safety.png"));
		panel.add(lblNewLabel);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(31, 226, 36, 13);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(71, 222, 260, 20);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblSenha.setBounds(31, 98, 36, 14);
		panel.add(lblSenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(71, 98, 260, 20);
		panel.add(passwordField);

	}
	public Endereco getDadosEndereco() {
		return new Endereco(0, textFieldRua.getText(), textFieldBairro.getText(), comboBoxUFG, textFieldCidade.getText(), textFieldComple.getText());
	}
	
	public DadosRegistro getDadosRegistro() {
		return new DadosRegistro(0, textFieldNome.getText(), passwordField.getText(), textFieldEmail.getText(), cold);
	}
}
