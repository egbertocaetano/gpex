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
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

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
		frmNovaTarefa.setBounds(100, 100, 758, 412);
		frmNovaTarefa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel painelSubtarefas = new JPanel();
		painelSubtarefas.setBounds(529, 77, 200, 238);
		painelSubtarefas.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Subtarefas", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JPanel painelTarefaPai = new JPanel();
		painelTarefaPai.setBounds(529, 13, 200, 52);
		painelTarefaPai.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Tarefa pai", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(56, 27, 45, 15);
		
		textoNome = new JTextField();
		textoNome.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textoNome.setBounds(119, 22, 371, 24);
		textoNome.setToolTipText("Entre com o nome da tarefa");
		textoNome.setColumns(10);
		
		JLabel lblPrazo = new JLabel("Prazo:");
		lblPrazo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrazo.setBounds(28, 64, 73, 15);
		
		JFormattedTextField textoPrazo = null;
		
		JLabel lblIntegrantes = new JLabel("Responsável:");
		lblIntegrantes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIntegrantes.setBounds(12, 98, 89, 15);
		
		JComboBox comboBoxIntegrantes = new JComboBox();
		comboBoxIntegrantes.setModel(new DefaultComboBoxModel(new String[] {"", "Válber", "Jéssica", "Egberto", "Ronaldo"}));
		comboBoxIntegrantes.setBounds(119, 94, 371, 24);
		comboBoxIntegrantes.setToolTipText("Selecione o integrante");
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescricao.setBounds(28, 135, 74, 15);
		
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
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(119, 59, 114, 22);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		frmNovaTarefa.getContentPane().add(dateChooser);
		
		final JTextArea textDescricao = new JTextArea();
		textDescricao.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textDescricao.setBounds(119, 134, 371, 137);
		frmNovaTarefa.getContentPane().add(textDescricao);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBounds(28, 335, 698, 35);
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
				try {
					fTarefa.salvar(textoNome.getText(), 
							textDescricao.getText(), 
							new java.sql.Timestamp(dateChooser.getDate().getTime()),
							1, 
							1, 
							1);
					//fTarefa.salvar(textoNome.getText(),textDescricao.getText(), ts, (Integer) null, 01);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		
		JLabel lblRotuloStatus = new JLabel("Status:");
		lblRotuloStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRotuloStatus.setBounds(27, 295, 74, 15);
		frmNovaTarefa.getContentPane().add(lblRotuloStatus);
		
		JLabel lblStatus = new JLabel("Em andamento");
		lblStatus.setBounds(119, 294, 234, 16);
		frmNovaTarefa.getContentPane().add(lblStatus);
		
		JCheckBox chckbxConcluida = new JCheckBox("Concluída");
		chckbxConcluida.setHorizontalAlignment(SwingConstants.RIGHT);
		chckbxConcluida.setBounds(381, 290, 112, 24);
		frmNovaTarefa.getContentPane().add(chckbxConcluida);
		
		
	}
}