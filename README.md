# CleanYouTV · ArmyDock edition

Project Android Studio được tùy chỉnh từ CleanYourTV theo yêu cầu:

- Giao diện xanh quân đội; nút tròn “Dọn một tivi” lớn; giữ icon/tên app, giấy phép mã nguồn mở và dòng “Thanks for VGS · Copyright Gathin23”.
- Tắt thông báo và lịch kiểm tra cập nhật phiên bản app.
- Quy trình dọn tivi, khôi phục và chọn launcher sau khi bỏ qua bước dọn.
- Màn Home có các lựa chọn cài ArmyDock, HomeVGS và HomeVGS Xiaomi.
- Remote chỉ giữ điều hướng, âm lượng, nguồn và phát/dừng; cài APK và quản lý app nằm riêng bên ngoài màn remote.
- Đã bỏ thẻ cộng đồng/góp ý, hướng dẫn bật gỡ lỗi, xem màn hình TV và gõ chữ lên TV.

## Mở và tự build

1. Mở Android Studio, chọn **Open**, rồi chọn thư mục chứa file `settings.gradle.kts` này.
2. Chờ Gradle Sync hoàn tất.
3. Chọn **Build → Build Bundle(s) / APK(s) → Build APK(s)** để tạo APK debug.

APK ArmyDock được đóng gói tại `app/src/main/assets/armylauncher.apk`. Hai APK HomeVGS hiện có trong assets là `tvhome.apk` và `tvhome-xiaomi.apk`.

Không có APK mới được build trong lần chỉnh sửa này.
