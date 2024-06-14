package app.kh.auth;

import com.google.firebase.database.IgnoreExtraProperties;

import lombok.Getter;
import lombok.Setter;

@IgnoreExtraProperties
@Getter
public final class User {
    private String username;
    private String email;

    private Level level;

    @IgnoreExtraProperties
    @Getter @Setter
    public static final class Level {
        /*
        * TODO: Algoritmo para obtener puntos de nivel necesarios según nivel usuario.
        * */
        private int levelNumber;
        private int levelPoints;
        private int nextLevelPoints;
    }

    @Getter
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

    public User(
            final String username,
            final String email,
            final android.net.Uri photoUrl
    ) {
        this.username = username;
        this.email = email;
        this.photoUrl = photoUrl;
    }
}
