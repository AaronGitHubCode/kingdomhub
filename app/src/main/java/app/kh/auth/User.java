package app.kh.auth;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public final class User {
    private String username;
    private String email;

    private android.net.Uri photoUrl;

    public static final class Builder {
        private String username;
        private String email;

        private android.net.Uri photoUrl;

        public Builder setUsername(final String username) {
            this.username = username;
            return this;
        }

        public Builder setEmail(final String email) {
            this.email = email;
            return this;
        }

        public Builder setPhotoUrl(final android.net.Uri photoUrl) {
            this.photoUrl = photoUrl;
            return this;
        }

        public User build() {
            return new User(
                    username,
                    email,
                    photoUrl
            );
        }
    }

    public User() {}

    public User(
            final String username,
            final String email,
            final android.net.Uri photoUrl
    ) {
        this.username = username;
        this.email = email;
        this.photoUrl = photoUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public android.net.Uri getPhotoUrl() {
        return photoUrl;
    }
}
