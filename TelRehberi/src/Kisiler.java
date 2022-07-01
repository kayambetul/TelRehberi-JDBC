
public class Kisiler {
	
	private int id;
	private String ad;
	private String soyad;
	private String meslek;
	private String sehir;
	private String email;
	private String email2;
	private String telefon;
	private String telefon2;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getMeslek() {
		return meslek;
	}
	public void setMeslek(String meslek) {
		this.meslek = meslek;
	}
	public String getSehir() {
		return sehir;
	}
	public void setSehir(String sehir) {
		this.sehir = sehir;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getTelefon2() {
		return telefon2;
	}
	public void setTelefon2(String telefon2) {
		this.telefon2 = telefon2;
	}
	public Kisiler() {
		this.id = 0;
		this.ad = "";
		this.soyad = "";
		this.meslek = "";
		this.sehir = "";
		this.email = "";
		this.email2 = "";
		this.telefon = "";
		this.telefon2 = "";
	}
	public Kisiler(int id, String ad, String soyad, String meslek, String sehir, String email, String email2,
			String telefon, String telefon2) {
		
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.meslek = meslek;
		this.sehir = sehir;
		this.email = email;
		this.email2 = email2;
		this.telefon = telefon;
		this.telefon2 = telefon2;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ad+soyad;
	}
	
	

}
