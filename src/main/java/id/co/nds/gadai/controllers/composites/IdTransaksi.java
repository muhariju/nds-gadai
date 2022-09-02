package id.co.nds.gadai.controllers.composites;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IdTransaksi implements Serializable {

    @Column(name = "id_transaksi")
    private String id;

    @Column(name = "no_urut")
    private String noUrut;

    public IdTransaksi() {
    }

    public IdTransaksi(String id, String noUrut) {
        this.id = id;
        this.noUrut = noUrut;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoUrut() {
        return noUrut;
    }

    public void setNoUrut(String noUrut) {
        this.noUrut = noUrut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdTransaksi that = (IdTransaksi) o;
        return id.equals(that.id) &&
                noUrut.equals(that.noUrut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, noUrut);
    }
}
