import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import internalPanes.opcao01;
import internalPanes.opcao02;
import internalPanes.opcao03;
import internalPanes.opcao04;

public class telaPrincipal extends JFrame {

	private JPanel contentPane;
	
	private opcao03 op03 = new opcao03();
	private opcao04 op04 = new opcao04();
	private JButton btn01, btn02, btn03,btn04, btn05;
	private JDesktopPane desktopPane;

	public telaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 61, 139));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
				.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
		);
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 453, Short.MAX_VALUE)
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 462, Short.MAX_VALUE)
		);
		desktopPane.setLayout(gl_desktopPane);
		JLabel lblDti = new JLabel("DTI-17");
		lblDti.setBounds(90, 24, 82, 28);
		lblDti.setForeground(new Color(255, 255, 255));
		lblDti.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 63, 238, 2);
		
		btn01 = new JButton("Comunicados");
		btn01.setBounds(0, 83, 258, 46);
		btn01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				desktopPane.setBackground(new Color(102, 102, 255));
				btn01.setBackground(new Color(102, 102, 255));
				contentPane.setBackground(new Color(102, 102, 255));
				btn02.setBackground(new Color(72, 61, 139));
				btn03.setBackground(new Color(72, 61, 139));
				btn04.setBackground(new Color(72, 61, 139));
				btn05.setBackground(new Color(72, 61, 139));

			}
			
		});
		btn01.setForeground(new Color(255, 255, 255));
		btn01.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn01.setIcon(new ImageIcon("img\\home.png"));
		btn01.setBackground(new Color(72, 61, 139));
		btn01.setBorder(null);
		btn01.setFocusPainted(false);
		
		btn02 = new JButton("Reunioes");
		btn02.setBounds(0, 135, 258, 48);
		btn02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.setBackground(new Color(102, 102, 204));
				btn02.setBackground(new Color(102, 102, 204));
				contentPane.setBackground(new Color(102, 102, 204));
				btn01.setBackground(new Color(72, 61, 139));
				btn03.setBackground(new Color(72, 61, 139));
				btn04.setBackground(new Color(72, 61, 139));
				btn05.setBackground(new Color(72, 61, 139));
			}			
		});
		btn02.setIcon(new ImageIcon("img\\gerente.png"));
		btn02.setBackground(new Color(72, 61, 139));
		btn02.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn02.setForeground(new Color(255, 255, 255));
		btn02.setBorder(null);
		btn02.setFocusPainted(false);
		
		btn03 = new JButton("Estatisticas");
		btn03.setIcon(new ImageIcon("img\\estatis.png"));
		btn03.setBounds(0, 189, 258, 45);
		btn03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.setBackground(new Color(102, 102, 153));
				desktopPane.add(op03);
				op03.setVisible(true);
				setPosicaoOp03();
				btn03.setBackground(new Color(102, 102, 153));
				contentPane.setBackground(new Color(102, 102, 153));
				btn01.setBackground(new Color(72, 61, 139));
				btn02.setBackground(new Color(72, 61, 139));
				btn04.setBackground(new Color(72, 61, 139));
				btn05.setBackground(new Color(72, 61, 139));
			}

			private void setPosicaoOp03() {
				op03.setLocation(desktopPane.getWidth()/ 2 - op03.getWidth()/2, desktopPane.getHeight()/2 - op03.getHeight()/2);				
			}
		});
		btn03.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn03.setForeground(new Color(255, 255, 255));
		btn03.setBackground(new Color(72, 61, 139));
		btn03.setBorder(null);
		btn03.setFocusPainted(false);
		
		btn04 = new JButton("Alertas");
		btn04.setIcon(new ImageIcon("img\\alerta.png"));
		btn04.setBounds(0, 240, 258, 46);
		btn04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.setBackground(new Color(102, 102, 102));
				desktopPane.add(op04);
				op04.setVisible(true);
				setPosicaoOp04();
				btn04.setBackground(new Color(102, 102, 102));
				contentPane.setBackground(new Color(102, 102, 102));
				btn02.setBackground(new Color(72, 61, 139));
				btn03.setBackground(new Color(72, 61, 139));
				btn01.setBackground(new Color(72, 61, 139));
				btn05.setBackground(new Color(72, 61, 139));
			}

			private void setPosicaoOp04() {
				op04.setLocation(desktopPane.getWidth()/ 2 - op04.getWidth()/2, desktopPane.getHeight()/2 - op04.getHeight()/2);				
			}
		});
		btn04.setBackground(new Color(72, 61, 139));
		btn04.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn04.setForeground(new Color(255, 255, 255));
		btn04.setBorder(null);
		btn04.setFocusPainted(false);
		
		btn05 = new JButton("OPCAO 05");
		btn05.setBounds(0, 292, 258, 45);
		btn05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.setBackground(new Color(102, 102, 51));
				btn05.setBackground(new Color(102, 102, 51));
				contentPane.setBackground(new Color(102, 102, 51));
				btn02.setBackground(new Color(72, 61, 139));
				btn03.setBackground(new Color(72, 61, 139));
				btn04.setBackground(new Color(72, 61, 139));
				btn01.setBackground(new Color(72, 61, 139));
			}
		});
		btn05.setBackground(new Color(72, 61, 139));
		btn05.setForeground(new Color(255, 255, 255));
		btn05.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn05.setBorder(null);
		btn05.setFocusPainted(false);
		panel.setLayout(null);
		panel.add(lblDti);
		panel.add(separator);
		panel.add(btn01);
		panel.add(btn02);
		panel.add(btn03);
		panel.add(btn04);
		panel.add(btn05);
		contentPane.setLayout(gl_contentPane);
	}
}
