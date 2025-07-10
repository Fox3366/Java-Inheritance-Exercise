import java.util.ArrayList;
import java.util.List;

public class sekerlemeler_2329 extends Urun {

	public static List<Urun> sekerlemeListesi = new ArrayList<>();
	public sekerlemeler_2329(String adi, int kategoriIndex, int birimAgirligi, double birimFiyati, int stokMiktari)
	{
		super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
		sekerlemeListesi.add(this);
	}
	
	public void yazdirUrunler()
	{
        System.out.println("ŞEKERLEMELER:");
        for (Urun urun : sekerlemeListesi)
        {
            System.out.println("Ürün Adı: " + urun.adi);
            System.out.println("Kategori Index: " + urun.kategoriIndex);
            System.out.println("Birim Ağırlığı: " + urun.birimAgirligi);
            System.out.println("Birim Fiyatı: " + urun.birimFiyati);
            System.out.println("Stok Miktarı: " + urun.stokMiktari);
            System.out.println("-----------------------");
        }
	 }

}
