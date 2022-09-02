-- Delete ms_produk table if exist
DROP TABLE IF EXISTS ms_produk;

-- Create ms_user table
CREATE TABLE ms_produk(
    id VARCHAR(20) PRIMARY KEY NOT NULL,
    tipe_produk VARCHAR(30) NOT NULL,
    nama_produk VARCHAR(50) NOT NULL,
    keterangan VARCHAR(255) NULL,
    ltv NUMERIC(3,2) NOT NULL,
    jangka_waktu NUMERIC(3) NOT NULL,
    admin_buka NUMERIC NOT NULL,
    admin_buka_type VARCHAR(7) NOT NULL,
    admin_tutup NUMERIC NOT NULL,
    admin_tutup_type VARCHAR(7) NOT NULL,
    jasa_penyimpanan NUMERIC(3,2) NOT NULL,
    jasa_penyimpanan_periode NUMERIC(3) NOT NULL,
    denda_keterlambatan NUMERIC(3,2) NOT NULL,
    denda_keterlambatan_periode NUMERIC(3) NOT NULL,
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

-- Query All data in ms_produk table
SELECT * FROM ms_produk;