package gpex.janela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaListaTarefas {

	private JFrame janelaListaTarefas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaTarefas window = new TelaListaTarefas();
					window.janelaListaTarefas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListaTarefas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		janelaListaTarefas = new JFrame();
		janelaListaTarefas.setBounds(100, 100, 708, 458);
		janelaListaTarefas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaListaTarefas.getContentPane().setLayout(null);
		
		JLabel lblNomeEquipe = new JLabel("Equipe");
		lblNomeEquipe.setBounds(30, 11, 53, 22);
		lblNomeEquipe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		janelaListaTarefas.getContentPane().add(lblNomeEquipe);
		
		JPanel panelTarefasConcluidas = new JPanel();
		panelTarefasConcluidas.setBorder(new TitledBorder(null, "Tarefas conclu\u00EDdas", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelTarefasConcluidas.setBounds(30, 87, 300, 320);
		janelaListaTarefas.getContentPane().add(panelTarefasConcluidas);
		panelTarefasConcluidas.setLayout(null);
		
		JPanel panelTarefasPendentes = new JPanel();
		panelTarefasPendentes.setBorder(new TitledBorder(null, "Tarefas pendentes", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelTarefasPendentes.setBounds(360, 87, 300, 320);
		janelaListaTarefas.getContentPane().add(panelTarefasPendentes);
		panelTarefasPendentes.setLayout(null);
	}
}
