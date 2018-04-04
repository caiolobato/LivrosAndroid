package br.com.juliorgm.livrosandroid.helper;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.juliorgm.livrosandroid.FormLivrosActivity;
import br.com.juliorgm.livrosandroid.R;
import br.com.juliorgm.livrosandroid.model.Livro;

public class LivroHelper {

    EditText campoISBN,campoTitulo,campoEdicao;
    Button botaoDelete;
    Livro livro;

    public LivroHelper(FormLivrosActivity activity,Livro livro) {
        this.botaoDelete = activity.findViewById(R.id.botaoDeleteId);
        this.campoISBN = activity.findViewById(R.id.editISBN);
        this.campoTitulo = activity.findViewById(R.id.editTitulo);
        this.campoEdicao = activity.findViewById(R.id.editEdicao);
        this.livro = (livro==null)? new Livro():carregaCampos(livro);
    }

    public Livro carregaCampos(Livro livro) {
        botaoDelete.setVisibility(View.VISIBLE);
        campoISBN.setText(livro.getIsbn());
        campoTitulo.setText(livro.getTitulo());
        campoEdicao.setText(livro.getEdicao());

        return livro;
    }

    public Livro pegaLivro(){


        if ((campoISBN.getText().toString().equals(""))) {
            livro.setIsbn("Não informado");
        } else {
            livro.setIsbn(campoISBN.getText().toString());
        }

        if(campoTitulo.getText().toString().equals("")){
            livro.setTitulo("Não informado");
        } else {
            livro.setTitulo(campoTitulo.getText().toString());
        }

        if(campoEdicao.getText().toString().equals("")){
            livro.setEdicao("Não informado");
        } else {
            livro.setEdicao(campoEdicao.getText().toString());
        }

        return livro;
    }


}
