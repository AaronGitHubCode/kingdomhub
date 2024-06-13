package app.kh.utils;

public interface INotificationService {
    void onNotify(
            final String title,
            final String content,
            final int smallIcon,
            final int largeIcon
    );
}
