package rpg.view;

import java.awt.EventQueue;
import java.util.Scanner;
import javax.swing.JFrame;

import rpg.model.vo.ClasseVO;
import rpg.model.vo.EquipamentoVO;
import rpg.model.vo.PersonagemVO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		setTitle("Menu Inicial");
		setResizable(false);
		getContentPane().setLayout(null);
				
		JLabel lblPrincipal = new JLabel("Bem vindo ao Joguinho");
		lblPrincipal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPrincipal.setBounds(109, 30, 215, 32);
		getContentPane().add(lblPrincipal);
				
		JLabel lblOpcoes = new JLabel("Escolha uma opção:");
		lblOpcoes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOpcoes.setBounds(159, 73, 116, 14);
		getContentPane().add(lblOpcoes);
				
		JLabel lblIconPergaminho = new JLabel("");
		lblIconPergaminho.setIcon(new ImageIcon("C:\\Users\\Necronomicon Digital\\eclipse-workspace\\Projeto_Jogo\\src\\main\\resources\\img\\pergaminho.png"));
		lblIconPergaminho.setBounds(109, 104, 50, 53);
		getContentPane().add(lblIconPergaminho);
				
		JLabel lblIconEspada = new JLabel("");
		lblIconEspada.setIcon(new ImageIcon("C:\\Users\\Necronomicon Digital\\eclipse-workspace\\Projeto_Jogo\\src\\main\\resources\\img\\espada.png"));
		lblIconEspada.setBounds(268, 104, 55, 53);
		getContentPane().add(lblIconEspada);
				
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnContinuar.setBounds(82, 168, 105, 23);
		getContentPane().add(btnContinuar);
				
		JButton btnNovoSave = new JButton("Nova aventura");
		btnNovoSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuCriacao criacao = new MenuCriacao();
				criacao.setVisible(true);
			}
		});
		btnNovoSave.setBounds(243, 168, 105, 23);
		getContentPane().add(btnNovoSave);
	}
	}



