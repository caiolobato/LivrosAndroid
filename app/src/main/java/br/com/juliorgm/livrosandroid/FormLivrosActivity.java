package br.com.juliorgm.livrosandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.com.juliorgm.livrosandroid.helper.LivroHelper;
import br.com.juliorgm.livrosandroid.model.Livro;

public class FormLivrosActivity extends AppCompatActivity {
    Livro livro;
    LivroHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_livros);

        Intent intent = getIntent();
        livro = (Livro) intent.getSerializableExtra("LIVRO");

        helper = new LivroHelper(this,livro);

    }

    public void excluirLivro(View view) {
        livro.delete();
        finish();
    }


    public void salvarLivro(View view){
//        livro = helper.pegaLivro();
//        livro.save();
        helper.pegaLivro().save();
        Toast.makeText(this,"Registrado com sucesso",Toast.LENGTH_SHORT).show();
        finish();
    }
}
