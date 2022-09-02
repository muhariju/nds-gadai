-- Delete tx_transaksi table if exist
DROP TABLE IF EXISTS tx_transaksi;
-- Create tx_transaksi table
CREATE TABLE tx_transaksi(
    id VARCHAR(15) PRIMARY KEY NOT NULL,
    product_id VARCHAR(20) NOT NULL,
    total_nilai_taksiran NUMERIC(17,2) NOT NULL,
    nilai_pencairan_pelanggan NUMERIC NOT NULL,
    diskon_adm_buka NUMERIC(3) NOT NULL,
    cust_id VARCHAR(15) NOT NULL,
    status VARCHAR(25) NOT NULL,
    tanggal_transaksi DATE NOT NULL,
    tanggal_jatuh_tempo DATE NOT NULL,
    created_date TIMESTAMP NOT NULL,
    creator_id INT4 NOT NULL,
    updated_date TIMESTAMP NULL,
    updater_id INT4 NULL,
    deleted_date TIMESTAMP NULL,
    deleter_id INT4 NULL,
    rec_status VARCHAR(1) NULL DEFAULT 'N'::VARCHAR
)
WITH (
    OIDS=FALSE
);

-- Query All data in tx_transaksi table
SELECT * FROM tx_transaksi;

-- Delete tx_detailtransaksi table if exist
DROP TABLE IF EXISTS tx_detailtransaksi;
-- Create tx_detailtransaksi table
CREATE TABLE tx_detailtransaksi(
    id_transaksi VARCHAR(15) NOT NULL,
    no_urut VARCHAR(20) NOT NULL,
    nama_barang VARCHAR(30) NOT NULL,
    kondisi VARCHAR(150) NOT NULL,
    jlh NUMERIC(3) NOT NULL,
    harga_per_satuan NUMERIC(17,2) NOT NULL
)
WITH (
    OIDS=FALSE
);

-- Query All data in tx_detailtransaksi table
SELECT * FROM tx_detailtransaksi;

-- Delete tx_jadwalcicilan table if exist
DROP TABLE IF EXISTS tx_jadwalcicilan;
-- Create tx_jadwalcicilan table
CREATE TABLE tx_jadwalcicilan(
    id_transaksi VARCHAR(15) NOT NULL,
    cicilan_ke VARCHAR(3) NOT NULL,
    pokok NUMERIC NOT NULL,
    bunga NUMERIC NOT NULL,
    status VARCHAR(15) NOT NULL,
    tanggal_aktif DATE NOT NULL,
    tanggal_jatuh_tempo DATE NOT NULL,
    tanggal_bayar DATE NULL,
    denda NUMERIC NULL
)
WITH (
    OIDS=FALSE
);
-- Query All data in tx_jadwalcicilan table
SELECT * FROM tx_jadwalcicilan;