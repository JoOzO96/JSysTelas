package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.ScrollPane;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.TextField;
import java.awt.Label;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

public class Produto extends JFrame {

	private JPanel contentPane;
	private JTextField txCodproduto;
	private JTextField txDescricao;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Produto() {
		setTitle("Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panelDados = new JPanel();
		tabbedPane.addTab("Dados", null, panelDados, null);
		panelDados.setLayout(new MigLayout("", "[60px][295px]", "[20px][20px][20px][20px]"));
		
		JLabel label = new JLabel("C\u00F3d Produto");
		panelDados.add(label, "cell 0 0,alignx left,aligny center");
		
		txCodproduto = new JTextField();
		txCodproduto.setColumns(10);
		panelDados.add(txCodproduto, "cell 1 0,alignx left,aligny top");
		
		txDescricao = new JTextField();
		txDescricao.setColumns(10);
		panelDados.add(txDescricao, "cell 1 1,growx,aligny top");
		
		JLabel label_1 = new JLabel("Grupo");
		panelDados.add(label_1, "cell 0 2,alignx right,aligny center");
		
		JComboBox cbGrupo = new JComboBox();
		panelDados.add(cbGrupo, "cell 1 2,alignx left,aligny top");
		
		JLabel label_2 = new JLabel("Descri\u00E7\u00E3o");
		panelDados.add(label_2, "cell 0 1,alignx right,aligny center");
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		panelDados.add(textField_10, "cell 1 3,alignx left,aligny top");
		
		JLabel lblQuantidadeEmEstoque = new JLabel("Quantidade");
		panelDados.add(lblQuantidadeEmEstoque, "cell 0 3,alignx right,aligny center");
		
		JPanel panelValor = new JPanel();
		tabbedPane.addTab("Valores", null, panelValor, null);
		panelValor.setLayout(new MigLayout("", "[101px][86px]", "[20px][20px][20px][20px][20px][20px][20px][20px][20px][20px]"));
		
		textField = new JTextField();
		textField.setColumns(10);
		panelValor.add(textField, "cell 1 0,alignx left,aligny top");
		
		JLabel lblValorCusto = new JLabel("Valor Custo:");
		panelValor.add(lblValorCusto, "cell 0 0,alignx right,aligny center");
		
		JLabel lblSubTributaria = new JLabel("Sub. Tributaria:");
		panelValor.add(lblSubTributaria, "cell 0 1,alignx right,aligny center");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panelValor.add(textField_1, "cell 1 1,alignx left,aligny top");
		
		JLabel lblFrete = new JLabel("Frete:");
		panelValor.add(lblFrete, "cell 0 2,alignx right,aligny center");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panelValor.add(textField_2, "cell 1 2,alignx left,aligny top");
		
		JLabel lblDarfEIcms = new JLabel("DARF e ICMS:");
		panelValor.add(lblDarfEIcms, "cell 0 3,alignx right,aligny center");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panelValor.add(textField_3, "cell 1 3,alignx left,aligny top");
		
		JLabel lblIpi = new JLabel("IPI:");
		panelValor.add(lblIpi, "cell 0 4,alignx right,aligny center");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panelValor.add(textField_4, "cell 1 4,alignx left,aligny top");
		
		JLabel lblPercSimples = new JLabel("Perc. Simples:");
		panelValor.add(lblPercSimples, "cell 0 5,alignx right,aligny center");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panelValor.add(textField_5, "cell 1 5,alignx left,aligny top");
		
		JLabel lblCustoDaMerca = new JLabel("Custo do Prod.:");
		panelValor.add(lblCustoDaMerca, "cell 0 6,alignx right,aligny center");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		panelValor.add(textField_6, "cell 1 6,alignx left,aligny top");
		
		JLabel lblCustoFixo = new JLabel("Custo Fixo:");
		panelValor.add(lblCustoFixo, "cell 0 7,alignx right,aligny center");
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		panelValor.add(textField_7, "cell 1 7,alignx left,aligny top");
		
		JLabel lblMargemDeLucro = new JLabel("Margem de Lucro:");
		panelValor.add(lblMargemDeLucro, "cell 0 8,alignx right,aligny center");
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		panelValor.add(textField_8, "cell 1 8,alignx left,aligny top");
		
		JLabel lblMargemLucroPrazo = new JLabel("Margem Lucro Prazo:");
		panelValor.add(lblMargemLucroPrazo, "cell 0 9,alignx left,aligny center");
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		panelValor.add(textField_9, "cell 1 9,alignx left,aligny top");
	}
}
