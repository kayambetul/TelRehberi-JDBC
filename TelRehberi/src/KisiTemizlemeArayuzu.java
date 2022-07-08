import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class KisiTemizlemeArayuzu extends JFrame {
	
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
	
	
	JButton btnTemizle;

	JLabel lblKisiSec;
	
	JComboBox<Kisiler> cmbKisiler;
	
	public KisiTemizlemeArayuzu() {
		
		super("Kisi Temizleme");
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
		lblKisiSec=new JLabel("KisiSec");
		
		cmbKisiler=new JComboBox<Kisiler>();
		
		txtAd=new JTextField("",15);
		txtSoyad=new JTextField("",15);
		txtMeslek=new JTextField("",15);
		txtSehir=new JTextField("",15);
		txtEmail=new JTextField("",15);
		txtEmail2=new JTextField("",15);
		txtTelefon=new JTextField("",15);
		txtTelefon2=new JTextField("",15);
		
		
		btnTemizle=new JButton("Temizle");
		
		
		add(lblKisiSec);
		add(cmbKisiler);
		
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
		
		
		add(btnTemizle);
		
		for(Kisiler kisi : getKisilerFromDB()) {
			cmbKisiler.addItem(kisi);
		}
		
		
        cmbKisiler.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				Kisiler k=(Kisiler) cmbKisiler.getSelectedItem();
				txtAd.setText(k.getAd());
				txtSoyad.setText(k.getSoyad());
				txtMeslek.setText(k.getMeslek());
				txtSehir.setText(k.getSehir());
				txtEmail.setText(k.getEmail());
				txtEmail2.setText(k.getEmail2());
				txtTelefon.setText(k.getTelefon());
				txtTelefon2.setText(k.getTelefon2());
				
				
			}
		});
        
        
       btnTemizle.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String url = "jdbc:postgresql://localhost/Kisilerim?user=postgres&password=12345";
			try {
				Connection conn = DriverManager.getConnection(url);
				
				String query="DELETE FROM kisilerim WHERE id=?";
						
				
				PreparedStatement ps=conn.prepareStatement(query);
				
				
				Kisiler k=(Kisiler) cmbKisiler.getSelectedItem();
				ps.setInt(1, k.getId());
				
				ps.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
				e1.printStackTrace();
			}
		
		
		}
	});
        
        

}

	public ArrayList<Kisiler> getKisilerFromDB()  {
		// TODO Auto-generated method stub
		
		ArrayList<Kisiler> result = new ArrayList<Kisiler>();
		String url = "jdbc:postgresql://localhost/Kisiler?user=postgres&password=12345";
		try {
			Connection conn = DriverManager.getConnection(url);
			
			String query="select * from kisilerim;";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Kisiler k = new Kisiler();
				k.setId(rs.getInt("id"));
				k.setAd(rs.getString("ad"));
				k.setSoyad(rs.getString("soyad"));
//				k.setMeslek(rs.getString("meslek"));
//				k.setSehir(rs.getString("sehir"));
//				k.setEmail(rs.getString("email"));
//				k.setEmail2(rs.getString("email2"));
//				k.setTelefon(rs.getString("telefon"));
//				k.setTelefon2(rs.getString("telefon2"));
				
				result.add(k);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
}
