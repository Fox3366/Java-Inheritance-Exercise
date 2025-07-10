import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tahilUrunleri_2329 extends Urun
{
	public static List<tahilUrunleri_2329> tahilUrunleriListesi = new ArrayList<>();
	public tahilUrunleri_2329(String adi, int kategoriIndex, int birimAgirligi, double birimFiyati, int stokMiktari) {
		super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
		tahilUrunleriListesi.add(this);
	}
	static Scanner scanner = new Scanner(System.in);
	
	public static void TahilUrunuDegistir()
	{
		System.out.println("Degistirmek istediginiz tahilin stok miktarını giriniz--->");
		int stokKontrol = scanner.nextInt();
		System.out.println("Sirasiyla adi, kategoriİndexi, birimAgirligi, birimFiyatı, stokMiktari giriniz--->");
		String adi = scanner.next();
		int kategoriIndex = scanner.nextInt();
		int birimAgirligi = scanner.nextInt();
		double birimFiyati = scanner.nextDouble();
		int stokMiktari = scanner.nextInt();
		
		for (tahilUrunleri_2329 urunTahil : tahilUrunleriListesi) {
			if(urunTahil.getStokMiktari() == stokKontrol)
			{
				urunTahil.setAdi(adi);
				urunTahil.setKategoriIndex(kategoriIndex);
				urunTahil.setBirimAgirligi(birimAgirligi);
				urunTahil.setBirimFiyati(birimFiyati);
				urunTahil.setStokMiktari(stokMiktari);
			}
		}
	}
	
}
