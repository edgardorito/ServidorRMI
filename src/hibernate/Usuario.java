/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ERIDE21
 */

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{
    @Id
    private long idU;
    @Column(name="usuario")
    private String usuario;
    @Column(name="contrasena")
    private String contrasena;

    public Usuario() {
    }

    public Usuario(String usuario, String contrasena) {
        this.idU = idU;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public long getIdU() {
        return idU;
    }

    public void setIdU(long idU) {
        this.idU = idU;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.idU != other.idU) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.contrasena, other.contrasena)) {
            return false;
        }
        return true;
    }
    
    
    
}
