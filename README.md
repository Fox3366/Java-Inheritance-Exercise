# Java-Inheritance-Exercise

Aşağıdaki gibi bir menü tasarlayınız. Menüde 7 metot olacaktır. Bu metotlar aşağıdaki metotlara benzer
olacaktır. Örneğin StokMiktarinaGoreUrunFiyatlariGuncelle yerine BirimFiyatlarinaGoreStokSil
yazabilirsiniz. Kesinlikle aynı metot olmayacaktır. SENARYOYU OLUŞTURUNUZ. Gerekli tüm kodlamaları
yapınız. 1. ListeleriOlustur kısmını aynı şekilde gerçekleştirilecektir.
Aşağıdaki gibi esnek bir menü tasarlayınız. Not: Fonksiyon kullanımı zorunludur.
1: FiyataGoreStokGuncelle
2: StokMiktarinaGoreZamYap
3. IcecekFiyatlarinaGoreStokGuncelle
4. CesniAdiGuncelle
5. SutUrunleriniStogaGoreSil
6. TahilUrunuDegistir
7. Çıkış

Urun sınıfını ve ürün sınıfından türetilmiş (5 adet) sınıfları oluşturunuz. Alt Sınıflara ait KategoriAdi ve detay bilgisi
olacaktır. Tüm veriler txt dosyalarından alınacaktır.

1. ListeleriOlustur: Adi, KategoriIndex, BirimAgirligi, BirimFiyatı ve StokMiktari verilen txt listesindeki tüm kayıtları
(25 adet) okuyup (Urun listesi oluşturmadan) doğrudan ilgili alt sınıfa ait listeleri (5 adet) oluşturunuz.
ListeleriOlustur(String dosyaAdi)

2. Urun sınıfına ait metodları oluşturunuz.
Urun -> FiyataGoreStokGuncelle: fiyatı girilen değerden az olan tüm ürünlerin fiyatını güncelleyiniz.
FiyataGoreStokGuncelle(double Sinirfiyat, int eklenecekStok, double guncelFiyat, int guncelStok) Örnek: fiyatı 50 ise 50’den az
olan tüm ürünleri bul ve güncelStok+=EklenecekStok;
Urun -> StokMiktarinaGoreZamYap: Girilen stoktan az ürünleri bul verilen miktar kadar zam
yap. public void StokMiktarinaGoreZamYap(int guncelStok, double guncelFiyat, int sinirStok,
int zam) fiyatı verilenden az ürünleri bul verilen değer kadar zam ekle;

3-4-5-6. Kategori alt sınıflarına ait metodları olusturunuz.
Beverages -> IcecekFiyatlarinaGoreStokGuncelle metodu ile ilgili tüm içecek ürünlerine ait stok güncelle.
IcecekFiyatlarinaGoreStokGuncelle(int guncelStok, int EklenecekStok, int sinirFiyat, double guncelFiyat); Stok miktarı
verilen değerden altta olan içeceklere verilen değer kadar stok ekle;
Condiments -> CesniAdiGuncelle metodu ile listede yer alan N. çeşni nesnesine ait ad bilgisisini güncelleyiniz.
CesniAdiGuncelle(int N, String YeniAd) N=1 ise ilk çeşni nesnesine ait yeniAd değerini ata.
/*Confections -> SekerlemeDetayEkle metodu ile sahip olduğu özelliğe yeni bir detay ekle. SekerlemeDetayEkle(Strin
adi, String yeniDetay) : yeniDetayı mevcut detay bilgisine ekleyiniz. Adi: Tofu ise detay bilgisini sadece bu nesneye
ekle.*/
DairyProducts -> SutUrunleriniStogaGoreSil verilen stok değerinden az olan tüm süt ürünlerini silinir.
void SutUrunleriniStogaGoreSil(List<EtveSutUrunleri_2329> sutListesi), ornek -> verilen stok 10 iste stoğu 10’dan az
olan tüm süt ürünleri silinir
Cereals -> TahilUrunuDegistir metodu ile stok bilgisi verilen tahıl ürünün bütün bilgilerini kullanıcıdan
alarak listedeki ilgili ürünü günceller.


ENGLISH:

Design a flexible menu as shown below. There will be 7 methods in the menu. These methods should be similar to the examples below, but must not be exactly the same. For example, instead of StokMiktarinaGoreUrunFiyatlariGuncelle, you can write BirimFiyatlarinaGoreStokSil. You must create your own scenario. Implement all necessary code. The ListeleriOlustur part must be done exactly as shown.

Design a flexible menu as follows.
Note: Use of functions is mandatory.

1: UpdateStockByPrice  
2: IncreasePriceByStockQuantity  
3: UpdateBeverageStockByPrice  
4: UpdateCondimentName  
5: DeleteDairyProductsByStock  
6: ReplaceCerealProduct  
7: Exit  

Create a Product class and five subclasses derived from the Product class.
Each subclass will have a CategoryName and a Detail field.

All data will be read from .txt files.
1. ListeleriOlustur:

Create five separate subclass lists (do not create a general Product list) by reading 25 records directly from a .txt file. Each record contains the following:
 -   Name
 -   CategoryIndex
 -   UnitWeight
 -   UnitPrice
 -   StockQuantity

Signature:

ListeleriOlustur(String fileName)
2. Methods in the Product class:
a. UpdateStockByPrice:

Update stock for all products whose price is less than a given value.
Signature:

UpdateStockByPrice(double priceThreshold, int stockToAdd, double newPrice, int newStock)

Example: If a product’s price is 50, and the threshold is 50, update all products below 50. Add stockToAdd to their current stock.
b. IncreasePriceByStockQuantity:

Find products whose stock is below a certain amount and increase their price by a given percentage.
Signature:

IncreasePriceByStockQuantity(int currentStock, double currentPrice, int stockThreshold, int increaseAmount)

3-4-5-6. Methods in Subclasses:
a. Beverages -> UpdateBeverageStockByPrice:

Update the stock of all beverage products whose stock is below a given value.
Signature:

UpdateBeverageStockByPrice(int currentStock, int stockToAdd, int priceThreshold, double newPrice)

b. Condiments -> UpdateCondimentName:

Update the name of the N-th condiment product in the list.
Signature:

UpdateCondimentName(int index, String newName)

If index = 1, update the name of the first condiment product.
c. Confections -> AddConfectionDetail:

Append a new detail to the existing detail field of the product.
Signature:

AddConfectionDetail(String name, String newDetail)

If the product’s name is "Tofu", add the newDetail only to that specific product.
d. DairyProducts -> DeleteDairyProductsByStock:

Delete all dairy products whose stock is less than a given value.
Signature:

DeleteDairyProductsByStock(List<DairyProducts> dairyList)

Example: If the stock threshold is 10, delete all dairy products with stock < 10.
e. Cereals -> ReplaceCerealProduct:

Update all information of a cereal product whose stock matches the given stock. User will input all new values.
Signature:

ReplaceCerealProduct()
