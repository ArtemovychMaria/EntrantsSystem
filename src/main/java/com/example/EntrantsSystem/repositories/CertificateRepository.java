package com.example.EntrantsSystem.repositories;

import com.example.EntrantsSystem.domain.Certificate;
import com.example.EntrantsSystem.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate,Integer> {

    public Certificate findByUserId(int userId);

    @Query("select (count(c) > 0) from Certificate c where c.user.id=:userId")
    public boolean checkIfExist(@Param("userId") int userId);

}
