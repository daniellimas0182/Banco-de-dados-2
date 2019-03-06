package controles;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.util.Calendar;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import bancodados.BancoDados;

public class areaAcesso extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuarioemail;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					areaAcesso frame = new areaAcesso();
					frame.setVisible(true);
					BancoDados.getConexao();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public areaAcesso() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent arg0) {
				BancoDados.fecharConexao();
				dispose();
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(new Color(255, 99, 71));

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE).addGap(22)
						.addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(21, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(33)
						.addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		JLabel lblBemvindoAoDti = new JLabel("Bem-Vindo ao DTI-17");
		lblBemvindoAoDti.setBounds(82, 96, 230, 25);
		lblBemvindoAoDti.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBemvindoAoDti.setForeground(Color.WHITE);

		JLabel lbldesen = new JLabel("Desenvolvido por C\u00E1ssio Elias \r\njuntamente a");
		lbldesen.setBounds(82, 139, 257, 14);
		lbldesen.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbldesen.setForeground(Color.WHITE);

		JLabel lblBancoDeDados = new JLabel("banco de dados 2.");
		lblBancoDeDados.setBounds(82, 189, 101, 14);
		lblBancoDeDados.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBancoDeDados.setForeground(Color.WHITE);

		JButton btnRegistro = new JButton("Registrar-se");
		btnRegistro.setBounds(82, 206, 140, 25);
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Registro().setVisible(true);
			}
		});
		btnRegistro.setForeground(Color.WHITE);
		btnRegistro.setBackground(new Color(255, 127, 80));
		btnRegistro.setBorder(null);
		btnRegistro.setFocusPainted(false);
		panel.setLayout(null);
		panel.add(lblBemvindoAoDti);
		panel.add(lbldesen);
		panel.add(lblBancoDeDados);
		panel.add(btnRegistro);

		JLabel lbl2 = new JLabel("Daniel Limas para a disciplica de");
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl2.setBackground(Color.WHITE);
		lbl2.setForeground(new Color(255, 255, 255));
		lbl2.setBounds(82, 164, 201, 14);
		panel.add(lbl2);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img\\cyber.jpg"));
		label.setBounds(0, 0, 372, 368);
		panel.add(label);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogin.setForeground(Color.WHITE);

		txtUsuarioemail = new JTextField();
		txtUsuarioemail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtUsuarioemail.setText("");
			}
		});
		txtUsuarioemail.setForeground(Color.WHITE);
		txtUsuarioemail.setText("usuario/email");
		txtUsuarioemail.setToolTipText("usuario/email");
		txtUsuarioemail.setBackground(new Color(255, 99, 71));
		txtUsuarioemail.setColumns(10);
		txtUsuarioemail.setBorder(null);

		passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				passwordField.setText("");
			}
		});
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(new Color(255, 99, 71));
		passwordField.setBorder(null);
		passwordField.setText("***********");

		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtUsuarioemail.getText().equals("usuario/email") && passwordField.getText().equals("***********")) {
					JOptionPane.showMessageDialog(null, "Primeiramente informe os dados.");
				}else if(txtUsuarioemail.getText().equals("") && passwordField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Primeiramente informe os dados.");
				}else if(BancoDados.validarLogin(txtUsuarioemail.getText(), passwordField.getText())){
					new telaPrincipal(txtUsuarioemail.getText()).setVisible(true);
					dispose();	
				}else {
					JOptionPane.showMessageDialog(null, "Dados invalidos, verifique as informacoes");
				}
			}
		});

		btnAcessar.setForeground(Color.WHITE);
		btnAcessar.setBackground(new Color(255, 127, 80));
		btnAcessar.setBorder(null);
		btnAcessar.setFocusPainted(false);

		JSeparator separatorUser = new JSeparator();

		JSeparator separatorSenha = new JSeparator();

		JLabel lblEsqueceuSuaSenha = new JLabel("Esqueceu sua senha?");
		lblEsqueceuSuaSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new Recupera().setVisible(true);
			}
		});
		lblEsqueceuSuaSenha.setForeground(Color.CYAN);
		GroupLayout gl_panelLogin = new GroupLayout(panelLogin);
		gl_panelLogin.setHorizontalGroup(gl_panelLogin.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelLogin.createSequentialGroup().addGap(119).addComponent(lblLogin).addContainerGap(148,
						Short.MAX_VALUE))
				.addGroup(gl_panelLogin.createSequentialGroup().addGap(43).addGroup(gl_panelLogin
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(separatorUser, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
						.addComponent(separatorSenha, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
						.addComponent(btnAcessar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
						.addComponent(txtUsuarioemail, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
						.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)).addGap(30))
				.addGroup(gl_panelLogin.createSequentialGroup().addContainerGap(169, Short.MAX_VALUE)
						.addComponent(lblEsqueceuSuaSenha).addGap(96)));
		gl_panelLogin.setVerticalGroup(gl_panelLogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogin.createSequentialGroup().addContainerGap().addComponent(lblLogin).addGap(36)
						.addComponent(txtUsuarioemail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(separatorUser, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
						.addGap(42)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(separatorSenha, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
						.addGap(28).addComponent(btnAcessar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(lblEsqueceuSuaSenha).addContainerGap(38, Short.MAX_VALUE)));
		panelLogin.setLayout(gl_panelLogin);
		contentPane.setLayout(gl_contentPane);
	}
}
