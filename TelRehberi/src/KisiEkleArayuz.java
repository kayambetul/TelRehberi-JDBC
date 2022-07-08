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
	
	KisilerCheckService kisilerCheckService;
	MernisKpsService mernis=new MernisKpsService();

	public KisiEkleArayuz(KisilerCheckService kisilerCheckService) {
		this.kisilerCheckService = kisilerCheckService;

	}

	JLabel lblAd;
	JLabel lblSoyad;
	JLabel lblMeslek;
	JLabel lblSehir;
	JLabel lblEmail;
	JLabel lblEmail2;
	JLabel lblTelefon;
	JLabel lblTelefon2;
	JLabel lblNationality;
	JLabel lblBirtDate;

	JTextField txtAd;
	JTextField txtSoyad;
	JTextField txtMeslek;
	JTextField txtSehir;
	JTextField txtEmail;
	JTextField txtEmail2;
	JTextField txtTelefon;
	JTextField txtTelefon2;
	JTextField txtNationality;
	JTextField txtBirtDate;

	JButton btnKaydet;
	JButton btnGuncelle;
	JButton btnTemizle;

	public KisiEkleArayuz() {

		super("Kisi Ekle");
		setLayout(new GridLayout(10, 2));
		setSize(250, 300);

		lblAd = new JLabel("Ad");
		lblSoyad = new JLabel("Soyad");
		lblMeslek = new JLabel("Meslek");
		lblSehir = new JLabel("Sehir");
		lblEmail = new JLabel("Email");
		lblEmail2 = new JLabel("Email2");
		lblTelefon = new JLabel("Telefon");
		lblTelefon2 = new JLabel("Telefon2");
		lblNationality = new JLabel("TC");
		lblBirtDate = new JLabel("Doğum Tarihi");

		this.txtAd = new JTextField("", 15);
		this.txtSoyad = new JTextField("", 15);
		this.txtMeslek = new JTextField("", 15);
		this.txtSehir = new JTextField("", 15);
		this.txtEmail = new JTextField("", 15);
		this.txtEmail2 = new JTextField("", 15);
		this.txtTelefon = new JTextField("", 15);
		this.txtTelefon2 = new JTextField("", 15);
		this.txtNationality = new JTextField("", 15);
		this.txtBirtDate = new JTextField("", 15);

		btnKaydet = new JButton("Kaydet");
		btnGuncelle = new JButton("Guncelle");
		btnTemizle = new JButton("Temizle");

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

		add(lblNationality);
		add(txtNationality);

		add(lblBirtDate);
		add(txtBirtDate);

		add(btnKaydet);
		add(btnGuncelle);
		add(btnTemizle);

		btnKaydet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String url = "jdbc:postgresql://localhost/Kisilerim?user=postgres&password=12345";

				try {

					Connection conn = DriverManager.getConnection(url);

					String query = "insert into kisilerim (ad,soyad,meslek,sehir,email,email2,telefon,telefon2,nationality,birtdate) "
							+ "values(?,?,?,?,?,?,?,?,?,?)";
					// checkIfRealKisiler(txtNationality.getText(),txtAd.getText(),
					// txtSoyad.getText(),txtBirtDate.getColumns());

					PreparedStatement ps = conn.prepareStatement(query);
					ps.setString(1, txtAd.getText());
					ps.setString(2, txtSoyad.getText());
					ps.setString(3, txtMeslek.getText());
					ps.setString(4, txtSehir.getText());
					ps.setString(5, txtEmail.getText());
					ps.setString(6, txtEmail2.getText());
					ps.setString(7, txtTelefon.getText());
					ps.setString(8, txtTelefon2.getText());
					ps.setString(9, txtNationality.getText());
					ps.setInt(10, Integer.parseInt(txtBirtDate.getText()));

					Kisiler kisiler=new Kisiler();
					kisiler.setAd(txtAd.getText());
					kisiler.setSoyad(txtSoyad.getText());
					kisiler.setNationality(txtNationality.getText());
					kisiler.setBirthDate(Integer.parseInt(txtBirtDate.getText()));
					System.out.println(kisiler.getAd()+kisiler.getSoyad()+kisiler.getBirthDate()+kisiler.getNationality());
				    checkIfRealKisiler(kisiler);

				    
					
					ps.executeUpdate();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		});

		btnGuncelle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				KisiGuncelleArayuz kg = new KisiGuncelleArayuz();
				kg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				kg.setVisible(true);
				hide();
			}
		});

		btnTemizle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				KisiTemizlemeArayuzu ka = new KisiTemizlemeArayuzu();
				ka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ka.setVisible(true);
				hide();

			}
		});

	}

	private void checkIfRealKisiler(Kisiler kisiler) throws Exception {
		if (!mernis.checkIfRealPerson(kisiler)) {

			
			throw new Exception("kişi yok");

		}
	}

}
