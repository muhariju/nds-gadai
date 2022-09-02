-- Delete ms_pelanggan table if exist
DROP TABLE IF EXISTS ms_pelanggan;
-- Create ms_user table
CREATE TABLE ms_pelanggan(
    id VARCHAR(15) PRIMARY KEY NOT NULL,
    nama_pelanggan VARCHAR(30) NOT NULL,
    nomor_ktp VARCHAR(16) NOT NULL,
    nomor_hp VARCHAR(50) NULL,
    jenis_kelamin VARCHAR(1) NOT NULL,
    jenis_usaha TEXT NOT NULL,
    limit_pinjaman NUMERIC(17,2) NOT NULL,
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

-- Query All data in ms_pelanggan table
SELECT * FROM ms_pelanggan;