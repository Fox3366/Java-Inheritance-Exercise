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
