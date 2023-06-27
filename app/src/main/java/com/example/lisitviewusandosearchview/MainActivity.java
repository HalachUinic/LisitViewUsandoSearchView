package com.example.lisitviewusandosearchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Declaración de la ListView
    private ListView listaAlumnos;
    private ArrayList<AlumnoItem> lista;
    private AdapterAlumno adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = new ArrayList<>();
        // Añadir al ArrayList los datos de los alumnos
        lista.add(new AlumnoItem(getString(R.string.item2019030344), getString(R.string.msg2019030344), R.drawable.y2019030344));
        lista.add(new AlumnoItem(getString(R.string.item2020030174), getString(R.string.msg2020030174), R.drawable.y2020030174));
        lista.add(new AlumnoItem(getString(R.string.item2020030176), getString(R.string.msg2020030176), R.drawable.y2020030176));
        lista.add(new AlumnoItem(getString(R.string.item2020030181), getString(R.string.msg2020030181), R.drawable.y2020030181));
        lista.add(new AlumnoItem(getString(R.string.item2020030184), getString(R.string.msg2020030184), R.drawable.y2020030184));
        lista.add(new AlumnoItem(getString(R.string.item2020030189), getString(R.string.msg2020030189), R.drawable.y2020030189));
        lista.add(new AlumnoItem(getString(R.string.item2020030199), getString(R.string.msg2020030199), R.drawable.y2020030199));
        lista.add(new AlumnoItem(getString(R.string.item2020030212), getString(R.string.msg2020030212), R.drawable.y2020030212));
        lista.add(new AlumnoItem(getString(R.string.item2020030241), getString(R.string.msg2020030241), R.drawable.y2020030241));
        lista.add(new AlumnoItem(getString(R.string.item2020030243), getString(R.string.msg2020030243), R.drawable.y2020030243));

        lista.add(new AlumnoItem(getString(R.string.item2020030249), getString(R.string.msg2020030249), R.drawable.y2020030249));
        lista.add(new AlumnoItem(getString(R.string.item2020030264), getString(R.string.msg2020030264), R.drawable.y2020030264));
        lista.add(new AlumnoItem(getString(R.string.item2020030268), getString(R.string.msg2020030268), R.drawable.y2020030268));
        lista.add(new AlumnoItem(getString(R.string.item2020030292), getString(R.string.msg2020030292), R.drawable.y2020030292));
        lista.add(new AlumnoItem(getString(R.string.item2020030304), getString(R.string.msg2020030304), R.drawable.y2020030304));
        lista.add(new AlumnoItem(getString(R.string.item2020030306), getString(R.string.msg2020030306), R.drawable.y2020030306));
        lista.add(new AlumnoItem(getString(R.string.item2020030313), getString(R.string.msg2020030313), R.drawable.y2020030313));
        lista.add(new AlumnoItem(getString(R.string.item2020030315), getString(R.string.msg2020030315), R.drawable.y2020030315));
        lista.add(new AlumnoItem(getString(R.string.item2020030322), getString(R.string.msg2020030322), R.drawable.y2020030322));
        lista.add(new AlumnoItem(getString(R.string.item2020030325), getString(R.string.msg2020030325), R.drawable.y2020030325));

        lista.add(new AlumnoItem(getString(R.string.item2020030327), getString(R.string.msg2020030327), R.drawable.y2020030327));
        lista.add(new AlumnoItem(getString(R.string.item2020030329), getString(R.string.msg2020030329), R.drawable.y2020030329));
        lista.add(new AlumnoItem(getString(R.string.item2020030332), getString(R.string.msg2020030332), R.drawable.y2020030332));
        lista.add(new AlumnoItem(getString(R.string.item2020030333), getString(R.string.msg2020030333), R.drawable.y2020030333));
        lista.add(new AlumnoItem(getString(R.string.item2020030389), getString(R.string.msg2020030389), R.drawable.y2020030389));
        lista.add(new AlumnoItem(getString(R.string.item2020030766), getString(R.string.msg2020030766), R.drawable.y2020030766));
        lista.add(new AlumnoItem(getString(R.string.item2020030771), getString(R.string.msg2020030771), R.drawable.y2020030771));
        lista.add(new AlumnoItem(getString(R.string.item2020030777), getString(R.string.msg2020030777), R.drawable.y2020030777));
        lista.add(new AlumnoItem(getString(R.string.item2020030799), getString(R.string.msg2020030799), R.drawable.y2020030799));
        lista.add(new AlumnoItem(getString(R.string.item2020030808), getString(R.string.msg2020030808), R.drawable.y2020030808));

        lista.add(new AlumnoItem(getString(R.string.item2020030819), getString(R.string.msg2020030819), R.drawable.y2020030819));
        lista.add(new AlumnoItem(getString(R.string.item2020030865), getString(R.string.msg2020030865), R.drawable.y2020030865));
        adaptador = new AdapterAlumno(this, R.layout.activity_alumno_item, R.id.lblMatriculas, lista);

        listaAlumnos = findViewById(R.id.listview1);
        listaAlumnos.setAdapter(adaptador);
        listaAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(adapterView.getContext(), getString(R.string.msgSeleccionado).toString() + " " + ((AlumnoItem) adapterView.getItemAtPosition(position)).getTxtNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.searchview, menu);

        MenuItem menuItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Buscar");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adaptador.filtrarAlumnosEnTiempoReal(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void filtrarAlumnosEnTiempoReal(String txtBuscar) {
        ArrayList<AlumnoItem> listaFiltrada = new ArrayList<>();

        for (AlumnoItem alumno : lista) {
            if (alumno.getTxtNombre().toLowerCase().contains(txtBuscar.toLowerCase())) {
                listaFiltrada.add(alumno);
            }
        }

        adaptador.clear();
        adaptador.addAll(listaFiltrada);
        adaptador.notifyDataSetChanged();
    }


}


