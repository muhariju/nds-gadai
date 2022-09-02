-- Delete ms_user table if exist
DROP TABLE IF EXISTS ms_user;

-- Create ms_user table
CREATE TABLE ms_user(
    id VARCHAR(15) PRIMARY KEY NOT NULL,
    nama_user VARCHAR(30) NOT NULL,
    nomor_hp VARCHAR(12) NOT NULL,
    keterangan VARCHAR(50) NULL,
    limit_transaksi NUMERIC(17,2) NOT NULL,
    tanggal_masuk DATE NOT NULL,
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

-- Query All data in ms_user table
SELECT * FROM ms_user;