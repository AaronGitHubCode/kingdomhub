package app.kh.characters;

import app.kh.utils.Singleton;
import app.kh.utils.Repository;

public final class CharactersRepository extends Repository<app.kh.characters.Character> {
    @Singleton
    private static final CharactersRepository repository;

    static {
        repository = new CharactersRepository();
    }

    private CharactersRepository() {}

    public static CharactersRepository getInstance() {
        return repository;
    }
}
