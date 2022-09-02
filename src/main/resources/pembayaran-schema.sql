-- Delete tx_pembayaran table if exist
DROP TABLE IF EXISTS tx_pembayaran;

-- Create tx_pembayaran table
CREATE TABLE tx_pembayaran(
    id VARCHAR(15) PRIMARY KEY NOT NULL,
    id_transaksi VARCHAR(15) NOT NULL,
    total_tagihan_cicilan NUMERIC NOT NULL,
    total_tagihan_denda NUMERIC NULL,
    biaya_adm_tutup NUMERIC NOT NULL,
    total_tagihan NUMERIC NOT NULL,
    pembulatan NUMERIC NOT NULL,
    jumlah_pembayaran NUMERIC NOT NULL,
    metode_bayar VARCHAR(10) NOT NULL
)
WITH (
    OIDS=FALSE
);

-- Query All data in tx_pembayaran table
SELECT * FROM tx_pembayaran;