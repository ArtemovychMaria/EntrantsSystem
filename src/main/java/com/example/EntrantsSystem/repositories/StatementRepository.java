package com.example.EntrantsSystem.repositories;

import com.example.EntrantsSystem.domain.Faculty;
import com.example.EntrantsSystem.domain.Statement;
import com.example.EntrantsSystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StatementRepository extends JpaRepository<Statement,Integer> {

    List<Statement> findByConfirmedFalseAndRejectedFalse();

    List<Statement> findByUserIdAndRejectedTrue(int userId);

    List<Statement> findByFacultyIdAndConfirmedTrueOrderByFinalGradeDesc(int facultyId);

    @Modifying
    @Query(value="update Statement s set s.confirmed=?1 where s.id=?2")
    public void updateConfirmedById(boolean confirmed, int statementId);

    @Modifying
    @Query(value="update Statement s set s.rejected=?1 where s.id=?2")
    public void updateRejectedById(boolean rejected, int statementId);

    @Query("select (count(s) > 0) from Statement s where s.faculty.id=:facultyId " +
            "and s.user.id=:userId")
    public boolean checkIfExist(@Param("facultyId") int facultyId,@Param("userId") int userId);

    public void deleteByFacultyId(int facultyId);

    public void deleteByFacultyIdAndUserId(int facultyId,int userId);
}
