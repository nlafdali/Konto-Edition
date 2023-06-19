package Konto_04;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class KontoEdit extends JFrame implements ActionListener {
	
	private JPanel contentPane;
	private JTextField textKontoNr;
	private JTextField textKontoInhaber;
	private JTextField textKontoSaldo;
	private JButton btnCreateKonto;
	private JButton btnShowKonten;
	private JButton btnKontoAnzeigen;
	private JTextField txtKontoIdNr;
	private JTextField txtKontoDispo;
	
	private ArrayList<Konten> KontoListe = new ArrayList<>();
	private Konten aktKonto;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KontoEdit frame = new KontoEdit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public KontoEdit() {
		setTitle("Konto_04");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCreateKonto = new JButton("KontoAnlegen");
		btnCreateKonto.setBounds(22, 272, 138, 52);
		btnCreateKonto.addActionListener(this);
		contentPane.add(btnCreateKonto);
		
		btnShowKonten = new JButton("Konten auflisten");
		btnShowKonten.setBounds(432, 272, 138, 52);
		btnShowKonten.addActionListener(this);
		contentPane.add(btnShowKonten);
		
		btnKontoAnzeigen = new JButton("Konto anzeigen");
		btnKontoAnzeigen.setBounds(192, 272, 138, 52);
		btnKontoAnzeigen.addActionListener(this);
		contentPane.add(btnKontoAnzeigen);
		
		textKontoNr = new JTextField();
		textKontoNr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoNr.setBounds(365, 38, 205, 27);
		contentPane.add(textKontoNr);
		textKontoNr.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Konto Nr:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(369, 11, 74, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblKontoInhaber = new JLabel("Konto Inhaber:");
		lblKontoInhaber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKontoInhaber.setBounds(30, 173, 134, 27);
		contentPane.add(lblKontoInhaber);
		
		textKontoInhaber = new JTextField();
		textKontoInhaber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoInhaber.setColumns(10);
		textKontoInhaber.setBounds(22, 199, 548, 27);
		contentPane.add(textKontoInhaber);
		
		JLabel lblKontoSaldo = new JLabel("Konto Saldo:");
		lblKontoSaldo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKontoSaldo.setBounds(26, 94, 74, 27);
		contentPane.add(lblKontoSaldo);
		
		textKontoSaldo = new JTextField();
		textKontoSaldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textKontoSaldo.setColumns(10);
		textKontoSaldo.setBounds(22, 121, 205, 27);
		textKontoSaldo.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	            	textKontoSaldo.setEditable(true);
	            } else {
	            	textKontoSaldo.setEditable(false);
	            }
	         }
	      });
		contentPane.add(textKontoSaldo);
		
		JLabel lblKontoIdnr = new JLabel("Konto IdNr:");
		lblKontoIdnr.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKontoIdnr.setBounds(26, 11, 74, 27);
		contentPane.add(lblKontoIdnr);
		
		txtKontoIdNr = new JTextField();
		txtKontoIdNr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtKontoIdNr.setColumns(10);
		txtKontoIdNr.setBounds(22, 38, 205, 27);
		contentPane.add(txtKontoIdNr);
		
		JLabel lblDispo = new JLabel("Dispo:");
		lblDispo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDispo.setBounds(369, 94, 74, 27);
		contentPane.add(lblDispo);
		
		txtKontoDispo = new JTextField();
		txtKontoDispo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtKontoDispo.setColumns(10);
		txtKontoDispo.setBounds(365, 121, 205, 27);
		txtKontoDispo.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
	            	txtKontoDispo.setEditable(true);
	            } else {
	            	txtKontoDispo.setEditable(false);
	            	new WriteTrace_04("Ungültiger Tastaturanschlag in Kontodispo");
	            }
	         }
	      });
		contentPane.add(txtKontoDispo);
		
	}
	
	public void actionPerformed(ActionEvent e) {
    	if(e.getSource()== btnCreateKonto){
    		createKonto();
    	} else if(e.getSource()== btnShowKonten){
    		ListKonten();
    	} else if(e.getSource()== btnKontoAnzeigen){
    		ShowKonto();
    	}	
	} 
	
    private void createKonto() {
    	try {
    		aktKonto = new Konten();
    		aktKonto.setKontoSaldo(Double.parseDouble(textKontoSaldo.getText()));
    		aktKonto.setKontoDispo(Double.parseDouble(txtKontoDispo.getText()));
    		aktKonto.setKontoInhaber(textKontoInhaber.getText());
    		aktKonto.setKontoNr(textKontoNr.getText());
    		KontoListe.add(aktKonto);
    		new WriteTrace_04("neues Konto angelegt, KontoIdNr.: " + aktKonto.getKontoIdNr());
    		textKontoSaldo.setText("");
    		textKontoNr.setText("");
    		textKontoInhaber.setText("");
    		txtKontoDispo.setText("");
    		txtKontoIdNr.setText("" + aktKonto.getKontoIdNr());
    		JOptionPane.showMessageDialog(null, "Konto erfolgreich angelegt !");
    		txtKontoDispo.setEditable(true);
    		txtKontoDispo.setText("");
    		textKontoSaldo.setEditable(true);
    		textKontoSaldo.setText("");
    	} catch (Exception e){
			JOptionPane.showMessageDialog(null, e.toString());
		}
    	
    }
    
    private void ShowKonto() {
        for (int i = 0;i < KontoListe.size(); i++){
        	System.out.println(KontoListe.get(i).getKontoNr());
        	if(KontoListe.get(i).getKontoIdNr() == Integer.parseInt(txtKontoIdNr.getText())) {
        		textKontoNr.setText(KontoListe.get(i).getKontoNr());
        		textKontoSaldo.setText("" + KontoListe.get(i).getSKontoSaldo());
        		txtKontoDispo.setText("" + KontoListe.get(i).getSKontoDispo());
        		textKontoInhaber.setText(KontoListe.get(i).getKontoInhaber());
        		break;
        	}
        }	
    }
    
    private void ListKonten() {
        for (int i = 0;i < KontoListe.size(); i++){
        	System.out.println(KontoListe.get(i).getKontoInfo());
        }	
    }
}

