package gpex.janela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class TelaTarefa {

	private JFrame frmNovaTarefa;
	private JTable tabelaSubtarefas;
	private JTextField textoNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTarefa window = new TelaTarefa();
					window.frmNovaTarefa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaTarefa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNovaTarefa = new JFrame();
		frmNovaTarefa.setResizable(false);
		frmNovaTarefa.setTitle("Nova tarefa");
		frmNovaTarefa.setBounds(-29, -28, 777, 473);
		frmNovaTarefa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel painelSubtarefas = new JPanel();
		painelSubtarefas.setBounds(536, 134, 200, 250);
		painelSubtarefas.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Subtarefas", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JPanel painelTarefaPai = new JPanel();
		painelTarefaPai.setBounds(536, 70, 200, 52);
		painelTarefaPai.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Tarefa pai", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(63, 16, 45, 15);
		
		textoNome = new JTextField();
		textoNome.setBounds(126, 16, 371, 24);
		textoNome.setToolTipText("Entre com o nome da tarefa");
		textoNome.setColumns(10);
		
		JLabel lblPrazo = new JLabel("Prazo:");
		lblPrazo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrazo.setBounds(35, 55, 73, 15);
		
		JFormattedTextField textoPrazo = new JFormattedTextField();
		textoPrazo.setBounds(126, 50, 112, 24);
		textoPrazo.setToolTipText("Entre com o prazo");
		
		JLabel lblIntegrantes = new JLabel("Integrantes:");
		lblIntegrantes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIntegrantes.setBounds(19, 87, 89, 15);
		
		JComboBox comboBoxIntegrantes = new JComboBox();
		comboBoxIntegrantes.setBounds(126, 82, 259, 24);
		comboBoxIntegrantes.setToolTipText("Selecione o integrante");
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(397, 82, 100, 25);
		btnAdicionar.setMnemonic('A');
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(126, 118, 259, 69);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(397, 116, 100, 25);
		btnRemover.setToolTipText("Remover integrante selecionado");
		btnRemover.setMnemonic('R');
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrio.setBounds(34, 201, 74, 15);
		
		JScrollPane scrollPaneDescricao = new JScrollPane();
		scrollPaneDescricao.setBounds(126, 201, 371, 183);
		
		JLabel lblTarefaPai = new JLabel("");
		lblTarefaPai.setToolTipText("Clique para abrir");
		lblTarefaPai.setForeground(new Color(51, 51, 51));
		lblTarefaPai.setHorizontalAlignment(SwingConstants.LEFT);
		GroupLayout gl_painelTarefaPai = new GroupLayout(painelTarefaPai);
		gl_painelTarefaPai.setHorizontalGroup(
			gl_painelTarefaPai.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelTarefaPai.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTarefaPai, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_painelTarefaPai.setVerticalGroup(
			gl_painelTarefaPai.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelTarefaPai.createSequentialGroup()
					.addGap(29)
					.addComponent(lblTarefaPai)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		painelTarefaPai.setLayout(gl_painelTarefaPai);
		frmNovaTarefa.getContentPane().setLayout(null);
		frmNovaTarefa.getContentPane().add(lblNome);
		frmNovaTarefa.getContentPane().add(lblPrazo);
		frmNovaTarefa.getContentPane().add(lblIntegrantes);
		frmNovaTarefa.getContentPane().add(textoNome);
		frmNovaTarefa.getContentPane().add(textoPrazo);
		frmNovaTarefa.getContentPane().add(scrollPane_1);
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		frmNovaTarefa.getContentPane().add(comboBoxIntegrantes);
		frmNovaTarefa.getContentPane().add(btnRemover);
		frmNovaTarefa.getContentPane().add(btnAdicionar);
		frmNovaTarefa.getContentPane().add(scrollPaneDescricao);
		
		JEditorPane textoDescricao = new JEditorPane();
		scrollPaneDescricao.setViewportView(textoDescricao);
		frmNovaTarefa.getContentPane().add(lblDescrio);
		frmNovaTarefa.getContentPane().add(painelTarefaPai);
		frmNovaTarefa.getContentPane().add(painelSubtarefas);
		painelSubtarefas.setLayout(new GridLayout(1, 0, 0, 0));
		
				
				JScrollPane scrollPane = new JScrollPane();
				painelSubtarefas.add(scrollPane);
				scrollPane.setViewportBorder(null);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				
				tabelaSubtarefas = new JTable();
				tabelaSubtarefas.setToolTipText("Clique numa tarefa para abrí-la");
				tabelaSubtarefas.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ID", "Tarefa"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				tabelaSubtarefas.getColumnModel().getColumn(0).setPreferredWidth(46);
				tabelaSubtarefas.getColumnModel().getColumn(1).setPreferredWidth(179);
				scrollPane.setViewportView(tabelaSubtarefas);
		
		JSlider sliderProgresso = new JSlider();
		sliderProgresso.setValue(100);
		sliderProgresso.setBounds(536, 42, 200, 16);
		frmNovaTarefa.getContentPane().add(sliderProgresso);
		
		JLabel lblProgresso = new JLabel("Progresso:");
		lblProgresso.setBounds(536, 16, 131, 15);
		frmNovaTarefa.getContentPane().add(lblProgresso);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBounds(35, 400, 698, 35);
		frmNovaTarefa.getContentPane().add(panelBotoes);
		panelBotoes.setLayout(new GridLayout(0, 6, 5, 0));
		
		JButton btnAnterior = new JButton("Anterior");
		panelBotoes.add(btnAnterior);
		btnAnterior.setMnemonic('n');
		
		JButton btnNova = new JButton("Nova");
		panelBotoes.add(btnNova);
		btnNova.setMnemonic('N');
		
		JButton btnEditar = new JButton("Editar");
		panelBotoes.add(btnEditar);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setMnemonic('E');
		
		JButton btnExcluir = new JButton("Excluir");
		panelBotoes.add(btnExcluir);
		btnExcluir.setMnemonic('x');
		
		JButton btnDividir = new JButton("Dividir");
		panelBotoes.add(btnDividir);
		btnDividir.setMnemonic('D');
		
		JButton btnPrximo = new JButton("Próximo");
		panelBotoes.add(btnPrximo);
		btnPrximo.setMnemonic('P');
	}
}
