package com.example.MyPhotos.services;

import com.example.MyPhotos.models.Photo;

import java.util.ArrayList;
import java.util.Optional;

public interface IPhotoService {


    public Iterable<Photo> getAll();

    public Optional<Photo> getById(int id);

    public Photo addPhoto(Photo photo);

    public Optional<Photo> updatePhoto(Photo photo, int id);

    public Boolean deletePhoto(int id);
}
