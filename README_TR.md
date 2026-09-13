# my.Soisyl - Android Bildirim Uygulaması

## 📋 İçerik
- Firebase Cloud Messaging (FCM) ile push bildirim altyapısı
- Android 13+ bildirim izni yönetimi
- Bildirim kanalı ve dinamik bildirim gösterimi
- FCM token yenileme noktası
- Kullanıcı geri bildirimi için API istemcisi
- Örnek Node.js backend

## 🚀 Kurulum Adımları

### Android Uygulaması
1. Android Studio'da projeyi açın
2. [Firebase Console](https://console.firebase.google.com) adresine gidin
3. Yeni bir Firebase projesi oluşturun veya mevcut projeyi seçin
4. Android uygulaması ekleyin:
   - Package name: `com.mysoisyl.app`
   - Debug signing certificate SHA-1 ekleyin
5. `google-services.json` dosyasını indirin
6. `app/` klasörüne kopyalayın (mevcut `google-services.json.example` dosyasının yerine)
7. Firebase Cloud Messaging'i etkinleştirin
8. `app/src/main/java/com/mysoisyl/app/ApiConfig.kt` içindeki `FEEDBACK_URL` değerini kendi API adresinizle değiştirin:
   ```kotlin
   const val FEEDBACK_URL = "https://your-backend.com/api/feedback"
   ```
9. Uygulamayı Android Studio'da çalıştırın veya APK oluşturun

### Backend Kurulumu
1. Node.js yüklü olduğundan emin olun
2. Proje klasöründe çalıştırın:
   ```bash
   npm install
   node server.js
   ```
3. Backend `http://localhost:3000` adresinde çalışacak
4. Android uygulamasındaki `FEEDBACK_URL` bunu işaret etmelidir (production için gerçek URL)

## 📱 Özellikler

### Bildirim Sistemi
- ✅ FCM ile push bildirim alma
- ✅ Android 13+ bildirim izni isteği
- ✅ Bildirim kanalı oluşturma (IMPORTANCE_HIGH)
- ✅ Bildirim başlığı ve gövdesini data/notification'dan al
- ✅ Bildirimi tıklaması MainActivity'ye döner

### Geri Bildirim Sistemi
- ✅ HTTP POST ile backend'e geri bildirim gönderimi
- ✅ JSON formatı: `{"userId": "...", "message": "..."}`
- ✅ Background thread'de istek gönderimi
- ✅ Başarı/başarısızlık bildirimi

## 🔧 Proje Yapısı

```
my-soisyl/
├── app/
│   ├── build.gradle.kts          # App-level Gradle config
│   ├── google-services.json       # Firebase config (siz ekleyeceksiniz)
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/com/mysoisyl/app/
│           │   ├── MainActivity.kt
│           │   ├── MyFirebaseMessagingService.kt
│           │   ├── FeedbackApi.kt
│           │   └── ApiConfig.kt
│           └── res/
│               ├── drawable/
│               │   └── ic_notification.xml
│               └── values/
│                   ├── strings.xml
│                   └── themes.xml
├── build.gradle.kts              # Root Gradle config
├── gradle.properties
├── settings.gradle.kts
├── proguard-rules.pro            # ProGuard optimization
├── server.js                     # Backend örneği
├── package.json
└── README.md
```

## 🔐 Production Kontrol Listesi

- [ ] Firebase Console'da Push Notifications etkin
- [ ] Backend'de authentication (API key, JWT, vb.)
- [ ] Backend'de rate limiting
- [ ] Backend'de veritabanı (feedback depolamak için)
- [ ] Backend'de CORS konfigürasyonu
- [ ] `ApiConfig.kt` production URL'sine güncellenmiş
- [ ] ProGuard/R8 optimization etkin
- [ ] Signed APK oluşturulmuş
- [ ] Firebase Cloud Messaging tokens veritabanında depolanmış

## 📞 Support

- Firebase: https://firebase.google.com/docs
- Android FCM: https://developer.android.com/develop/connectivity/fcm
- Express.js: https://expressjs.com

## 💡 İsim Alternatifleri

- **my.Soisyl** (önerilen)
- Soisyl
- my.Social
- Soisyl Notify
- my.Notify
- Soisyl Connect
