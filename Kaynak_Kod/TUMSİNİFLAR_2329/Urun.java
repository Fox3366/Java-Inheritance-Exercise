
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
