# Gezgin-Zeplin-Problemi
Programlama Lab. II, 2017-2018 Bahar Proje I

## Ekran Görüntüsü

### Problem 1

![](/problem%201.gif)

### Problem 2

![](/problem%202.gif)

**Giriş:** En kısa yol problemi, bir ba¸slangıç dugum¨unden bir bitii dugumune en az maliyeti olan yolu bulma problemidir.

Bir nakliye firmasının en az maliyetli taşıma ağını yapması, bir kargo firmasının en az
maliyetle da˘gıtım yapması, internet ağ trafiği protokolü problemleri kullanım alanlarına
örnek olarak verilebilir.

**Amaç:** Projeyi yapan kişi için veri yapıları ve veri modellerini anlaması, graf yapısını kullanması
ve algoritma mantığı kullanarak bir probleme çözüm sağlayabilmesi amaçlanmaktadır


## Problem
Bir turizm firması yeni geliştirilen Zeplin aracı ile turistlere Türkiye’yi minimum maliyet
ve maksimum karla gezdirmeyi planlamaktadır. Bu hedefi gerçekleştirebilmek için size
başvurmaktadır.

Firmanın talepleri:
Sabit ücret 20 TL olarak alındığında kaç yolcu ile sefer düzenlenirse maksimum kar elde edilir?

Bir yolcudan kaç TL alınırsa yüzde 50 kara ulaşılır?

## Aracın özellikleri:

Geliştirilen Zeplin aracının özellikleri şunlardır:
- Yolcu kapasitesi maksimum 50 minimum 5’tir.
- Tamamen doluyken en fazla 30 derecelik e˘gimle gidebilecegi sehirlere hareket edebilir.
- Her binen kisi maksimum hareket e˘gim kabiliyetini 1 derece azaltmaktadır.
- Havalandıktan sonra yerden yüksekliği eğime baglı olarak belirli bir mesafeyi koruyacak, sekilde hareket edebilmektedir.
- Bir ¸sehirden ba¸ska bir ¸sehire giderken kom¸su ¸sehirlerden birinden ge¸cmek zorundadır.
- Yerden 50 m sabit yukseklikte hareket etmektedir.
- 100 km’nin Zeplin’e maliyeti 1000 TL’dir.

## Ornek Hesaplama

50 yolcuyla A noktasından B noktasına giden Zeplin aracı icin lat long bilgileri kullanılarak aradaki mesafenin 207 km oldugu bulunmustur. A noktasının deniz seviyesinden yuksekligi (rakım) 20 m, B’nin rakımı 100 m’dir. Aracın B’den ge¸cebilmesi icin B noktasından 40 m yukseklige ulasılabilir olması gerekti˘gi bilgisi alınmı¸stır.Aracın noktalar arasında dogrusal olarak hareket ettigi dusunulurse A noktasından B’ye gidilebilmesi icin egimin 30 dereceden fazla olmaması gerekir.

**arctan(120/207) = 30**

## Cıktı
- Konum ve guzergah bilgileri ayrı ayrı harita uzerinde gosterilmelidir (resim vs).
- Sabit ucretle kac yolcu ile sefer duzenlenirse en ¸cok karı yapabilirim probleminde; 5 ile 50 arasındaki yolcu sayıları kadar olan yolcu sayısı icin en iyi cozumu veren yol (harita uzerinde) ve girdi olarak alınan sehirler arasındaki toplam yollar ayrı ayrı cıktı olarak verilmelidir. Cıktı uzerinde maksimum kar hesaplanarak en iyi sonuca gore sıralanmalıdır.
- Bir yolcudan kac TL alınırsa yuzde 50 kar yapılabilir probleminde; 10,20,30,40,50 yolcu sayıları icin en iyi cozumu veren yol (harita uzerinde) ve girdi olarak alınan ¸sehirler arasındaki toplam yollar ayrı ayrı cıktı olarak verilmelidir. Cıktı uzerinde kar miktarı yuzde 50 olacak sekilde bir yolcudan alınması gereken para miktarı hesaplanmalıdır.
- Her iki problem i¸cin lat, long ve kom¸sular arasındaki mesafeler bir dosyaya yazılmalıdır.
- Calısma sureleri gosterilmelidir.

