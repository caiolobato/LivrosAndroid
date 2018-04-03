package br.com.juliorgm.livrosandroid.helper;

import android.widget.EditText;

import br.com.juliorgm.livrosandroid.FormLivrosActivity;
import br.com.juliorgm.livrosandroid.R;
import br.com.juliorgm.livrosandroid.model.Livro;

public class LivroHelper {

    EditText campoISBN,campoTitulo,campoEdicao;

    Livro livro;

    public LivroHelper(FormLivrosActivity activity,Livro livro) {
        this.campoISBN = activity.findViewById(R.id.editISBN);
        this.campoTitulo = activity.findViewById(R.id.editTitulo);
        this.campoEdicao = activity.findViewById(R.id.editEdicao);
        this.livro = (livro==null)? new Livro():livro;
    }

    public Livro pegaLivro(){
        livro.setIsbn(campoISBN.getText().toString());
        livro.setTitulo(campoTitulo.getText().toString());
        livro.setEdicao(campoEdicao.getText().toString());
        return livro;
    }

}
