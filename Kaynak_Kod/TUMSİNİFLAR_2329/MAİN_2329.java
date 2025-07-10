import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class MAİN_2329 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		String dosyaAdi = "Urun.txt";
		listeOlustur(dosyaAdi);
		while(true)
		{
			System.out.println("1 - Fiyata Göre Stok Güncelle");
			System.out.println("2 - Stok Miktarına Göre Zam Yap");
			System.out.println("3 - İçecek Fiyatlarına Göre Stok Güncelle");
			System.out.println("4 - Çeşni Adı Güncelle");
			System.out.println("5 - Süt Ürünlerini Stoğa Göre Sil");
			System.out.println("6 - Tahıl Ürünü Bilgilerini Değiştir");
			System.out.println("7 - Çıkış");
			int secim = scanner.nextInt();
			switch(secim)
			{
				case 1:
				{
					System.out.println("Sınır Fiyatı giriniz--->");
					int sinirfiyat = scanner.nextInt();
					System.out.println("Eklenecek Stok giriniz--->");
					int eklenecekStok = scanner.nextInt();
					FiyataGoreStokGuncelle(icecekler_2329.icecekListesi,sinirfiyat,eklenecekStok);
					FiyataGoreStokGuncelle(cesniler_2329.cesniListesi,sinirfiyat,eklenecekStok);
					FiyataGoreStokGuncelle(sekerlemeler_2329.sekerlemeListesi,sinirfiyat,eklenecekStok);
					FiyataGoreStokGuncelle(EtveSutUrunleri_2329.sutUrunleriListesi,sinirfiyat,eklenecekStok);
					FiyataGoreStokGuncelle(tahilUrunleri_2329.tahilUrunleriListesi,sinirfiyat,eklenecekStok);
					yazdir(icecekler_2329.icecekListesi);
					yazdir(cesniler_2329.cesniListesi);
					yazdir(sekerlemeler_2329.sekerlemeListesi);
					yazdir(EtveSutUrunleri_2329.sutUrunleriListesi);
					yazdir(tahilUrunleri_2329.tahilUrunleriListesi);
					break;
				}
				case 2:
				{
					System.out.println("Stok miktarını giriniz--->");
					int sinirStok = scanner.nextInt();
					System.out.println("Zam miktari--->");
					int zam = scanner.nextInt();
					StokMiktarinaGoreZamYap(icecekler_2329.icecekListesi,sinirStok,zam);
					StokMiktarinaGoreZamYap(cesniler_2329.cesniListesi,sinirStok,zam);
					StokMiktarinaGoreZamYap(sekerlemeler_2329.sekerlemeListesi,sinirStok,zam);
					StokMiktarinaGoreZamYap(EtveSutUrunleri_2329.sutUrunleriListesi,sinirStok,zam);
					StokMiktarinaGoreZamYap(tahilUrunleri_2329.tahilUrunleriListesi,sinirStok,zam);
					yazdir(icecekler_2329.icecekListesi);
					yazdir(cesniler_2329.cesniListesi);
					yazdir(sekerlemeler_2329.sekerlemeListesi);
					yazdir(EtveSutUrunleri_2329.sutUrunleriListesi);
					yazdir(tahilUrunleri_2329.tahilUrunleriListesi);
					break;
				}
				case 3:
				{
					System.out.println("Eklenecek stok miktarı--->");
					int eklenecekStok = scanner.nextInt();
					IcecekFiyatlarinaGoreStokGuncelle(icecekler_2329.icecekListesi,eklenecekStok);
					yazdir(icecekler_2329.icecekListesi);
					break;
				}
				case 4:
				{
					CesniAdiGuncelle(cesniler_2329.cesniListesi);
					yazdir(cesniler_2329.cesniListesi);
					break;
				}
				case 5:
				{
					EtveSutUrunleri_2329.SutUrunleriniStogaGoreSil(EtveSutUrunleri_2329.sutUrunleriListesi);
					yazdir(EtveSutUrunleri_2329.sutUrunleriListesi);
					break;
				}
				case 6:
				{
					tahilUrunleri_2329.TahilUrunuDegistir();
					yazdir(tahilUrunleri_2329.tahilUrunleriListesi);
					break;
				}
				case 7:
				{
					System.out.println("Cıkış yapıldı!!!");
					System.exit(0);
					break;
				}
				default:
				{
					System.out.println("hatali tuşlama!!!");
					break;
				}
			}
		}
		
		
	}

	
	public static void CesniAdiGuncelle(List<cesniler_2329> cesniListesi)
	{
		System.out.println("Yeni adi--->");
		String yeniAd = scanner.next();
		
		System.out.println("Cesni indexi--->");
		int N = scanner.nextInt();
		cesniler_2329.CesniAdiGuncelle(N, yeniAd);
		
//		for (cesniler_2329 cesni : cesniListesi) {
//			cesni.CesniAdiGuncelle(N, yeniAd);
//		}
//		
	}
	
	public static void IcecekFiyatlarinaGoreStokGuncelle(List<icecekler_2329>list, int eklenecekStok)
	{
		System.out.println("Sınır Fiyat--->");
		int sinirFiyat = scanner.nextInt();
		for (icecekler_2329 urun : list) {
			if(sinirFiyat > urun.getBirimFiyati())
			{
				urun.IcecekFiyatlarinaGoreStokGuncelle(urun.getStokMiktari(), eklenecekStok, sinirFiyat, urun.getBirimFiyati());
			}
		}
	}
	
	public static void FiyataGoreStokGuncelle(List< ? extends Urun>list, int Sinirfiyat, int eklenecekStok)
	{
		for (Urun urun : list) {
			urun.FiyataGoreStokGuncelle(Sinirfiyat, eklenecekStok, urun.getBirimFiyati(), urun.getStokMiktari());
		}
	}
	
	public static void StokMiktarinaGoreZamYap(List< ? extends Urun>list, int sinirStok,int zam)
	{
		for (Urun urun : list) {
			if(urun.getStokMiktari() < sinirStok)
			{
				urun.StokMiktarinaGoreZamYap(urun.getStokMiktari(), urun.getBirimFiyati(), sinirStok,zam);
			}
		}
	}
	
	public static void yazdir(List< ? extends Urun>list)
	{
		for (Urun urun : list) {
			System.out.println(urun);
		}
	}

	public static void listeOlustur(String dosyaAdi) throws NumberFormatException, IOException
	{

        	BufferedReader br = new BufferedReader(new FileReader(dosyaAdi));
            String satir;
            boolean ilkSatir = true;

            while((satir = br.readLine()) != null)
            {
                if(ilkSatir)
                {
                    ilkSatir = false;
                    continue;
                }

                String[] parcalar = satir.split("\\s+");

                if(parcalar.length == 5)
                {
                    String adi = parcalar[0];
                    int kategoriIndex = Integer.parseInt(parcalar[1]);
                    int birimAgirligi = Integer.parseInt(parcalar[2]);
                    double birimFiyati = Double.parseDouble(parcalar[3]);
                    int stokMiktari = Integer.parseInt(parcalar[4]);
                    
                    if(kategoriIndex == 1)
                    {
                    	new icecekler_2329(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari, "Icecek");
                    }
                    else if(kategoriIndex == 2)
                    {
                    	new cesniler_2329(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
                    }
                    else if(kategoriIndex == 3)
                    {
                    	new sekerlemeler_2329(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
                   	}
                    else if(kategoriIndex == 4)
                    {
                    	new EtveSutUrunleri_2329(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
                    }
                    else
                    {
                    	new tahilUrunleri_2329(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
                    }
//                    Urun urun = new Urun(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
                }
                else
                {
                    System.out.println("Hatalı format: " + satir);
                }
            }
            br.close();
    }
	
}
