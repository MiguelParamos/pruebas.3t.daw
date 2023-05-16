package clases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import excepciones.ClienteNoExisteException;
import excepciones.ContraseñaInvalidaException;
import Utils.DAO;

public class Cliente {
    private String nombre;
    private String email;
    private int telefono;
   
   
   
    public Cliente(String nombre, String email, int telefono,String contraseña) throws SQLException {
        super();
        HashMap<String,Object>columnas=new HashMap<String,Object>();
        columnas.put("email", email);
        columnas.put("nombre", nombre);
        columnas.put("telefono", telefono);
        columnas.put("password", contraseña);
       
        DAO.insertar("cliente", columnas);
       
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }
    public Cliente(String email,String contraseña) throws SQLException, ClienteNoExisteException, ContraseñaInvalidaException {
        super();
        HashMap<String,Object>restricciones=new HashMap<String,Object>();
        restricciones.put("email", email);
        LinkedHashSet<String>columnasSelect=new LinkedHashSet<String>();
        columnasSelect.add("email");
        columnasSelect.add("nombre");
        columnasSelect.add("telefono");
        columnasSelect.add("password");
        ArrayList<Object>ret=new ArrayList<Object>();
        ret=DAO.consultar("cliente",  columnasSelect,restricciones);
        if(ret.isEmpty()) {
            throw new ClienteNoExisteException("SIN DATOS");
        }else {
            String contraseñaAlmacenada=(String)ret.get(3);
            if(contraseñaAlmacenada.equals(contraseña)) {
                this.email=(String)(ret.get(0));
                this.nombre=(String)(ret.get(1));
                this.telefono=(Integer)(ret.get(2));
            }else {
                throw new ContraseñaInvalidaException("CONTRASEÑA INVALIDA");
            }
        }
       
    }
   
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setNombre(String nombre) throws SQLException {
        HashMap<String,Object>datosMod=new HashMap<String,Object>();
        datosMod.put("nombre", nombre);
        HashMap<String,Object>restriccion=new HashMap<String,Object>();
        restriccion.put("email", this.email);
        DAO.actualizar("cliente", datosMod, restriccion);
        this.nombre = nombre;
    }

    public void setEmail(String email) throws SQLException {
        HashMap<String,Object>datosMod=new HashMap<String,Object>();
        datosMod.put("email", email);
        HashMap<String,Object>restriccion=new HashMap<String,Object>();
        restriccion.put("email", this.email);
        DAO.actualizar("cliente", datosMod, restriccion);
        this.email = email;
    }
    public void setTelefono(int telefono) throws SQLException {
        HashMap<String,Object>datosMod=new HashMap<String,Object>();
        datosMod.put("telefono", telefono);
        HashMap<String,Object>restriccion=new HashMap<String,Object>();
        restriccion.put("email", this.email);
        DAO.actualizar("cliente", datosMod, restriccion);
        this.telefono = telefono;
    }

   

    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", email=" + email + ", telefono=" + telefono
                + "]";
    }
   
}