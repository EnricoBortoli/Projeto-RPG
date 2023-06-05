package rpg.view.paineis;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import rpg.controller.PersonagemController;
import rpg.model.vo.ClasseVO;
import rpg.model.vo.PersonagemVO;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class PainelContinuar extends JPanel {

	private JButton btnSelecionar;
	private JTextArea textArea;
	private JLabel lblTitulo;
	private ArrayList<PersonagemVO> listaPersonagens;
	private JComboBox<PersonagemVO>  cbxPersonagens;
	private PersonagemController personagemController;

	public PainelContinuar() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(19dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(9dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
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
		
		lblTitulo = new JLabel("Selecione um personagem para continuar");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTitulo, "4, 2, center, default");
		
		btnSelecionar = new JButton("Selecionar");
		add(btnSelecionar, "4, 20, right, default");
		
		textArea = new JTextArea();
		add(textArea, "4, 7, 1, 12, fill, fill");
		
		personagemController = new PersonagemController();
		listaPersonagens = personagemController.consultarTodosPersonagens();
		
		cbxPersonagens = new JComboBox(listaPersonagens.toArray());
		cbxPersonagens.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            PersonagemVO personagemSelecionado = (PersonagemVO) cbxPersonagens.getSelectedItem();
		            String selectedText = personagemSelecionado.toString() + " - Experiencia: " + personagemSelecionado.getExpAtual();
		            textArea.setText(selectedText);
		        }
		    }
		});
		add(cbxPersonagens, "4, 6, fill, default");
		cbxPersonagens.setSelectedItem(null);
		
		
		

	}

	public JButton getBtnSelecionar() {
		return btnSelecionar;
	}

	public void setBtnSelecionar(JButton btnSelecionar) {
		this.btnSelecionar = btnSelecionar;
	}

	public JComboBox<PersonagemVO>  getCbxPersonagens() {
		return cbxPersonagens;
	}

	public void setCbxPersonagens(JComboBox<PersonagemVO>  cbxPersonagens) {
		this.cbxPersonagens = cbxPersonagens;
	}

}
