package rpg.view.paineis;

import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import rpg.controller.CaracteristicasController;
import rpg.model.vo.PersonagemVO;
import rpg.model.vo.RegiaoVO;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PainelPrincipal extends JPanel {

	private JRadioButton rdbtnTaverna;
	private JRadioButton rdbtnRuinas;
	private JRadioButton rdbtnTundra;
	private JRadioButton rdbtnCaverna;
	private JTextArea textArea;
	private JButton btnViajar;
	private final ButtonGroup locais = new ButtonGroup();
	private ArrayList<RegiaoVO> listaRegioes;
	private CaracteristicasController caracteristicaController;

	public PainelPrincipal() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(19dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(45dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(52dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(22dlu;default)"),
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
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		caracteristicaController = new CaracteristicasController();
		listaRegioes = caracteristicaController.consultaRegioes();
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		add(textArea, "4, 6, 9, 11, fill, fill");
		
		rdbtnTaverna = new JRadioButton("Taverna");
		rdbtnTaverna.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            String selectedText = "";
		            for(RegiaoVO regiao : listaRegioes) {
		            	if(regiao.getNome().equals("Taverna")) {
		            		selectedText +=  regiao.getDescricao();
		            	}
		            }
		            textArea.setText(selectedText);
		        }
		    }
		});
		add(rdbtnTaverna, "4, 4, left, default");
		
		rdbtnRuinas = new JRadioButton("Ruinas");
		add(rdbtnRuinas, "6, 4");
		
		rdbtnTundra = new JRadioButton("Tundra");
		add(rdbtnTundra, "8, 4");
		
		rdbtnCaverna = new JRadioButton("Cavernas");
		add(rdbtnCaverna, "10, 4");
			
		btnViajar = new JButton("Viajar");
		add(btnViajar, "12, 18");

		locais.add(rdbtnTaverna);
		locais.add(rdbtnRuinas);
		locais.add(rdbtnTundra);
		locais.add(rdbtnCaverna);
	}

	public JButton getBtnViajar() {
		return btnViajar;
	}

	public void setBtnViajar(JButton btnViajar) {
		this.btnViajar = btnViajar;
	}

	
}
