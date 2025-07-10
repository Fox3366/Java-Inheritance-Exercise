import java.util.ArrayList;
import java.util.List;

public class icecekler_2329 extends Urun {
	
	public static  int sonKullanmaTarihineKalanGun = 0;
	public String kategorAdi;
	
	
	public String getKategorAdi() {
		return kategorAdi;
	}

	public void setKategorAdi(String kategorAdi) {
		this.kategorAdi = kategorAdi;
	}

	public static List<icecekler_2329> icecekListesi = new ArrayList<>();
	public icecekler_2329(String adi, int kategoriIndex, int birimAgirligi, double birimFiyati, int stokMiktari, String kategoriAdi)
	{
		super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
		this.kategorAdi = kategoriAdi;
		icecekListesi.add(this);
	}
	
	public void IcecekFiyatlarinaGoreStokGuncelle(int guncelStok, int EklenecekStok, int sinirFiyat, double guncelFiyat)
	{
		if(sinirFiyat > guncelFiyat)
		{
			guncelStok+=EklenecekStok;
			setStokMiktari(guncelStok);
		}
	}
	
}
