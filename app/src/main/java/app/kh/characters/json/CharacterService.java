package app.kh.characters.json;

import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.GET;

import java.util.List;

public interface CharacterService {
    @GET("/character?page={page-number}")
    Call<List<app.kh.characters.Character>> listCharactersPerPage(@Field("page-number") final int page);

    @GET("/character?videoGame=[Kingdom%Hearts]&name={character-name}")
    Call<app.kh.characters.Character> getCharacter(@Field("character-name") final String characterName);
}
