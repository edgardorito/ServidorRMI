/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ERIDE21
 */
@Entity
@Table(name="score")
public class Score implements Serializable {
    @Id
    private Long id;
    
    @Column(name="usuario")
    private String usuario;
    @Column(name="score")    
    private long score;

    public Score(String usuario, long score) {
        this.usuario = usuario;
        this.score = score;
    }

   
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }


    
    
    
}
