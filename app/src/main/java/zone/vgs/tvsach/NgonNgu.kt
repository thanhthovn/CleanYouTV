package zone.vgs.tvsach

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * Giao diện tiếng Việt.
 */
object NgonNgu {
    var tiengViet by mutableStateOf(true)
        private set

    fun nap(ctx: Context) {
        tiengViet = true
    }
}

fun t(vi: String, en: String): String = if (NgonNgu.tiengViet) vi else en
