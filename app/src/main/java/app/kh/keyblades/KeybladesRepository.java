package app.kh.keyblades;

import app.kh.utils.Singleton;
import app.kh.utils.Repository;

public final class KeybladesRepository extends Repository<Keyblade> {
    @Singleton
    private static final KeybladesRepository repository;

    static {
        repository = new KeybladesRepository();
    }

    private KeybladesRepository() {}

    public static KeybladesRepository getInstance() {
        return repository;
    }
}
