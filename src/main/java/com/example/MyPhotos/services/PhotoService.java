package com.example.MyPhotos.services;

import com.example.MyPhotos.models.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhotoService implements IPhotoService {

    private List<Photo> list;

    private int lastId;

    public PhotoService() {
        list = new ArrayList<Photo>();
        list.add(new Photo(1, "./img/01.png"));
        list.add(new Photo(2, "./img/02.png"));
        list.add(new Photo(3, "./img/03.png"));

        lastId = list.size();
    }

    //GetAll
    @Override
    public Iterable<Photo> getAll(){
        return list;
    }

    //GetById
    @Override
    public Optional<Photo> getById(int id){

        Optional<Photo> photo = list.stream().filter(item -> item.getId() == id).findFirst();

        return photo;
    }

    //Add photo
    @Override
    public Photo addPhoto(Photo photo){

        lastId++;
        photo.setId(lastId);
        list.add(photo);
        return photo;
    }

    //Update photo
    @Override
    public Optional<Photo> updatePhoto(Photo photo, int id){
        Optional<Photo> foundPhoto = list.stream().filter(item -> item.getId() == id).findFirst();

        if(foundPhoto.isEmpty()){
            return Optional.empty();
        }

        foundPhoto.get().setUrl(photo.getUrl());
        return foundPhoto;
    }

    @Override
    public Boolean deletePhoto(int id){
        Optional<Photo> foundPhoto = list.stream().filter(item -> item.getId() == id).findFirst();

        if(foundPhoto.isEmpty()){
            return false;
        }

        list.remove(foundPhoto.get());
        return true;
    }
}
