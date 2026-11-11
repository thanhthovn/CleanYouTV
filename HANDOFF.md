# HANDOFF — CleanYouTV

## Mục tiêu

Tùy biến repo Android đã clone thành project **CleanYouTV** để mở bằng Android Studio và tự build APK. Mục tiêu gồm giao diện tiếng Việt tông xanh quân đội, dọn TV, cài launcher theo từng bước và khôi phục khi cần.

## Project

`C:\Users\sky86\Documents\Codex\2026-11-04\files-mentioned-by-the-user-codex\outputs\CleanTV-ArmyDock-Project`

Các APK launcher liên quan: `armylauncher.apk`, `tvhome.apk`, `tvhome-xiaomi.apk`. Người dùng cũng cung cấp icon và banner, với yêu cầu chọn kích thước phù hợp thiết bị và tránh làm tăng dung lượng không cần thiết.

## Các thay đổi chính đã thực hiện

- Đổi tên app và tiêu đề sang **CleanYouTV**, cập nhật icon/banner theo yêu cầu và đổi giao diện sang tông xanh quân đội.
- Tinh chỉnh nút Dọn TV dạng tròn, kích thước/căn giữa, viền focus và các màu nút theo ảnh tham khảo.
- Bỏ tiện ích Khóa trẻ em, hẹn giờ tắt TV và các hướng dẫn/phần giao diện người dùng yêu cầu loại bỏ.
- Thêm cảnh báo **“HÃY BẬT GỠ LỖI USB!!!”**.
- Sắp xếp lại tiện ích kết nối, cài APK, remote, quản lý app và khôi phục.
- Thêm danh sách TV đã dọn và thẻ thông tin thiết bị gồm tên, IP, Android, bộ nhớ; màn hoàn tất hiển thị số gói đã dọn, bộ nhớ và thời gian.
- Thêm cài **ArmyDock**, **HomeVGS** và **HomeVGS Xiaomi**; lựa chọn Xiaomi chỉ hiện khi nhận diện TV Xiaomi.
- Cài launcher theo từng bước, hiển thị lệnh/kết quả mỗi bước; thêm bước mở thử, tắt Home gốc khi nhận diện an toàn và ghi chú mở lại CleanYouTV.
- Thêm SOS khôi phục TV; tách mô tả ứng dụng khỏi khối lệnh để các lệnh hiển thị là cú pháp có thể chạy.
- Đổi nút thành **“TIỆN ÍCH”**, thêm tên launcher đã cài vào màn hình hoàn tất.
- Giải thích lệnh `pm enable com.google.android.tungsten.setupwraith`: đây là package liên quan setupwraith trên một số Google TV, không phải lệnh dùng chung cho mọi thiết bị.

## Tiến độ cài launcher và SOS

Đã xử lý rủi ro cài launcher bị gián đoạn trước khi các cờ `launcherDaCai`/`armyLauncherDaCai` được ghi:

- `app/src/main/java/zone/vgs/tvsach/dulieu/SaoLuu.kt`: lưu loại launcher đang cài và bước thành công gần nhất; đọc được bản sao lưu cũ bằng giá trị mặc định.
- `app/src/main/java/zone/vgs/tvsach/ui/PhienLamViec.kt`: ghi ý định trước khi chạy lệnh và cập nhật tiến độ sau từng bước thành công.
- `app/src/main/java/zone/vgs/tvsach/adb/ThaoTacTv.kt`: SOS xét tiến độ đã lưu, Home hiện tại và launcher thực tế trên TV; đặt lại Home gốc trước khi gỡ launcher và giữ tiến độ nếu khôi phục lỗi. Việc tắt Home gốc được ghi sau khi xác nhận package thực sự ở trạng thái disabled.
- `app/src/main/java/zone/vgs/tvsach/ui/UngDung.kt`: danh sách SOS dựa theo tiến độ, bao gồm đúng package HomeVGS Xiaomi khi cần.

## Trạng thái và việc tiếp theo

- Luồng ArmyDock trên Google TV: cài và mở thử ArmyDock trước; kiểm tra mạng đang dùng. Nếu `setupwraith` đang giữ Wi-Fi, mặc định chặn thao tác và giữ Home Google làm dự phòng; người dùng có thể chọn buộc tắt sau cảnh báo xác nhận. Đăng ký watchdog trước khi takeover, sau đó mới tắt Home Google, đặt ArmyDock làm Home và xác nhận app foreground sau phím Home. SOS/watchdog có danh sách bật lại các gói đã tắt.
- Khi buộc tắt `setupwraith`, Wi-Fi/ADB có thể rớt. Watchdog thử bật lại `setupwraith` và Home gốc, nhưng không bảo đảm tự khôi phục Wi-Fi; cần LAN hoặc kết nối lại Wi-Fi qua Cài đặt. Home Google không bị tắt nếu ArmyDock chưa mở thử được.
- Luồng ArmyDock cài trực tiếp dùng cùng kiểm tra setupwraith, thử mở trước khi tắt Home và giữ watchdog cho đến khi xác nhận ArmyDock đang hiện.
- Đây chưa phải kiểm tra sau khởi động lại TV. Khi cài trên TV thật, vẫn cần giữ khả năng kết nối ADB/SOS trong lúc khởi động lại và xác nhận ArmyDock tiếp tục nhận nút Home.
- Những thay đổi này mới sửa source, chưa build APK; người dùng cần build lại trong Android Studio mới có hiệu lực.
- **Chưa chạy Gradle build hoặc kiểm thử trên TV sau các chỉnh sửa gần nhất.** Mở project bằng Android Studio và build để phát hiện lỗi biên dịch.
- Nên thử SOS trên TV thử nghiệm khi bị ngắt sau các mốc: cài APK, tắt Home gốc và hoàn tất cài launcher.
- Với backup cũ không có trường tiến độ, SOS dùng giá trị mặc định và tiếp tục dựa vào cờ cũ cùng trạng thái thực tế trên TV.
- Project hiện tại: `C:\Users\sky86\Documents\Codex\2026-11-04\files-mentioned-by-the-user-codex\outputs\CleanTV-ArmyDock-Project`
