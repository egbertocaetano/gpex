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
		frmNovaTarefa.setBounds(100, 100, 766, 573);
		frmNovaTarefa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel painelSubtarefas = new JPanel();
		painelSubtarefas.setBounds(550, 216, 200, 264);
		painelSubtarefas.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Subtarefas", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JPanel painelTarefaPai = new JPanel();
		painelTarefaPai.setBounds(550, 108, 200, 69);
		painelTarefaPai.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Tarefa pai", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(35, 58, 45, 15);
		
		textoNome = new JTextField();
		textoNome.setBounds(160, 56, 328, 19);
		textoNome.setToolTipText("Entre com o nome da tarefa");
		textoNome.setColumns(10);
		
		JLabel lblPrazo = new JLabel("Prazo:");
		lblPrazo.setBounds(35, 97, 73, 15);
		
		JFormattedTextField textoPrazo = new JFormattedTextField();
		textoPrazo.setBounds(160, 95, 112, 19);
		textoPrazo.setToolTipText("Entre com o prazo");
		
		JLabel lblIntegrantes = new JLabel("Integrantes:");
		lblIntegrantes.setBounds(35, 137, 89, 15);
		
		JComboBox comboBoxIntegrantes = new JComboBox();
		comboBoxIntegrantes.setBounds(160, 132, 259, 24);
		comboBoxIntegrantes.setToolTipText("Selecione o integrante");
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(431, 132, 100, 25);
		btnAdicionar.setMnemonic('A');
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(160, 178, 259, 101);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(431, 175, 100, 25);
		btnRemover.setToolTipText("Remover integrante selecionado");
		btnRemover.setMnemonic('R');
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setBounds(35, 297, 74, 15);
		
		JScrollPane scrollPaneDescricao = new JScrollPane();
		scrollPaneDescricao.setBounds(160, 297, 371, 183);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(32, 501, 95, 25);
		btnAnterior.setMnemonic('n');
		
		JButton btnNova = new JButton("Nova");
		btnNova.setBounds(160, 501, 95, 25);
		btnNova.setMnemonic('N');
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setBounds(291, 501, 95, 25);
		btnEditar.setMnemonic('E');
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(418, 501, 95, 25);
		btnExcluir.setMnemonic('x');
		
		JButton btnDividir = new JButton("Dividir");
		btnDividir.setBounds(536, 501, 95, 25);
		btnDividir.setMnemonic('D');
		
		JButton btnPrximo = new JButton("Próximo");
		btnPrximo.setBounds(655, 501, 95, 25);
		btnPrximo.setMnemonic('P');
		
		JEditorPane textoDescricao = new JEditorPane();
		scrollPaneDescricao.setViewportView(textoDescricao);
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_painelSubtarefas = new GroupLayout(painelSubtarefas);
		gl_painelSubtarefas.setHorizontalGroup(
			gl_painelSubtarefas.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_painelSubtarefas.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_painelSubtarefas.setVerticalGroup(
			gl_painelSubtarefas.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_painelSubtarefas.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
					.addContainerGap())
		);
		
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
		painelSubtarefas.setLayout(gl_painelSubtarefas);
		
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
		frmNovaTarefa.getContentPane().add(comboBoxIntegrantes);
		frmNovaTarefa.getContentPane().add(btnRemover);
		frmNovaTarefa.getContentPane().add(btnAdicionar);
		frmNovaTarefa.getContentPane().add(scrollPaneDescricao);
		frmNovaTarefa.getContentPane().add(lblDescrio);
		frmNovaTarefa.getContentPane().add(painelTarefaPai);
		frmNovaTarefa.getContentPane().add(painelSubtarefas);
		frmNovaTarefa.getContentPane().add(btnAnterior);
		frmNovaTarefa.getContentPane().add(btnNova);
		frmNovaTarefa.getContentPane().add(btnEditar);
		frmNovaTarefa.getContentPane().add(btnExcluir);
		frmNovaTarefa.getContentPane().add(btnDividir);
		frmNovaTarefa.getContentPane().add(btnPrximo);
		
		JSlider sliderProgresso = new JSlider();
		sliderProgresso.setValue(100);
		sliderProgresso.setBounds(550, 75, 200, 16);
		frmNovaTarefa.getContentPane().add(sliderProgresso);
		
		JLabel lblProgresso = new JLabel("Progresso:");
		lblProgresso.setBounds(550, 56, 131, 15);
		frmNovaTarefa.getContentPane().add(lblProgresso);
	}
}
