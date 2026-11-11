package zone.vgs.tvsach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import zone.vgs.tvsach.ui.UngDung

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Conscrypt cho TLS của Gỡ lỗi không dây (ghép đôi + kết nối).
        runCatching { java.security.Security.insertProviderAt(org.conscrypt.Conscrypt.newProvider(), 1) }
        ManHinh.doc(this)
        CapNhat.donOtaCuNeuDoiBan(this)
        Dem.moApp(this)
        ThongBaoCapNhat.tat(this)
        enableEdgeToEdge()
        setContent { UngDung() }
    }
}
