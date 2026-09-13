package com.mysoisyl.app

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= 33 &&
            ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 100)
        }

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(40, 50, 40, 40)
        }
        val title = TextView(this).apply { text = "my.Soisyl"; textSize = 30f }
        val info = TextView(this).apply {
            text = "Bildirimler ve kullanıcı geri dönüşleri"
            textSize = 18f
            setPadding(0, 20, 0, 30)
        }
        val feedback = EditText(this).apply {
            hint = "Geri bildiriminizi yazın"
            minLines = 4
            gravity = android.view.Gravity.TOP
        }
        val send = Button(this).apply {
            text = "Geri Bildirim Gönder"
            setOnClickListener {
                val text = feedback.text.toString().trim()
                if (text.isEmpty()) {
                    Toast.makeText(this@MainActivity, "Lütfen geri bildirim yazın.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                FeedbackApi.sendFeedback("anonymous", text) { ok ->
                    runOnUiThread {
                        Toast.makeText(
                            this@MainActivity,
                            if (ok) "Geri bildirim gönderildi." else "Sunucu bağlantısı yapılandırılmamış.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
        layout.addView(title); layout.addView(info); layout.addView(feedback); layout.addView(send)
        setContentView(layout)
    }
}