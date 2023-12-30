package com.example.MyPhotos.services;

import com.example.MyPhotos.models.Photo;
import com.example.MyPhotos.repository.IPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Optional;

@Service("mainPhotoService")
public class DbPhotoService implements IPhotoService {

    @Autowired
    private IPhotoRepository photoRepository;

    //GetAll
    @Override
    public Iterable<Photo> getAll(){
        return photoRepository.findAll();
    }

    //GetById
    @Override
    public Optional<Photo> getById(int id){
        return photoRepository.findById(id);
    }

    //Add photo
    @Override
    public Photo addPhoto(Photo photo){

        return photoRepository.save(photo);
    }

    //Update photo
    @Override
    public Optional<Photo> updatePhoto(Photo photo, int id){

        Optional<Photo> foundPhoto = photoRepository.findById(id);

        if(foundPhoto.isEmpty()){
            return Optional.empty();
        }

        foundPhoto.get().setUrl(photo.getUrl());
       photoRepository.save(foundPhoto.get());

       return foundPhoto;
    }

    //Delete
    @Override
    public Boolean deletePhoto(int id){
       Optional<Photo> foundPhoto = photoRepository.findById(id);
       if(foundPhoto.isEmpty()){
           return false;
       }
       photoRepository.delete(foundPhoto.get());
       return true;
    }
}
