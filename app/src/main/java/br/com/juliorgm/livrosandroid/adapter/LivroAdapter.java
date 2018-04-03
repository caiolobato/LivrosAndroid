package br.com.juliorgm.livrosandroid.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.juliorgm.livrosandroid.R;
import br.com.juliorgm.livrosandroid.model.Livro;

public class LivroAdapter extends BaseAdapter {

    private final List<Livro> livros;
    private final Activity activity;

    public LivroAdapter (List<Livro> livros,Activity activity) {
        this.livros = livros;
        this.activity = activity;

    }


    @Override
    public int getCount() {
        return livros.size();
    }

    @Override
    public Object getItem(int position) {
        return livros.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = activity.getLayoutInflater()
                .inflate(R.layout.lista_livro,parent,false);
        Livro livro = livros.get(position);

        //pegando as referencias das Views
        TextView titulo = view.findViewById(R.id.lista_tituloId);
        TextView isbn = view.findViewById(R.id.lista_isbnId);
        TextView edicao = view.findViewById(R.id.lista_edicaoId);

        ImageView imagem = view.findViewById(R.id.lista_livroImgId);

        //populando as views
        // Falta colocar as condições se for null = setar o texto para "Nâo informado"'
        titulo.setText(livro.getTitulo());
        isbn.setText("ISBN: "+ livro.getIsbn());
        edicao.setText("Edição: " + livro.getEdicao());

        imagem.setImageResource(R.drawable.lista_book); // bota imagem padrao pra todos

        return view;

    }



}
