package com.example.EntrantsSystem.repositories;

import com.example.EntrantsSystem.domain.UserPhotoFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPhotoRepository extends CrudRepository<UserPhotoFile,String> {
}
