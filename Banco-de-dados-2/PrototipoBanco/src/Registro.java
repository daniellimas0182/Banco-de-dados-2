import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldRua;
	private JTextField textFieldBairro;
	private JTextField textFieldComple;
	private JTextField textFieldCIdade;
	private JTextField textFieldEmail;

	public Registro() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 362);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 16, 378, 301);
		panel.setBackground(new Color(255, 99, 71));
		
		JLabel lblAreaDeRegistro = new JLabel("Area de Registro");
		lblAreaDeRegistro.setBounds(129, 11, 115, 17);
		lblAreaDeRegistro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAreaDeRegistro.setForeground(Color.WHITE);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(36, 58, 31, 13);
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(71, 54, 260, 20);
		textFieldNome.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(45, 96, 22, 13);
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblRua.setForeground(Color.WHITE);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(71, 92, 260, 20);
		textFieldRua.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(32, 134, 35, 13);
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblBairro.setForeground(Color.WHITE);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(71, 130, 86, 20);
		textFieldBairro.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(161, 134, 71, 13);
		lblComplemento.setForeground(Color.WHITE);
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		textFieldComple = new JTextField();
		textFieldComple.setBounds(236, 130, 95, 20);
		textFieldComple.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(31, 172, 36, 13);
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JComboBox comboBoxUF = new JComboBox();
		comboBoxUF.setBounds(71, 168, 86, 20);
		comboBoxUF.setBackground(Color.WHITE);
		comboBoxUF.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(195, 172, 37, 13);
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		textFieldCIdade = new JTextField();
		textFieldCIdade.setBounds(236, 168, 95, 20);
		textFieldCIdade.setColumns(10);
		
		JButton btnRegistrarse = new JButton("Proseguir");
		btnRegistrarse.setBounds(236, 253, 95, 23);
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Calculo.Calcular(textFieldNome.getText(), textFieldBairro.getText(), textFieldCIdade.getText(), textFieldEmail.getText());
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
		panel.add(textFieldCIdade);
		panel.add(textFieldRua);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img\\safety.png"));
		lblNewLabel.setBounds(10, 253, 45, 37);
		panel.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblEmail.setBounds(21, 205, 46, 14);
		panel.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(71, 202, 260, 20);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
	}
}
