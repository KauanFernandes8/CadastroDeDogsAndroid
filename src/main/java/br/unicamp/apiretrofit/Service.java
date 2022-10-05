package br.unicamp.apiretrofit;

import java.util.List;

import br.unicamp.apiretrofit.Dog;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Service
{
    //selecionar todos
    @GET("api/dog/get")
    Call<List<Dog>> getDog();

    //selecionar por nome de cachorro
    @GET("api/dog/getNome/{nome}")
    Call<Dog> selecionarNome(@Path("nome") String nome);

    //incluir
    @POST("/api/dog/post")
    Call<Dog> incluirDog(@Body Dog dog);

    @PUT("/api/dog/put/{id}")
    Call<Dog> alterarDog(@Path("id") String id, @Body Dog dog);

    @DELETE("/api/dog/delete/{id}")
    Call<Dog> excluirDog(@Path("id") String id);
}
