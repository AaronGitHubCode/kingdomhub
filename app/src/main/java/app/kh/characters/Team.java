package app.kh.characters;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;
import java.util.Arrays;

@IgnoreExtraProperties
public final class Team {
    private final String name;
    private final String uid;

    private final List<Character> characters = Arrays.asList(new Character[3]);

    public enum TeamMember {
        FIRST,
        SECOND,
        THIRD;

        public int getPosition() {
            int position = -1;

            switch (this) {
                case FIRST:
                    position = 0;
                    break;
                case SECOND:
                    position = 1;
                    break;
                case THIRD:
                    position = 2;
                    break;
            }

            return position;
        }
    }

    public static final class Builder {
        private String name;

        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        public Team build() {
            return new Team(
                    name
            );
        }
    }

    public Team(
            final String name
    ) {
        this.name = name;
        /* Encontrar solución UID */
        this.uid = "";
    }

    public Character getTeamMember(final TeamMember teamMember) {
        return characters.get(teamMember.getPosition());
    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }
}
