package br.gov.sp.fatec.itu.music.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_MUSICS")
public class Music implements Serializable{

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String singer;
    private String studio;
    private int duration; //duração em segundos
    private int cd_solds; //total de cds vendidos
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSinger() {
        return singer;
    }
    public void setSinger(String singer) {
        this.singer = singer;
    }
    public String getStudio() {
        return studio;
    }
    public void setStudio(String studio) {
        this.studio = studio;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getCd_solds() {
        return cd_solds;
    }
    public void setCd_solds(int cd_solds) {
        this.cd_solds = cd_solds;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Music other = (Music) obj;
        if (id != other.id)
            return false;
        return true;
    }

}