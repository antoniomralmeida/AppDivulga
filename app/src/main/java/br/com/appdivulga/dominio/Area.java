package br.com.appdivulga.dominio;

import java.io.Serializable;

/**
 * Created by jardel on 24/06/2017.
 */

public class Area implements Serializable {

    private long id;
    private String area;

    public Area(long id, String area) {
        this.id = id;
        this.area = area;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Area)) return false;

        Area area1 = (Area) o;

        if (getId() != area1.getId()) return false;
        return getArea() != null ? getArea().equals(area1.getArea()) : area1.getArea() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getArea() != null ? getArea().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", area='" + area + '\'' +
                '}';
    }
}

