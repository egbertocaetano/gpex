package gpex.janela;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Tarefa extends JFrame {
	
	private JTextField nome;
	private JTextField descricao;
	private JTextField superTarefa;
	private JTable table;
	private JTable subTarefas;
	private JTextField statusTarefa;
	private JTextField textData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		
		Tarefa frame = new Tarefa();
		frame.setVisible(true);
	}	
	
	/**
	 * Create the frame.
	 */
	public Tarefa() {
		
		setBounds(100, 100, 576, 491);
		setVisible(true);
		
		
		JPanel panel = new JPanel();
		panel.setName("Tarefa");
		
		table = new JTable();
		
		JPanel panel_2 = new JPanel();
		
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(595)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 559, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 557, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
		);
		
		subTarefas = new JTable();
		subTarefas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"ID", "Descri\u00E7\u00E3o"
			}
		));
		subTarefas.getColumnModel().getColumn(1).setPreferredWidth(324);
		subTarefas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(subTarefas);
		
		JButton btnRetroceder = new JButton("Anterior");
		btnRetroceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRetroceder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnAvanar = new JButton("Próxima");
		btnAvanar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAvanar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(78)
					.addComponent(btnRetroceder)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAvanar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExcluir)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNovo)
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNovo, Alignment.TRAILING)
						.addComponent(btnEditar, Alignment.TRAILING)
						.addComponent(btnExcluir, Alignment.TRAILING)
						.addComponent(btnAvanar, Alignment.TRAILING)
						.addComponent(btnRetroceder, Alignment.TRAILING))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.linkSize(SwingConstants.VERTICAL, new Component[] {btnRetroceder, btnAvanar, btnExcluir, btnEditar, btnNovo});
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		nome = new JTextField();
		nome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nome.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		descricao = new JTextField();
		descricao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		descricao.setColumns(10);
		
		JLabel lblIntegrantes = new JLabel("Integrante:");
		lblIntegrantes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox integrantes = new JComboBox();
		integrantes.setEditable(true);
		integrantes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblStatus = new JLabel("Status da Tarefa:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblSuperTarefa = new JLabel("Super Tarefa:");
		lblSuperTarefa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		superTarefa = new JTextField();
		superTarefa.setEditable(false);
		superTarefa.setEnabled(false);
		superTarefa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		superTarefa.setColumns(10);
		
		JLabel lblSubTarefa = new JLabel("Sub Tarefas:");
		lblSubTarefa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		statusTarefa = new JTextField();
		statusTarefa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		statusTarefa.setText("100%");
		statusTarefa.setEditable(false);
		statusTarefa.setColumns(10);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textData = new JTextField();
		textData.setText("31/12/2012");
		textData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textData.setEditable(false);
		textData.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDescrio)
								.addComponent(lblNome))
							.addGap(24)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(integrantes, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(97)
									.addComponent(lblStatus)
									.addGap(8))
								.addComponent(nome, GroupLayout.PREFERRED_SIZE, 442, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(descricao, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(textData, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
											.addGap(23))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblData)
											.addGap(48))))))
						.addComponent(lblIntegrantes))
					.addContainerGap(16, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(101)
							.addComponent(superTarefa, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSuperTarefa)))
					.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
					.addComponent(statusTarefa, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(51))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(234)
					.addComponent(lblSubTarefa, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(234, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDescrio, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(descricao, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIntegrantes, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(integrantes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStatus)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(17)
							.addComponent(lblData, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textData, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSuperTarefa, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(superTarefa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
							.addComponent(lblSubTarefa, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(statusTarefa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}
}
