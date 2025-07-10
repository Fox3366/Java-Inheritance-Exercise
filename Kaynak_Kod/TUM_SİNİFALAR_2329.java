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



public class Urun
{
	public String adi;
	public int kategoriIndex;
	public int birimAgirligi;
	public double birimFiyati;
	public int stokMiktari;
	
	
	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public int getKategoriIndex() {
		return kategoriIndex;
	}

	public void setKategoriIndex(int kategoriIndex) {
		this.kategoriIndex = kategoriIndex;
	}

	public int getBirimAgirligi() {
		return birimAgirligi;
	}

	public void setBirimAgirligi(int birimAgirligi) {
		this.birimAgirligi = birimAgirligi;
	}

	public double getBirimFiyati() {
		return birimFiyati;
	}

	public void setBirimFiyati(double birimFiyati) {
		this.birimFiyati = birimFiyati;
	}

	public int getStokMiktari() {
		return stokMiktari;
	}

	public void setStokMiktari(int stokMiktari) {
		this.stokMiktari = stokMiktari;
	}
	

    public Urun(String adi, int kategoriIndex, int birimAgirligi, double birimFiyati, int stokMiktari) {
        this.adi = adi;
        this.kategoriIndex = kategoriIndex;
        this.birimAgirligi = birimAgirligi;
        this.birimFiyati = birimFiyati;
        this.stokMiktari = stokMiktari;
    }
    
    public void FiyataGoreStokGuncelle(double Sinirfiyat, int eklenecekStok, double guncelFiyat, int guncelStok)
    {
    	if(Sinirfiyat > guncelFiyat)
    	{
    		guncelStok+=eklenecekStok;
    		setStokMiktari(guncelStok);
    	}
    }
    
    public void StokMiktarinaGoreZamYap(int guncelStok, double guncelFiyat, int sinirStok, int zam)
    {
    	if(guncelStok < sinirStok)
    	{
    		guncelFiyat+=zam;
    		setBirimFiyati(guncelFiyat);
    	}
    }
    

	@Override
	public String toString() {
		return "Urun [adi=" + adi + ", kategoriIndex=" + kategoriIndex + ", birimAgirligi=" + birimAgirligi
				+ ", birimFiyati=" + birimFiyati + ", stokMiktari=" + stokMiktari + "]";
	}
    
    
   

}


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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EtveSutUrunleri_2329 extends Urun
{
	public static List<EtveSutUrunleri_2329> sutUrunleriListesi = new ArrayList<>();
	public EtveSutUrunleri_2329(String adi, int kategoriIndex, int birimAgirligi, double birimFiyati,int stokMiktari)
	{
		super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
		sutUrunleriListesi.add(this);
	}
	static Scanner scanner = new Scanner(System.in);
	public static void SutUrunleriniStogaGoreSil(List<EtveSutUrunleri_2329> sutListesi) {
        System.out.print("Sınır stok---> ");
        int sinirStok = scanner.nextInt();

        sutListesi.removeIf(sutUrunu -> sutUrunu.getStokMiktari() < sinirStok);

        System.out.println("Güncellenmiş liste:");
        for (EtveSutUrunleri_2329 urun : sutListesi) {
            System.out.println(urun.getAdi() + " - Stok: " + urun.getStokMiktari());
        }
    }
}


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
