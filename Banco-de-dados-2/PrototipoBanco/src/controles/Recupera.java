package controles;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Recupera extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSenha;
	private JTextField textFieldCold;

	public Recupera() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 99, 71));
		panel.setBounds(10, 11, 424, 249);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(69, 73, 46, 14);
		panel.add(lblEmail);

		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(111, 71, 227, 20);
		panel.add(textFieldSenha);
		textFieldSenha.setColumns(10);

		JLabel lblRecuperarSenha = new JLabel("Recuperar Senha");
		lblRecuperarSenha.setForeground(new Color(255, 255, 255));
		lblRecuperarSenha.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblRecuperarSenha.setBounds(137, 11, 153, 20);
		panel.add(lblRecuperarSenha);

		JLabel lblC = new JLabel("Cold:");
		lblC.setForeground(new Color(255, 255, 255));
		lblC.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblC.setBounds(69, 133, 39, 14);
		panel.add(lblC);

		textFieldCold = new JTextField();
		textFieldCold.setBounds(111, 131, 227, 20);
		panel.add(textFieldCold);
		textFieldCold.setColumns(10);

		JButton btnRecuperar = new JButton("Recuperar");
		btnRecuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Senha enviada para o e-mail cadastrado!");
				dispose();
			}
		});
		btnRecuperar.setBackground(new Color(255, 255, 255));
		btnRecuperar.setBounds(223, 192, 115, 23);
		panel.add(btnRecuperar);
	}
}
