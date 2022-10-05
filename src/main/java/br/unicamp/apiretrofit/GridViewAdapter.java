package br.unicamp.apiretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class GridViewAdapter extends BaseAdapter
{
    private List<Dog> listaDog;
    Context context;

    public GridViewAdapter(Context context, List<Dog> parametroListaDog)
    {
        this.context = context;
        this.listaDog = parametroListaDog;
    }

    //tamanho da Lista
    @Override
    public int getCount()
    {return listaDog.size();}

    //cachorro especifico
    @Override
    public Object getItem(int posicao)
    { return this.listaDog.get(posicao); } //retornando cachorro na posicao escolhida

    @Override
    public long getItemId(int posicao)
    {return posicao;}

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup)
    {
        if(view == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.layout_gridview, viewGroup, false);
        }

        ImageView dogImageView = view.findViewById(R.id.dogImageView);
        TextView tvNome = view.findViewById(R.id.tvNome);
        TextView tvRaca = view.findViewById(R.id.tvRaca);

        final Dog dog = listaDog.get(posicao); //pegando cachorro que está numa determinada posicao
        tvNome.setText(dog.getNome());
        tvRaca.setText(dog.getRaca());

        if(dog.getImagem() != null || dog.getImagem().length() > 0)
            Picasso.get().load(dog.getImagem()).into(dogImageView);
        else
            Toast.makeText(context, "URL da imagem está vazia", Toast.LENGTH_LONG).show();


        return view;
    }
}
