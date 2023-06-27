package com.example.lisitviewusandosearchview;

public class AlumnoItem {
    // Declaración de atributos
    private String txtMatricula;
    private String txtNombre;
    private Integer fotoAlumno;

    // Constructor
    public AlumnoItem(String txtMatricula, String txtNombre, Integer fotoAlumno) {
        this.txtMatricula = txtMatricula;
        this.txtNombre = txtNombre;
        this.fotoAlumno = fotoAlumno;
    }

    // Getters & Setters

    public String getTxtMatricula() {
        return txtMatricula;
    }

    public void setTxtMatricula(String txtMatricula) {
        this.txtMatricula = txtMatricula;
    }

    public String getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre = txtNombre;
    }

    public Integer getFotoAlumno() {
        return fotoAlumno;
    }

    public void setFotoAlumno(Integer fotoAlumno) {
        this.fotoAlumno = fotoAlumno;
    }
}


