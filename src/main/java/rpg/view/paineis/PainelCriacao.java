package rpg.view.paineis;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import rpg.controller.CaracteristicasController;
import rpg.controller.PersonagemController;
import rpg.model.vo.ClasseVO;
import rpg.model.vo.EquipamentoVO;
import rpg.model.vo.PoderVO;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;

public class PainelCriacao extends JPanel {

	private JComboBox<String> cbxPoder;
	private JComboBox<String> cbxEquipamento;
	private JComboBox<String> cbxClasse;
	private ArrayList<ClasseVO> listaClasses;
	private ArrayList<EquipamentoVO> listaEquipamentos;
	private ArrayList<PoderVO> listaPoderes;
	private ClasseVO classeEscolhida;
	private EquipamentoVO equipamentoEscolhido;
	private PoderVO poderEscolhido;
	private JButton btnSalvar;
	private PersonagemController personagemController;
	private CaracteristicasController caracteristicasController;
	private JTextField tfNome;
	private JButton btnDetalhesClasse;
	private JButton btnDetalhesEquipamento;
	private JButton btnDetalhesPoder;

	/**
	 * Create the panel.
	 */
	public PainelCriacao() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(148dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblTituloPainelCriacao = new JLabel("Selecione suas caracteristicas");
		lblTituloPainelCriacao.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblTituloPainelCriacao, "4, 4, 3, 1, center, default");
		
		JLabel lblNome = new JLabel("Nome: ");
		add(lblNome, "4, 8, left, default");
		
		tfNome = new JTextField();
		add(tfNome, "6, 8, fill, default");
		tfNome.setColumns(10);
		
		JLabel lblClasse = new JLabel("Classe: ");
		add(lblClasse, "4, 10, left, default");
		
		cbxClasse = new JComboBox<String>();
		add(cbxClasse, "6, 10, fill, default");
		
		caracteristicasController = new CaracteristicasController();
		
		listaClasses = caracteristicasController.consultarTodasClassesController();
    	for (ClasseVO classe : listaClasses) {
    		cbxClasse.addItem(classe.getNome());
    	}
    	cbxClasse.setSelectedItem(null);
		
		JLabel lblEquipamento = new JLabel("Equipamento: ");
		add(lblEquipamento, "4, 12, right, default");
		
		cbxEquipamento = new JComboBox<String>();
		add(cbxEquipamento, "6, 12, fill, default");
		
		JLabel lblPoder = new JLabel("Poder: ");
		add(lblPoder, "4, 14, left, default");
		
		cbxPoder = new JComboBox<String>();
		add(cbxPoder, "6, 14, fill, default");
		
		cbxClasse.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent e) {
		        cbxEquipamento.removeAllItems();
		        cbxPoder.removeAllItems();
		        cbxEquipamento.setSelectedIndex(-1);
		        cbxPoder.setSelectedIndex(-1);
		        	        
		        for (ClasseVO classe : listaClasses) {
		            if (classe.getNome().equals(cbxClasse.getSelectedItem())) {
		                classeEscolhida = classe;
		            }
		        }
		        
		        listaEquipamentos = caracteristicasController.ConsultaEquipamentoPorClasseController(classeEscolhida.getCdClasse());
		        for (EquipamentoVO equipamento : listaEquipamentos) {
		            cbxEquipamento.addItem(equipamento.getNome());
		            cbxEquipamento.setSelectedItem(null);
		        }
		        
		        listaPoderes = caracteristicasController.ConsultaPoderPorClasseController(classeEscolhida.getCdClasse());
		        for (PoderVO poder : listaPoderes) {
		        	cbxPoder.addItem(poder.getNome());
		        	cbxPoder.setSelectedItem(null);
		        }
		        
		    }
		});
		
		cbxEquipamento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
		    	for (EquipamentoVO equipamento : listaEquipamentos) {
		            if (equipamento.getNome().equals(cbxEquipamento.getSelectedItem())) {
		                equipamentoEscolhido = equipamento;
		            }
		        }     
		    }
		});
		
		cbxPoder.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
		    	for (PoderVO poder : listaPoderes) {
		            if (poder.getNome().equals(cbxPoder.getSelectedItem())) {
		                poderEscolhido = poder;
		            }
		        }     
		    }
		});
		
		btnDetalhesPoder = new JButton("Lupa");
		btnDetalhesPoder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, poderEscolhido.toString());
			}
		});
		add(btnDetalhesPoder, "8, 14");
		
		btnDetalhesClasse = new JButton("Lupa");
		btnDetalhesClasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, classeEscolhida.toString());
			}
		});
		add(btnDetalhesClasse, "8, 10");
		
		btnDetalhesEquipamento = new JButton("Lupa");
		btnDetalhesEquipamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, equipamentoEscolhido.toString());
			}
		});
		add(btnDetalhesEquipamento, "8, 12");
		
		btnSalvar = new JButton("Salvar");
		add(btnSalvar, "6, 20, right, default");

	}

	public JTextField getTfNome() {
		return tfNome;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public ClasseVO getClasseEscolhida() {
		return classeEscolhida;
	}

	public void setClasseEscolhida(ClasseVO classeEscolhida) {
		this.classeEscolhida = classeEscolhida;
	}

	public EquipamentoVO getEquipamentoEscolhido() {
		return equipamentoEscolhido;
	}

	public void setEquipamentoEscolhido(EquipamentoVO equipamentoEscolhido) {
		this.equipamentoEscolhido = equipamentoEscolhido;
	}

	public PoderVO getPoderEscolhido() {
		return poderEscolhido;
	}

	public void setPoderEscolhido(PoderVO poderEscolhido) {
		this.poderEscolhido = poderEscolhido;
	}
	
	

}
