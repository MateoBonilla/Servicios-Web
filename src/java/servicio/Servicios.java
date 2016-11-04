/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import config.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import model.Vacas;
/**
 *
 * @author German
 */
@Path ("usuarios")
public class Servicios {
    
     @Context
    private UriInfo context;

    /**
     * Creates a new instance of prueba
     */
    public Servicios() {
    }

    /**
     * Retrieves representation of an instance of servicio.prueba
     *
     * @param key
     * @param user
     * 
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/vaca")
    @Produces(MediaType.APPLICATION_JSON)
    public Vacas getVaca() {
        Vacas v = new Vacas();
        v.setCodigo_id(1);
        v.setNombre("La Diabla");  
        v.setFecha("20/10/2016");
        v.setNumero_partos("2");
        v.setMadre_id(36);
        v.setSexo("H");
        v.setImagen("imagen.jpg");      

        return v;
    }
    @GET
    @Path("/listcow")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vacas> getListUser() {

        List<Vacas> lista = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Vacas v = new Vacas();
            v.setCodigo_id(i);
            v.setNombre("La Diabla "+i);
            lista.add(v);
        }

        return lista;
    }
    
 /**
     * PUT method for updating or creating an instance of prueba
     *
     * @param codigo_id
     * @param nombre
     * @param fnacimiento
     * @param partos
     * @param potrero_id
     * @param madre
     * @param sexo
     * @param imagen
     * @param fingreso
     * @param content representation for the resource
     * @return 
     * @throws java.sql.SQLException 
     */
    @GET
    @Path("/newVaca")
    //@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String nuevoVaca(@QueryParam("ID") int codigo_id,
                               @QueryParam("Nombre") String nombre,
                               @QueryParam("Fecha_de_Nacimiento") String fnacimiento,
                               @QueryParam("Sexo") String sexo,
                               @QueryParam("Fecha_de_Ingreso") String fingreso,
                               @QueryParam("Potrero") int potrero_id,
                               @QueryParam("Madre") int madre,
                               @QueryParam("Imagen") String imagen,
                               @QueryParam("N_Partos") int partos ) throws SQLException {
        int insertados=0;
        Conexion conexion= new Conexion();
        String mensaje="";
        try {
            
            //conexion.getConexion().setAutoCommit(false);
            PreparedStatement sentenciaPreparada = null;
            String sql="Insert into Vacunos (ID,Nombre,Fecha_de_Nacimiento,Sexo,Madre,Potrero,Imagen,N_Partos)"
                    + "values(?,?,?,?,?,?,?,?)";
            sentenciaPreparada= conexion.getConexion().prepareStatement(sql);
            sentenciaPreparada.setInt(1,codigo_id);
            sentenciaPreparada.setString(2,nombre);
            sentenciaPreparada.setString(3,fnacimiento);
            sentenciaPreparada.setInt(4,partos);
            sentenciaPreparada.setInt(5,potrero_id);
            sentenciaPreparada.setInt(6,madre);
            sentenciaPreparada.setString(7,sexo);
            sentenciaPreparada.setString(8,imagen);
            insertados=sentenciaPreparada.executeUpdate();
         //   conexion.getConexion().commit();
            conexion.getConexion().close();
            
            
        } catch (SQLException ex) {
           // conexion.getConexion().rollback();
            conexion.getConexion().close();
            Logger.getLogger(Servicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(insertados==1){
            
            System.out.println(insertados);
            mensaje = "{\"mensaje\":\"Registro OK\"}";
        
        }else{
             mensaje = "{\"mensaje\":\"Registro Fallido\"}";
        }
    return mensaje;

}
    
}
