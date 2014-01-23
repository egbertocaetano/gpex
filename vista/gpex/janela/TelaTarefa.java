package gpex.janela;

import gpex.FacadeTarefa;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Timestamp;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import javax.swing.JProgressBar;
import javax.swing.JToggleButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

public class TelaTarefa {

	private JFrame frmNovaTarefa;
	private JTable tabelaSubtarefas;
	private JTextField textoNome;
	FacadeTarefa fTarefa = FacadeTarefa.getInstance();
	SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");

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
		frmNovaTarefa.setBounds(-16, -28, 759, 473);
		frmNovaTarefa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel painelSubtarefas = new JPanel();
		painelSubtarefas.setBounds(529, 131, 200, 250);
		painelSubtarefas.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Subtarefas", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JPanel painelTarefaPai = new JPanel();
		painelTarefaPai.setBounds(529, 67, 200, 52);
		painelTarefaPai.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Tarefa pai", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(56, 18, 45, 15);
		
		textoNome = new JTextField();
		textoNome.setBounds(119, 13, 371, 24);
		textoNome.setToolTipText("Entre com o nome da tarefa");
		textoNome.setColumns(10);
		
		JLabel lblPrazo = new JLabel("Prazo:");
		lblPrazo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrazo.setBounds(28, 52, 73, 15);
		
		JFormattedTextField textoPrazo = null;
		
		JLabel lblIntegrantes = new JLabel("Responsáveis:");
		lblIntegrantes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIntegrantes.setBounds(12, 84, 89, 15);
		
		JComboBox comboBoxIntegrantes = new JComboBox();
		comboBoxIntegrantes.setBounds(119, 79, 371, 24);
		comboBoxIntegrantes.setToolTipText("Selecione o integrante");
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescricao.setBounds(27, 198, 74, 15);
		
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
		frmNovaTarefa.getContentPane().add(comboBoxIntegrantes);
		frmNovaTarefa.getContentPane().add(lblDescricao);
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
		
				
		
		JLabel lblProgresso = new JLabel("Progresso:");
		lblProgresso.setBounds(529, 13, 131, 15);
		frmNovaTarefa.getContentPane().add(lblProgresso);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(119, 47, 114, 22);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		frmNovaTarefa.getContentPane().add(dateChooser);
		
		final JTextArea textDescricao = new JTextArea();
		textDescricao.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textDescricao.setBounds(119, 197, 371, 137);
		frmNovaTarefa.getContentPane().add(textDescricao);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBounds(28, 397, 698, 35);
		frmNovaTarefa.getContentPane().add(panelBotoes);
		panelBotoes.setLayout(new GridLayout(0, 6, 5, 0));
		
		JButton btnAnterior = new JButton("Anterior");
		
		
		panelBotoes.add(btnAnterior);
		btnAnterior.setMnemonic('n');
		
		JButton btnNova = new JButton("Nova");
		panelBotoes.add(btnNova);
		btnNova.setMnemonic('N');
		
		JButton btnEditarSalvar = new JButton("Salvar");
		btnEditarSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				java.sql.Timestamp ts = new java.sql.Timestamp(dateChooser.getDate().getTime());
				try {
					fTarefa.salvar(textoNome.getText(),textDescricao.getText(), ts, (Integer) null, 01);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(sdf1.format(dateChooser.getDate()));
				
			}
		});
		panelBotoes.add(btnEditarSalvar);
		btnEditarSalvar.setMnemonic('S');
		
		JButton btnDividir = new JButton("Dividir");
		panelBotoes.add(btnDividir);
		btnDividir.setMnemonic('D');
		
		JButton btnExcluir = new JButton("Excluir");
		panelBotoes.add(btnExcluir);
		btnExcluir.setMnemonic('x');
		
		JButton btnPrximo = new JButton("Próximo");
		panelBotoes.add(btnPrximo);
		btnPrximo.setMnemonic('P');
		
		JLabel labelProgresso = new JLabel("");
		labelProgresso.setHorizontalAlignment(SwingConstants.RIGHT);
		labelProgresso.setBounds(640, 12, 89, 15);
		frmNovaTarefa.getContentPane().add(labelProgresso);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(529, 37, 200, 17);
		frmNovaTarefa.getContentPane().add(progressBar);
		
		
	}
}