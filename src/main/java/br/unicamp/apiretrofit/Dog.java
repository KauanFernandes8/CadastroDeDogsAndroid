package br.unicamp.apiretrofit;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Dog implements Serializable
{
    @SerializedName("id") //pegar objeto inteiro e passar para outro lugar
    private String id;
    @SerializedName("nome")
    private String nome;
    @SerializedName("raca")
    private String raca;
    @SerializedName("image")
    private String image;

    public Dog(String id, String nome, String raca, String image)
    {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.image = image;
    }

    public String getId()
    {return id;}

    public void setId(String id)
    {this.id = id;}

    public String getNome()
    {return nome;}

    public void setNome(String nome)
    {this.nome = nome;}

    public String getImagem()
    {return image;}

    public void setImagem(String imagem)
    {this.image = imagem;}

    public String getRaca()
    {return raca;}

    public void setRaca(String raca)
    {this.raca = raca;}

}
