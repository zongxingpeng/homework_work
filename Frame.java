package JTable;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class Frame extends JFrame {
	
	private static final long serialVersionUID = -5326933171794774954L;
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField aTextField;
	private JTextField bTextField;
	private JTextField cTextField;
	
	public static void main(String args[]) {
		Frame frame = new Frame();
		frame.setVisible(true);
	}
	
	public Frame() {
		super();
		setTitle("Todo list");
		setBounds(100, 100, 800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		String[] columnNames = {"�ͻ�", "�¼�", "״̬"};
		String[][] tableValues = {{"����", "д��ҵ", "���"}};
		tableModel = new DefaultTableModel(tableValues, columnNames);
		table = new JTable(tableModel);
		table.setRowSorter(new TableRowSorter<>(tableModel));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				Object oa = tableModel.getValueAt(selectedRow, 0);
				Object ob = tableModel.getValueAt(selectedRow, 1);
				Object oc = tableModel.getValueAt(selectedRow, 2);
				aTextField.setText(oa.toString());
				bTextField.setText(ob.toString());
				cTextField.setText(oc.toString());
			}
		});
		scrollPane.setViewportView(table);
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.add(new JLabel("�ͻ���"));
		aTextField = new JTextField("", 10);
		panel.add(aTextField);
		panel.add(new JLabel("�¼���"));
		bTextField = new JTextField("", 20);
		panel.add(bTextField);
		panel.add(new JLabel("״̬��"));
		cTextField = new JTextField("", 5);
		panel.add(cTextField);
		final JButton addButton = new JButton("���");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] rowValues = {aTextField.getText(), bTextField.getText(), cTextField.getText()};
				tableModel.addRow(rowValues);
				aTextField.setText(aTextField.getText());
				bTextField.setText(bTextField.getText());
				cTextField.setText(cTextField.getText());
			}
		});
		panel.add(addButton);
		final JButton updButton = new JButton("�޸�");
		updButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if(selectedRow != -1) {
					tableModel.setValueAt(aTextField.getText(), selectedRow, 0);
					tableModel.setValueAt(bTextField.getText(), selectedRow, 1);
					tableModel.setValueAt(cTextField.getText(), selectedRow, 2);
				}
			}
		});
		panel.add(updButton);
		final JButton delButton = new JButton("ɾ��");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if(selectedRow != -1) {
					tableModel.removeRow(selectedRow);
				}
			}
		});
		panel.add(delButton);
	}

}
