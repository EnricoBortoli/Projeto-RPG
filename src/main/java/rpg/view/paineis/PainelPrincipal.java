package rpg.view.paineis;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

public class PainelPrincipal extends JPanel {

	private JRadioButton rdbtnTaverna;
	private JRadioButton rdbtnRuinas;
	private JRadioButton rdbtnTundra;
	private JRadioButton rdbtnCaverna;
	private JTextArea textArea;
	private JButton btnViajar;
	private final ButtonGroup locais = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public PainelPrincipal() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(19dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(45dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(52dlu;default)"),
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
		
		rdbtnTaverna = new JRadioButton("Taverna");
		add(rdbtnTaverna, "4, 4, left, default");
		
		rdbtnRuinas = new JRadioButton("Ruinas");
		add(rdbtnRuinas, "6, 4");
		
		rdbtnTundra = new JRadioButton("Tundra");
		add(rdbtnTundra, "8, 4");
		
		rdbtnCaverna = new JRadioButton("Cavernas");
		add(rdbtnCaverna, "10, 4");
		
		textArea = new JTextArea();
		add(textArea, "4, 6, 9, 11, fill, fill");
			
		btnViajar = new JButton("Viajar");
		add(btnViajar, "12, 18");

		locais.add(rdbtnTaverna);
		locais.add(rdbtnRuinas);
		locais.add(rdbtnTundra);
		locais.add(rdbtnCaverna);
		
	}

}
