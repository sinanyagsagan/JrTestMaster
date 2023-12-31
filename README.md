<big>Selenium Web Otomasyon:</big>

Bu proje, Selenium, JUnit ve Log4J kütüphanelerini kullanarak bir web uygulamasında otomasyon testlerini gerçekleştirmek 
amacıyla oluşturulmuştur. Proje, Java programlama dili ve Maven projesi olarak geliştirilmiştir.

<big>Gereksinimler:</big>

Java 8 veya daha yeni sürüm
Maven (Proje bağımlılıklarını yönetmek için)
WebDriver (Tarayıcı otomasyonu için) Chormedriver kullanılmıştır.

Proje, aşağıdaki ana klasörlerden oluşmaktadır:

src/main/java: Ana Java kodu

src/test/java: Test kodları

<big>Testler:</big>

Proje, aşağıdaki test senaryolarını içermektedir:

**testGoToWebSite:** Web sitesine başarıyla gidilmesini kontrol eder.

**testIsUrlCorrect:** Web sitesinin doğru URL'ye sahip olup olmadığını kontrol eder.

**testIsHotelTabDefaultSelected:** Otel sekmesinin varsayılan olarak seçili olup olmadığını kontrol eder.

**testSelectAntalyaFromDropdown:** CSV dosyasından Antalya yazdırlması ve Antalya'nın bir dropdown menüsünden başarıyla seçilmesini kontrol eder.

**testSelectDataPicker:** Tarih seçme işleminin başarıyla gerçekleşip gerçekleşmediğini kontrol eder.

**testIncreaseAdultAndCheckAdultNumber:** Yetişkin sayısının artırılması ve kontrol edilmesini sağlar.

**testCheckedSubmitButtonAndClicked:** Ara butonunun başarıyla tıklanmasını kontrol eder.

**testSearchPageUrlContainAntalya:** Arama sayfasının URL'sinde "Antalya" ifadesini içerip içermediğini kontrol eder.

**testSaveNumberWithRandomClickMethodInShowAnotherLocation:** "Başka Bir Konumu Göster" işlevinde sayıyı rastgele tıklama yöntemiyle kaydetmeyi kontrol eder.

**testRelatedFieldScrollAndCheckValue:** İlgili alanın kaydırılması ve değer kontrolünü gerçekleştirir.

