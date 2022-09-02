package id.co.nds.gadai.controllers.composites;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IdCicilan implements Serializable {

    @Column(name = "id_transaksi")
    private String id;

    @Column(name = "cicilan_ke")
    private String cicilanKe;

    public IdCicilan() {
    }

    public IdCicilan(String id, String i) {
        this.id = id;
        this.cicilanKe = i;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCicilanKe() {
        return cicilanKe;
    }

    public void setCicilanKe(String cicilanKe) {
        this.cicilanKe = cicilanKe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdCicilan that = (IdCicilan) o;
        return id.equals(that.id) &&
                cicilanKe.equals(that.cicilanKe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cicilanKe);
    }
}
