package com.example.EntrantsSystem.repositories;

import com.example.EntrantsSystem.domain.Certificate;
import com.example.EntrantsSystem.domain.ExamMark;
import com.example.EntrantsSystem.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamMarkRepository extends JpaRepository<ExamMark,Integer> {

    public Certificate findByUserId(int userId);


    public ExamMark findBySubjectIdAndUserId(int subjectId,int userId);

    @Query("select e.subject.name from ExamMark e where e.user.id=:userId")
    public List<String>getSubjects(@Param("userId") int userId);
}
