import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisKpsService implements KisilerCheckService{

	@Override
	public boolean checkIfRealPerson(Kisiler kisiler) {
		
		boolean state = true;
		try {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
			boolean isValidPerson = kpsPublicSoapProxy.TCKimlikNoDogrula(
				Long.parseLong(kisiler.getNationality()),
				kisiler.getAd().toUpperCase(),kisiler.getSoyad().toUpperCase(),
				kisiler.getBirthDate());
			System.out.println(isValidPerson);
					
			return isValidPerson;
		} catch (Exception e) {
		
			System.out.println("Kişi bulunamadı");
		}
		
		return false;
	}


}
