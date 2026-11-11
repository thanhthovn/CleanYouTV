package zone.vgs.tvsach

import android.content.Context
import androidx.core.app.NotificationManagerCompat
import androidx.work.WorkManager

/** Tắt lịch cập nhật cũ và xoá thông báo nâng cấp còn tồn tại trên thiết bị. */
object ThongBaoCapNhat {
    fun tat(ctx: Context) {
        WorkManager.getInstance(ctx).cancelUniqueWork("kiem-tra-ban-moi")
        NotificationManagerCompat.from(ctx).cancel(1)
    }
}
