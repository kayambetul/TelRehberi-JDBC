import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class KisiEkleArayuz extends JFrame {

	JLabel lblAd;
	JLabel lblSoyad;
	JLabel lblMeslek;
	JLabel lblSehir;
	JLabel lblEmail;
	JLabel lblEmail2;
	JLabel lblTelefon;
	JLabel lblTelefon2;
	
	JTextField txtAd;
	JTextField txtSoyad;
	JTextField txtMeslek;
	JTextField txtSehir;
	JTextField txtEmail;
	JTextField txtEmail2;
	JTextField txtTelefon;
	JTextField txtTelefon2;
	
	JButton btnKaydet;
	JButton btnGuncelle;
	JButton btnTemizle;

	
	public KisiEkleArayuz() {
		
		super("Kisi Ekle");
		setLayout(new GridLayout(10,2));
		setSize(250,300);
		
		lblAd=new JLabel("Ad");
		lblSoyad=new JLabel("Soyad");
		lblMeslek=new JLabel("Meslek");
		lblSehir=new JLabel("Sehir");
		lblEmail=new JLabel("Email");
		lblEmail2=new JLabel("Email2");
		lblTelefon=new JLabel("Telefon");
		lblTelefon2=new JLabel("Telefon2");
		
		txtAd=new JTextField("",15);
		txtSoyad=new JTextField("",15);
		txtMeslek=new JTextField("",15);
		txtSehir=new JTextField("",15);
		txtEmail=new JTextField("",15);
		txtEmail2=new JTextField("",15);
		txtTelefon=new JTextField("",15);
		txtTelefon2=new JTextField("",15);
		
		btnKaydet=new JButton("Kaydet");
		btnGuncelle=new JButton("Guncelle");
		btnTemizle=new JButton("Temizle");
		
		add(lblAd);
		add(txtAd);
		
		add(lblSoyad);
		add(txtSoyad);
		
		
		
		add(lblMeslek);
		add(txtMeslek);
		
		add(lblSehir);
		add(txtSehir);
		
		add(lblEmail);
		add(txtEmail);
		
		add(lblEmail2);
		add(txtEmail2);
		
		add(lblTelefon);
		add(txtTelefon);
		
		add(lblTelefon2);
		add(txtTelefon2);
		
		add(btnKaydet);
		add(btnGuncelle);
		add(btnTemizle);
		
		
		
		btnKaydet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String url = "jdbc:postgresql://localhost/Kisilerim?user=postgres&password=12345";
				try {
					
					Connection conn = DriverManager.getConnection(url);
					String query="insert into kisilerim (ad,soyad,meslek,sehir,email,email2,telefon,telefon2) "
							+ "values(?,?,?,?,?,?,?,?)";
					
					PreparedStatement ps=conn.prepareStatement(query);
					ps.setString(1, txtAd.getText());
					ps.setString(2, txtSoyad.getText());
					ps.setString(3, txtMeslek.getText());
					ps.setString(4, txtSehir.getText());
					ps.setString(5, txtEmail.getText());
					ps.setString(6, txtEmail2.getText());
					ps.setString(7, txtTelefon.getText());
					ps.setString(8, txtTelefon2.getText());
					ps.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		
		btnGuncelle.addActionListener(new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				KisiGuncelleArayuz kg=new KisiGuncelleArayuz();
				kg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				kg.setVisible(true);
				hide();
			}
		});
		
		
		btnTemizle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				KisiTemizlemeArayuzu ka=new KisiTemizlemeArayuzu();
				ka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ka.setVisible(true);
				hide();
				
				
			}
		});
		
		
	}
	
}

