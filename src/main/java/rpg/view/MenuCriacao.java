package rpg.view;

import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JFrame;

import rpg.model.vo.ClasseVO;
import rpg.model.vo.EquipamentoVO;
import rpg.model.vo.PersonagemVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MenuCriacao extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private JTextField tfNome;
	
	public static void main(String[] args) {
		try {
			MenuCriacao dialog = new MenuCriacao();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MenuCriacao() {
		
		
		setResizable(false);
		setModal(true);
		setTitle("Menu de Criação");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblTituloCriacao = new JLabel("Selecione suas características");
		lblTituloCriacao.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPanel.add(lblTituloCriacao);
		lblTituloCriacao.setBounds(78, 11, 277, 37);
		
		JLabel lblClasse = new JLabel("Classe:");
		lblClasse.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPanel.add(lblClasse);
		lblClasse.setBounds(30, 102, 46, 14);
		
		final JComboBox comboBoxClasse = new JComboBox();
//		comboBoxClasse.addItemListener(new ItemListener() {
//		    public void itemStateChanged(ItemEvent e) {
//		        if (e.getStateChange() == ItemEvent.SELECTED) {
//		            String classeSelecionada = comboBoxClasse.getSelectedItem().toString();
//		            String descricaoClasse = "";
//		            switch (classeSelecionada) {
//		                case "Paladino":
//		                    descricaoClasse = "O Paladino é um guerreiro divino que usa suas habilidades sagradas para proteger seus aliados e eliminar seus inimigos.";
//		                    break;
//		                case "Mago":
//		                    descricaoClasse = "O Mago é um mestre das artes arcanas que pode invocar poderosos feitiços para combater seus adversários e manipular a realidade.";
//		                    break;
//		                default:
//		                    descricaoClasse = "Selecione uma classe para ver sua descrição.";
//		            }
//		            JOptionPane.showMessageDialog(null, descricaoClasse);
//		        }
//		    }
//		});
		comboBoxClasse.setBounds(151, 98, 137, 22);
		comboBoxClasse.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPanel.add(comboBoxClasse);
		comboBoxClasse.addItem(" ");
		comboBoxClasse.addItem("Paladino");
		comboBoxClasse.addItem("Mago");
		
		JLabel lblPoder = new JLabel("Poder:");
		lblPoder.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPanel.add(lblPoder);
		lblPoder.setBounds(30, 151, 46, 14);
		
		final JComboBox comboBoxPoder = new JComboBox();
//		comboBoxPoder.addItemListener(new ItemListener() {
//		    public void itemStateChanged(ItemEvent e) {
//		        if (e.getStateChange() == ItemEvent.SELECTED) {
//		            String poderSelecionado = comboBoxPoder.getSelectedItem().toString();
//		            String descricaoPoder = "";
//		            switch (comboBoxClasse.getSelectedItem().toString()) {
//			            case"Paladino":
//				            switch (poderSelecionado) {
//				                case "Golpe de Fé":
//				                	descricaoPoder = "Imbuido sua arma com o poder de sua fé inabalavel, aumentando o dano do proximo ataque em : ";
//				                    break;
//				                case "Cura":
//				                	descricaoPoder = "O Mago é um mestre das artes arcanas que pode invocar poderosos feitiços para combater seus adversários e manipular a realidade.";
//				                    break;
//				                default:
//				                	descricaoPoder = "Selecione uma classe para ver sua descrição.";
//				            }
//				            break;
//			            case"Mago":
//			            	
//			            	break;
//		            }
//		            JOptionPane.showMessageDialog(null, descricaoPoder);
//		         }
//		    }
//		});
		comboBoxPoder.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBoxPoder.setBounds(151, 147, 137, 22);
		contentPanel.add(comboBoxPoder);
		comboBoxPoder.addItem(" ");
		comboBoxPoder.addItem("Cura");
		comboBoxPoder.addItem("Raio de Fogo");
		
		JLabel lblEquipamento = new JLabel("Equipamento:");
		lblEquipamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEquipamento.setBounds(30, 197, 85, 14);
		contentPanel.add(lblEquipamento);
		
		final JComboBox comboBoxEquipamento = new JComboBox();
		comboBoxEquipamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBoxEquipamento.setBounds(151, 193, 137, 22);
		contentPanel.add(comboBoxEquipamento);
		comboBoxEquipamento.addItem(" ");
		comboBoxEquipamento.addItem("Espada");
		comboBoxEquipamento.addItem("Maça");
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(30, 59, 46, 14);
		contentPanel.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(151, 56, 204, 20);
		contentPanel.add(tfNome);
		tfNome.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[]  param = new String [6];
				param[0] = tfNome.getText();
				param[1] = comboBoxClasse.getSelectedItem().toString();
				param[2] = comboBoxPoder.getSelectedItem().toString();
				param[3] = comboBoxEquipamento.getSelectedItem().toString();
				
			}
		});
		btnSalvar.setBounds(313, 227, 89, 23);
		contentPanel.add(btnSalvar);
		

	}
}
