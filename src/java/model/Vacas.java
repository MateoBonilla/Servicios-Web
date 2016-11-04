/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author German
 */
public class Vacas {
    
    private int codigo_id;
    private String nombre;  
    private String fecha;
    private String numero_partos;
    private int potrero_id;
    private int madre_id; 
    private String sexo;
    private String imagen;

    /**
     * @return the codigo_id
     */
    public int getCodigo_id() {
        return codigo_id;
    }

    /**
     * @param codigo_id the codigo_id to set
     */
    public void setCodigo_id(int codigo_id) {
        this.codigo_id = codigo_id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the numero_partos
     */
    public String getNumero_partos() {
        return numero_partos;
    }

    /**
     * @param numero_partos the numero_partos to set
     */
    public void setNumero_partos(String numero_partos) {
        this.numero_partos = numero_partos;
    }

    /**
     * @return the potrero_id
     */
    public int getPotrero_id() {
        return potrero_id;
    }

    /**
     * @param potrero_id the potrero_id to set
     */
    public void setPotrero_id(int potrero_id) {
        this.potrero_id = potrero_id;
    }

    /**
     * @return the madre_id
     */
    public int getMadre_id() {
        return madre_id;
    }

    /**
     * @param madre_id the madre_id to set
     */
    public void setMadre_id(int madre_id) {
        this.madre_id = madre_id;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
