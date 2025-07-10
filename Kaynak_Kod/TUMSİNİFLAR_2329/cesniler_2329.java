
import java.util.ArrayList;
import java.util.List;

public class cesniler_2329 extends Urun {

	
	public static List<cesniler_2329> cesniListesi = new ArrayList<>();
	public cesniler_2329(String adi, int kategoriIndex, int birimAgirligi, double birimFiyati, int stokMiktari)
	{
		super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
		cesniListesi.add(this);
	}
	
	public static void CesniAdiGuncelle(int N, String YeniAd) // N. çeşniye ait adi guncelle
	{
		int sayac = 1;
		boolean kontrol = true;
		for (Urun urun : cesniListesi) {
			if(sayac == N)
			{
				urun.setAdi(YeniAd);
				kontrol = false;
				System.out.println("Cesni yeni adi: "+YeniAd);
				break;
			}
			else
			{
				sayac++;
			}
		}
		if(kontrol)
		{
			System.out.println("Cesni indexi bulunamadı!!!");
		}
	}
	
	

}
