package br.unicamp.apiretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityCadastro extends AppCompatActivity
{

    EditText edtId, edtNome, edtRaca, edtImagem;
    Button btnConsultarNome, btnInserir, btnAlterar, btnExcluir, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtId = findViewById(R.id.edtId);
        edtNome = findViewById(R.id.edtNome);
        edtRaca = findViewById(R.id.edtRaca);
        edtImagem = findViewById(R.id.edtImagem);

        btnConsultarNome = findViewById(R.id.btnConsultarNome);
        btnConsultarNome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ConsultarDogNome();
            }
        });

        btnInserir = findViewById(R.id.btnInserir);
        btnInserir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                IncluirDog();
            }
        });

        btnAlterar = findViewById(R.id.btnConsultarNome);
        btnAlterar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                AlterarDog();
            }
        });

        btnExcluir = findViewById(R.id.btnExcluir);
        btnExcluir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ExcluirDog();
            }
        });

        btnLimpar = findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Limpar();
            }
        });
    }

    private void Limpar()
    {
        edtId.setText("");
        edtNome.setText("");
        edtRaca.setText("");
        edtImagem.setText("");
    }

    private void ConsultarDogNome()
    {}

    private void IncluirDog()
    {

        String strId = edtId.getText().toString(); //pega o que o usuario digitou
        String strNome = edtNome.getText().toString();
        String strRaca = edtRaca.getText().toString();
        String strImagem = edtImagem.getText().toString();

        Dog dog = new Dog(strId, strNome, strRaca, strImagem);
        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);
        Call<Dog> call = service.incluirDog(dog);

        call.enqueue(new Callback<Dog>()
        {
            @Override
            public void onResponse(Call<Dog> call, Response<Dog> response)
            {
                if(response.isSuccessful())
                {
                    Dog dogRespostaNode = response.body(); //toda informação dos novos cachorros estão aqui, junto e misturado
                    dogRespostaNode.getId().toString();
                    dogRespostaNode.getNome().toString();
                    dogRespostaNode.getRaca().toString();
                    dogRespostaNode.getImagem().toString();

                    Gson gson = new GsonBuilder().create(); //criando um json

                    String jsonRespostaNode = gson.toJson(dogRespostaNode);

                    TextView tvJson = findViewById(R.id.tvJson);
                    tvJson.setText(jsonRespostaNode);

                    TextView tvObjeto = findViewById(R.id.tvObjeto);
                    tvObjeto.setText("");
                    tvObjeto.append(dogRespostaNode.getId().toString() + "\n" );
                    tvObjeto.append(dogRespostaNode.getNome().toString() + "\n" );
                    tvObjeto.append(dogRespostaNode.getRaca().toString() + "\n" );
                    tvObjeto.append(dogRespostaNode.getImagem().toString() + "\n" );
                }
                else
                {
                    Toast.makeText(ActivityCadastro.this, "Erro na inclusão", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Dog> call, Throwable t)
            {
                Toast.makeText(ActivityCadastro.this, "Erro com a conexão no Node" + t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void AlterarDog()
    {}

    private void ExcluirDog()
    {
        Limpar();

    }
}