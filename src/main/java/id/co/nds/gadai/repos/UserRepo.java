package id.co.nds.gadai.repos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai.entities.UserEntity;
import id.co.nds.gadai.globals.GlobalConstant;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<UserEntity, String>, JpaSpecificationExecutor<UserEntity> {
        @Query(value = "SELECT COUNT(*) FROM ms_user WHERE LOWER(id) = LOWER(:id)", nativeQuery = true)
        long countById(@Param("id") String id);

        @Query(value = "SELECT COUNT(*) FROM ms_user WHERE nomor_hp = :nomorHp ", nativeQuery = true)
        long countByNomorHP(@Param("nomorHp") String nomorHp);

        @Modifying
        @Query(value = "UPDATE ms_user SET rec_status = '"
                        + GlobalConstant.REC_STATUS_NON_ACTIVE
                        + "', deleter_id = ?2 , deleted_date = NOW() "
                        + "WHERE id = ?1", nativeQuery = true)
        Integer doDelete(String id, Integer deleterId);
}
