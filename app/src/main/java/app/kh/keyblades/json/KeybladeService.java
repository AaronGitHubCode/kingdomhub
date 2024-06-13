package app.kh.keyblades.json;

import app.kh.keyblades.Keyblade;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

import java.util.List;

public interface KeybladeService {
    @GET("/keyblade?page={page-number}")
    Call<List<Keyblade>> listKeybladesPerPage(@Field("page-number") final int pageNumber);

    @GET("/keyblade?name={keyblade-name}")
    Call<Keyblade> getKeyblade(@Field("keyblade-name") final String keybladeName);
}
