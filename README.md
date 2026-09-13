# my.Soisyl

Android bildirim ve kullanıcı geri bildirim uygulaması için başlangıç projesi.

## İçerik
- Firebase Cloud Messaging (FCM) ile push bildirim altyapısı
- Android 13+ bildirim izni
- Bildirim kanalı ve bildirim gösterimi
- FCM token yenileme noktası
- Kullanıcı geri bildirimi için API istemcisi
- Örnek Node.js backend

## Kurulum
1. Android Studio ile projeyi açın.
2. Firebase Console'da Android uygulaması oluşturun.
3. `google-services.json` dosyasını `app/` klasörüne koyun.
4. Firebase Cloud Messaging'i etkinleştirin.
5. `ApiConfig.kt` içindeki `FEEDBACK_URL` değerini kendi API adresinizle değiştirin.
6. Uygulamayı çalıştırın.

Not: `google-services.json` dosyasını bu ZIP'e koymadım. Kendi Firebase projenizin dosyasını ekleyin. Production için backend'de authentication, rate limiting ve veritabanı kullanın.

## İsim
Önerilen marka: **my.Soisyl**
Alternatifler: Soisyl, my.Social, Soisyl Notify, my.Notify, Soisyl Connect.