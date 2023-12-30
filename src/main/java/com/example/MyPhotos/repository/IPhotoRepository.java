package com.example.MyPhotos.repository;

import com.example.MyPhotos.models.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhotoRepository extends CrudRepository<Photo, Integer> {
}
