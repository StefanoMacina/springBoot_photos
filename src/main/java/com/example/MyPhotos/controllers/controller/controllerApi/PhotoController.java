package com.example.MyPhotos.controllers.controller.controllerApi;

import com.example.MyPhotos.models.Photo;
import com.example.MyPhotos.services.IPhotoService;
import com.example.MyPhotos.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PhotoController {

    @Autowired
    @Qualifier("mainPhotoService")
    private IPhotoService photoService;

    public PhotoController(){

    }

    @RequestMapping("/api/photos")
    public Iterable<Photo> getAll(){
        return photoService.getAll();
    }

    @RequestMapping("/api/photos/{id}")
    public Photo getById(@PathVariable int id){
        Optional<Photo> foundPhoto = photoService.getById(id);

        return foundPhoto.get();
    }





}
