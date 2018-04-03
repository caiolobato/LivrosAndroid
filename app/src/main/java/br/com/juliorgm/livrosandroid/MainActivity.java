package br.com.juliorgm.livrosandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.juliorgm.livrosandroid.model.Livro;

public class MainActivity extends AppCompatActivity {

    ListView listViewLivros;
    FloatingActionButton buttonAdd;
    Livro livro;
///2222222222
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewLivros = findViewById(R.id.listViewLivros);
        buttonAdd = findViewById(R.id.botaoAddId);
    }

    public void novoLivro(View view) {
        Intent intent = new Intent(MainActivity.this,FormLivrosActivity.class);
        startActivity(intent);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);


        menu.add("Deletar").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                //livro = new Livro();
                AdapterView.AdapterContextMenuInfo menuInfo =
                        (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
                int position = menuInfo.position;
                livro = (Livro) listViewLivros.getItemAtPosition(position);

                //Alert Dialog --- Inicio
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Excluir")
                        .setMessage("Tem certeza que deseja excluir este registro?")
                        .setIcon(android.R.drawable.ic_delete)
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                livro.delete();
                                carregaLista();
                                Toast.makeText(MainActivity.this,"Registro excluido!",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"Registro mantido!",Toast.LENGTH_SHORT).show();
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
                //Alerta dialog --- Fim


                return false;
            }
        });


        menu.add("Editar").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                AdapterView.AdapterContextMenuInfo menuInfo =
                        (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
                int position = menuInfo.position;
                livro = (Livro) listViewLivros.getItemAtPosition(position);

                //PAREI AQUI DANDO NEW INTENT, PUT EXTRA, CARREGA CAMPOS, START ACTIVITY


                return false;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerForContextMenu(listViewLivros);
        carregaLista();

    }

    public void carregaLista() {
        List<Livro> livrosLista = Livro.listAll(Livro.class);
        ArrayAdapter<Livro> adapter = new ArrayAdapter<Livro>(MainActivity.this,android.R.layout.simple_list_item_1,livrosLista);
        listViewLivros.setAdapter(adapter);
    }


    //ArrayAdapter adapter = new ArrayAdapter(AlunoActivity.this,android.R.layout.simple_list_item_1,listaDeAlunos);
    //listViewAluno.setAdapter(adapter);


}
