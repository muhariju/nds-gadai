package id.co.nds.gadai.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class TransaksiIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor ssci, Object o)
            throws HibernateException {
        Connection connection = ssci.connection();
        try {
            PreparedStatement ps = connection
                    .prepareStatement("SELECT COUNT(*) AS seq FROM tx_pembayaran");
            LocalDate dateObj = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMM");
            String date = dateObj.format(formatter);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int seq = rs.getInt("seq") + 1;
                String code = String.format("PCT-"+date+"-%05d", seq);
                System.out.println("Generated Id Transaksi Code: " + code);
                return code;
            } else {
                throw new HibernateException("Generator is failed to generate id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

