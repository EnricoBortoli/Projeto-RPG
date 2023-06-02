package rpg.view;

import java.awt.EventQueue;
import java.util.Scanner;
import javax.swing.JFrame;

import rpg.controller.PersonagemController;
import rpg.model.exception.CampoInvalidoException;
import rpg.model.exception.personagemMaximosException;
import rpg.model.vo.ClasseVO;
import rpg.model.vo.EquipamentoVO;
import rpg.model.vo.PersonagemVO;
import rpg.view.paineis.PainelCriacao;
import rpg.view.paineis.PainelPrincipal;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private PainelCriacao painelCriacao;
	private JButton btnContinuar;
	private JMenuBar menuBar;
	private PersonagemVO novoPersonagem;
	private PersonagemVO mainPersonagem;
	private PersonagemController personagemController;

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
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPersonagem = new JMenu("Personagem");
		menuBar.add(mnPersonagem);
		menuBar.setVisible(false);
		
		JMenuItem mntmCaracteristicas = new JMenuItem("Caracteristicas");
		mnPersonagem.add(mntmCaracteristicas);
		
		JMenuItem mntmMochila = new JMenuItem("Mochila");
		mnPersonagem.add(mntmMochila);
		
		JMenuItem mntmPoderes = new JMenuItem("Poderes");
		mnPersonagem.add(mntmPoderes);
		
		JMenu mnMapa = new JMenu("Mapa");
		menuBar.add(mnMapa);
		
		JMenuItem mntmMapaRegiao = new JMenuItem("Mapa Regional");
		mnMapa.add(mntmMapaRegiao);
		setContentPane(contentPane);
		
		setTitle("Menu Inicial");
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("82px"),
				ColumnSpec.decode("77px"),
				ColumnSpec.decode("28px"),
				ColumnSpec.decode("56px"),
				ColumnSpec.decode("105px"),},
			new RowSpec[] {
				RowSpec.decode("30px"),
				RowSpec.decode("32px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("53px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("23px"),}));
				
		JLabel lblPrincipal = new JLabel("Bem vindo ao Joguinho");
		lblPrincipal.setFont(new Font("Tahoma", Font.BOLD, 18));
		getContentPane().add(lblPrincipal, "2, 2, 4, 1, center, fill");
				
		JLabel lblOpcoes = new JLabel("Escolha uma opção:");
		lblOpcoes.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(lblOpcoes, "3, 4, 3, 1, left, top");
				
		JLabel lblIconPergaminho = new JLabel("");
		lblIconPergaminho.setIcon(new ImageIcon("C:\\Users\\Necronomicon Digital\\eclipse-workspace\\Projeto_Jogo\\src\\main\\resources\\img\\pergaminho.png"));
		getContentPane().add(lblIconPergaminho, "2, 6, right, fill");
				
		JLabel lblIconEspada = new JLabel("");
		lblIconEspada.setIcon(new ImageIcon("C:\\Users\\Necronomicon Digital\\eclipse-workspace\\Projeto_Jogo\\src\\main\\resources\\img\\espada.png"));
		getContentPane().add(lblIconEspada, "5, 6, center, fill");
				
		btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnContinuar, "2, 8, 2, 1, fill, top");
		
		painelCriacao = new PainelCriacao();
		painelCriacao.getBtnSalvar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novoPersonagem = new PersonagemVO();
				novoPersonagem.setNome(painelCriacao.getTfNome().getText());
				novoPersonagem.setClasse(painelCriacao.getClasseEscolhida());
				novoPersonagem.getEquipamentosDoPersonagem().add(painelCriacao.getEquipamentoEscolhido());
				novoPersonagem.getPoderesDoPersonagem().add(painelCriacao.getPoderEscolhido());
				try {
					personagemController = new PersonagemController();
					mainPersonagem = personagemController.cadastraPersonagem(novoPersonagem);
					JOptionPane.showMessageDialog(null, "Personagem cadastrado com sucesso!");
					PainelPrincipal painelPrincipal = new PainelPrincipal();
					setContentPane(painelPrincipal);
					revalidate();
				}catch(CampoInvalidoException | personagemMaximosException exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage());
				}
			}
		});
		
		JButton btnNovoSave = new JButton("Nova aventura");
		btnNovoSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(painelCriacao);
				revalidate();
			}
		});
		
		getContentPane().add(btnNovoSave, "5, 8, left, top");
	}
	
		public void limparTela(){
			
		}
	}



