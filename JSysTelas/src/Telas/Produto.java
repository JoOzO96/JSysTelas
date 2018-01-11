package Telas;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classes.MostraMensagem;
import net.miginfocom.swing.MigLayout;
import util.RemoveCaracteres;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Produto extends JFrame {

	private JPanel contentPane;
	private JTextField txCodproduto;
	private JTextField txDescricao;
	private JTextField textField_7;
	private JTextField txQuantidade;
	private JFormattedTextField txValorcusto;
	private JTextField txValorfrete;
	private JTextField txValorSubstituicao;
	private JTextField txValoricms;
	private JTextField txValoripi;
	private JTextField txPercsimples;
	private JTextField txValorCustoCalc;
	private JTextField txPercavista;
	private JTextField txPercprazo;
	private JTextField txValoravista;
	private JTextField txValorprazo;
	private JTextField txNcm;
	private JTextField txEan;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Produto() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {

			}
		});
		MostraMensagem mostraMensagem = new MostraMensagem();
		RemoveCaracteres caracteres = new RemoveCaracteres();
		DecimalFormat decimalFormat = new DecimalFormat("R$ #,##0.00");
		DecimalFormat decimalFormatPorc = new DecimalFormat("#,## %0.00");
		String valorPadraoMoeda = decimalFormat.format(0L);
		String valorPadraoPorc = decimalFormatPorc.format(0L);

		setTitle("Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 651, 420);
		contentPane.add(tabbedPane);

		JPanel panelDados = new JPanel();
		tabbedPane.addTab("Dados", null, panelDados, null);
		panelDados.setLayout(null);

		JLabel label = new JLabel("C\u00F3d Produto");
		label.setBounds(7, 10, 60, 14);
		panelDados.add(label);

		txCodproduto = new JTextField();
		txCodproduto.setToolTipText("Insira o codigo do produto.(Em branco sera gerado um codigo autom\u00E1tico)");
		txCodproduto.setBounds(71, 7, 86, 20);
		txCodproduto.setColumns(10);
		panelDados.add(txCodproduto);

		txDescricao = new JTextField();
		txDescricao.setToolTipText("Insira a descricao da mercadoria.");
		txDescricao.setBounds(71, 31, 494, 20);
		txDescricao.setColumns(10);
		panelDados.add(txDescricao);

		JLabel label_1 = new JLabel("Grupo");
		label_1.setBounds(38, 58, 29, 14);
		panelDados.add(label_1);

		JComboBox cbGrupo = new JComboBox();
		cbGrupo.setModel(new DefaultComboBoxModel(new String[] { "Teste" }));
		cbGrupo.setToolTipText("Selecione o grupo do produto.");
		cbGrupo.setBounds(71, 55, 138, 20);
		panelDados.add(cbGrupo);

		JLabel label_2 = new JLabel("Descri\u00E7\u00E3o");
		label_2.setBounds(21, 34, 46, 14);
		panelDados.add(label_2);

		txQuantidade = new JTextField();
		txQuantidade.setToolTipText("Insira a quantidade do estoque.");
		txQuantidade.setBounds(429, 55, 86, 20);
		txQuantidade.setColumns(10);
		panelDados.add(txQuantidade);

		JLabel lblQuantidadeEmEstoque = new JLabel("Quantidade");
		lblQuantidadeEmEstoque.setBounds(363, 58, 56, 14);
		panelDados.add(lblQuantidadeEmEstoque);

		JLabel lblValorCustor = new JLabel("Valor Custo: (R$)");
		lblValorCustor.setBounds(48, 162, 83, 14);
		panelDados.add(lblValorCustor);

		txValorcusto = new JFormattedTextField();
		txValorcusto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				txValorcusto.setText(caracteres.removeLetras(txValorcusto.getText()).toString());
			}
		});
		txValorcusto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				formataCampo(txValorcusto, decimalFormat, "V");
				recalculaCusto();
			}
		});
		txValorcusto.setText(valorPadraoMoeda);
		txValorcusto.setToolTipText("Insira o valor de custo do produto.");
		txValorcusto.setColumns(10);
		txValorcusto.setBounds(145, 161, 86, 20);
		panelDados.add(txValorcusto);

		JLabel lblSubTributariar = new JLabel("Sub. Tributaria: (R$)");
		lblSubTributariar.setBounds(32, 186, 99, 14);
		panelDados.add(lblSubTributariar);

		txValorfrete = new JTextField();
		txValorfrete.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				formataCampo(txValorfrete, decimalFormat, "V");
				recalculaCusto();
			}

			
		});
		txValorfrete.setToolTipText("Insira o valor do frete.");
		txValorfrete.setText(valorPadraoMoeda);
		txValorfrete.setColumns(10);
		txValorfrete.setBounds(145, 209, 86, 20);
		panelDados.add(txValorfrete);

		txValorSubstituicao = new JTextField();
		txValorSubstituicao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				formataCampo(txValorSubstituicao, decimalFormat, "V");
				recalculaCusto();
			}
		});
		txValorSubstituicao.setToolTipText("Insira o valor da Substitui\u00E7\u00E3o tributaria.");
		txValorSubstituicao.setText(valorPadraoMoeda);
		txValorSubstituicao.setColumns(10);
		txValorSubstituicao.setBounds(145, 185, 86, 20);
		panelDados.add(txValorSubstituicao);

		JLabel lblFreter = new JLabel("Frete: (R$)");
		lblFreter.setBounds(77, 210, 54, 14);
		panelDados.add(lblFreter);

		JLabel lblDarfEIcms = new JLabel("DARF e ICMS: (R$)");
		lblDarfEIcms.setBounds(39, 234, 92, 14);
		panelDados.add(lblDarfEIcms);

		txValoricms = new JTextField();
		txValoricms.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Produto.this.formataCampo(txValoricms, decimalFormat, "P");
				recalculaCusto();
			}
		});
		txValoricms.setToolTipText("Insira o valor do ICMS.");
		txValoricms.setText(valorPadraoPorc);
		txValoricms.setColumns(10);
		txValoricms.setBounds(145, 233, 86, 20);
		panelDados.add(txValoricms);

		txValoripi = new JTextField();
		txValoripi.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Produto.this.formataCampo(txValoripi, decimalFormat, "V");
				recalculaCusto();
			}
		});
		txValoripi.setToolTipText("Insira o valor do IPI.");
		txValoripi.setText(valorPadraoMoeda);
		txValoripi.setColumns(10);
		txValoripi.setBounds(145, 257, 86, 20);
		panelDados.add(txValoripi);

		JLabel lblIpir = new JLabel("IPI: (R$)");
		lblIpir.setBounds(89, 258, 42, 14);
		panelDados.add(lblIpir);

		JLabel lblPercSimplesr = new JLabel("Perc. Simples: (R$)");
		lblPercSimplesr.setBounds(40, 282, 91, 14);
		panelDados.add(lblPercSimplesr);

		txPercsimples = new JTextField();
		txPercsimples.setToolTipText("Insira o percentual do Simples Nacional.");
		txPercsimples.setText(valorPadraoPorc);
		txPercsimples.setColumns(10);
		txPercsimples.setBounds(145, 281, 86, 20);
		panelDados.add(txPercsimples);

		JLabel lblCustoDoProd = new JLabel("Custo do Prod.: (R$)");
		lblCustoDoProd.setBounds(32, 310, 100, 14);
		panelDados.add(lblCustoDoProd);

		txValorCustoCalc = new JTextField();
		txValorCustoCalc.setEditable(false);
		txValorCustoCalc.setToolTipText("Valor calculado do custo do produto.");
		txValorCustoCalc.setText(valorPadraoMoeda);
		txValorCustoCalc.setColumns(10);
		txValorCustoCalc.setBounds(146, 309, 86, 20);
		panelDados.add(txValorCustoCalc);

		JLabel lblMargemDeLucro = new JLabel("Margem de Lucro: (%)");
		lblMargemDeLucro.setBounds(22, 338, 108, 14);
		panelDados.add(lblMargemDeLucro);

		txPercavista = new JTextField();
		txPercavista.setToolTipText("Insira o percentual de lucro avista.");
		txPercavista.setText(valorPadraoPorc);
		txPercavista.setColumns(10);
		txPercavista.setBounds(146, 337, 86, 20);
		panelDados.add(txPercavista);

		txPercprazo = new JTextField();
		txPercprazo.setToolTipText("Insira o percentual de lucro a prazo.");
		txPercprazo.setText(valorPadraoPorc);
		txPercprazo.setColumns(10);
		txPercprazo.setBounds(146, 361, 86, 20);
		panelDados.add(txPercprazo);

		JLabel lblMargemLucroPrazo = new JLabel("Margem Lucro Prazo: (%)");
		lblMargemLucroPrazo.setBounds(7, 362, 123, 14);
		panelDados.add(lblMargemLucroPrazo);

		JSeparator separator = new JSeparator();
		separator.setBounds(7, 113, 477, 2);
		panelDados.add(separator);

		txValoravista = new JTextField();
		txValoravista.setToolTipText("Valor calculado a vista do produto.");
		txValoravista.setText(valorPadraoMoeda);
		txValoravista.setColumns(10);
		txValoravista.setBounds(344, 233, 86, 20);
		panelDados.add(txValoravista);

		JLabel lblValorAvista = new JLabel("Valor Avista: (R$)");
		lblValorAvista.setBounds(251, 236, 85, 14);
		panelDados.add(lblValorAvista);

		txValorprazo = new JTextField();
		txValorprazo.setToolTipText("Valor calculado do item \u00E0 prazo.");
		txValorprazo.setText(valorPadraoMoeda);
		txValorprazo.setColumns(10);
		txValorprazo.setBounds(344, 257, 86, 20);
		panelDados.add(txValorprazo);

		JLabel lblValorAPrazo = new JLabel("Valor A Prazo: (R$)");
		lblValorAPrazo.setBounds(244, 260, 92, 14);
		panelDados.add(lblValorAPrazo);

		JComboBox cbIcms = new JComboBox();
		cbIcms.setModel(new DefaultComboBoxModel(new String[] { "Teste" }));
		cbIcms.setToolTipText("Selecione o codigo do ICMS.");
		cbIcms.setBounds(71, 82, 138, 20);
		panelDados.add(cbIcms);

		JLabel lblIcms = new JLabel("ICMS");
		lblIcms.setBounds(38, 85, 29, 14);
		panelDados.add(lblIcms);

		JLabel lblNcm = new JLabel("NCM");
		lblNcm.setBounds(235, 58, 22, 14);
		panelDados.add(lblNcm);

		txNcm = new JTextField();
		txNcm.setToolTipText("Insira o NCM do produto.");
		txNcm.setColumns(10);
		txNcm.setBounds(267, 55, 86, 20);
		panelDados.add(txNcm);

		txEan = new JTextField();
		txEan.setToolTipText("Insira o NCM do produto.");
		txEan.setColumns(13);
		txEan.setBounds(267, 82, 86, 20);
		panelDados.add(txEan);

		JLabel lblEan = new JLabel("EAN");
		lblEan.setBounds(235, 85, 22, 14);
		panelDados.add(lblEan);

		JPanel panelValor = new JPanel();
		tabbedPane.addTab("Valores", null, panelValor, null);
		panelValor.setLayout(
				new MigLayout("", "[101px][86px]", "[20px][20px][20px][20px][20px][20px][20px][20px][20px][20px]"));

		JLabel lblCustoFixo = new JLabel("Custo Fixo:");
		panelValor.add(lblCustoFixo, "cell 0 7,alignx right,aligny center");

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		panelValor.add(textField_7, "cell 1 7,alignx left,aligny top");

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(5, 425, 89, 23);
		contentPane.add(btnNewButton);
	}

	
	private void formataCampo(JTextField textField, DecimalFormat decimalFormat, String tipo) {
		RemoveCaracteres caracteres = new RemoveCaracteres();
		if (tipo == "V") {
		textField.setText(decimalFormat
				.format(Double.parseDouble(caracteres.removeCaracterDinheiro(textField.getText()))));
		recalculaCusto();
		}else if (tipo == "P") {
			textField.setText(decimalFormat
				.format(Double.parseDouble(caracteres.removeCaracterPorcentagem(textField.getText()))));
			recalculaCusto();
		}
	}
	
	public void recalculaCusto() {
		List<String> listaCampos = new ArrayList<>();
		RemoveCaracteres caracteres = new RemoveCaracteres();
		DecimalFormat decimalFormat = new DecimalFormat("R$ #,##0.00");
		Double valorCusto = Double.parseDouble(caracteres.removeCaracterDinheiro(txValorcusto.getText()));
		Double valorFrete = Double.parseDouble(caracteres.removeCaracterDinheiro(txValorfrete.getText()));
		Double valorSubstituicao = Double.parseDouble(caracteres.removeCaracterDinheiro(txValorSubstituicao.getText()));
		Double valorIpi = Double.parseDouble(caracteres.removeCaracterDinheiro(txValoripi.getText()));
		Double valorCustoCalc = Double.parseDouble(caracteres.removeCaracterDinheiro(txValorCustoCalc.getText()));
		Double valorAvista = Double.parseDouble(caracteres.removeCaracterDinheiro(txValoravista.getText()));
		Double percAvista = Double.parseDouble(caracteres.removeCaracterPorcentagem(txPercavista.getText()));
		Double percPrazo = Double.parseDouble(caracteres.removeCaracterPorcentagem(txPercprazo.getText()));
		valorCustoCalc = valorCusto + valorFrete + valorSubstituicao + valorIpi;

		valorAvista = valorCustoCalc * percAvista / 100;

		txValorCustoCalc.setText(decimalFormat.format(valorCustoCalc));
		txValoravista.setText(decimalFormat.format(valorAvista));
	}
}
