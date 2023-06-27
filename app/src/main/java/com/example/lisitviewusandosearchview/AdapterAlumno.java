package com.example.lisitviewusandosearchview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdapterAlumno extends ArrayAdapter<AlumnoItem> {
    // Declaración de atributos
    int groupId;
    Activity Context;
    ArrayList<AlumnoItem> listaAlumnos;
    LayoutInflater inflater;
    ArrayList<AlumnoItem> listaNueva; // Para realizar el filtrado

    // Constructor
    public AdapterAlumno(Activity Context, int groupId,  int id, ArrayList<AlumnoItem> listaAlumnos) {
        super(Context, id, listaAlumnos);
        this.Context = Context;
        this.listaAlumnos = listaAlumnos;
        this.listaNueva = new ArrayList<>(listaAlumnos);
//      listaNueva.addAll(listaAlumnos); // Se agrega a la nueva lista todos los alumnos
        inflater = (LayoutInflater) Context.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE);
        this.groupId = groupId;
    }

    public View getView(int posicion, View convertView, ViewGroup parent) {
        View itemView = inflater.inflate(groupId, parent, false);
        ImageView imagenAlumno = (ImageView) itemView.findViewById(R.id.imgAlumnos);
        imagenAlumno.setImageResource(listaAlumnos.get(posicion).getFotoAlumno());
        TextView txtMatricula = (TextView) itemView.findViewById(R.id.lblMatriculas);
        txtMatricula.setText(listaAlumnos.get(posicion).getTxtMatricula());
        TextView txtNombreAlumno = (TextView) itemView.findViewById(R.id.lblNombres);
        txtNombreAlumno.setText(listaAlumnos.get(posicion).getTxtNombre());

        return itemView;
    }


    public View getDropDownView(int posicion, View convertView, ViewGroup parent) {
        return getView(posicion, convertView, parent);
    }

    // Método para filtrar por búsqueda el ListView Personalizado
    public void filtrarAlumnos(String txtBuscar) {
        if (txtBuscar.isEmpty()) {
            listaAlumnos.clear();
            listaAlumnos.addAll(listaNueva);
        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<AlumnoItem> collection = listaAlumnos.stream()
                        .filter(i -> i.getTxtNombre().toLowerCase().contains(txtBuscar.toLowerCase()))
                        .collect(Collectors.toList());
                listaAlumnos.clear();
                listaAlumnos.addAll(collection);
            } else {
                listaNueva.clear();
                for (AlumnoItem ai : listaAlumnos) {
                    if (ai.getTxtMatricula().toLowerCase().contains(txtBuscar.toLowerCase())) {
                        listaNueva.add(ai);
                    }
                }
                listaAlumnos.clear();
                listaAlumnos.addAll(listaNueva);
            }
        }
    }

    // Método para filtrar por búsqueda el ListView Personalizado
    public void filtrarAlumnosEnTiempoReal(String txtBuscar) {
        if (txtBuscar.isEmpty()) {
            listaAlumnos.clear();
            listaAlumnos.addAll(listaNueva); // Restaurar lista original
        } else {
            ArrayList<AlumnoItem> listaFiltrada = new ArrayList<>();

            for (AlumnoItem alumno : listaNueva) {
                if (alumno.getTxtNombre().toLowerCase().contains(txtBuscar.toLowerCase())) {
                    listaFiltrada.add(alumno);
                }
            }

            listaAlumnos.clear();
            listaAlumnos.addAll(listaFiltrada);
        }

        notifyDataSetChanged();
    }


}

