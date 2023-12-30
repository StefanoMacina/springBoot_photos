package com.example.MyPhotos.controllers.controller.controllerApi;

import com.example.MyPhotos.models.Photo;
import com.example.MyPhotos.services.DbPhotoService;
import com.example.MyPhotos.services.IPhotoService;
import com.example.MyPhotos.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AdminPhotoController {

    @Autowired
    @Qualifier("mainPhotoService")
    private IPhotoService photoService;

    public AdminPhotoController(){

    }

    @GetMapping("/admin/api/photos")
    public Iterable<Photo> getAll(){
        return photoService.getAll();
    }

    @GetMapping("/admin/api/photos/{id}")
    public Photo getById(@PathVariable int id){
        Optional<Photo> photo = photoService.getById(id);

        if(photo.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
        }
        return photo.get();
    }

    @PostMapping("/admin/api/photos")
    public Photo addPhoto(@RequestBody Photo photo){
        return photoService.addPhoto(photo);
    }

    @PutMapping("/admin/api/photos/{id}")
    public Photo updatePhoto(@RequestBody Photo photo, @PathVariable int id){
        Optional<Photo> foundPhoto = photoService.updatePhoto(photo, id);

        if(foundPhoto.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
        }

        return foundPhoto.get();
    }

    @DeleteMapping("/admin/api/photos/{id}")
    public String deletePhoto(@PathVariable int id){
        Boolean foundPhoto = photoService.deletePhoto(id);

        if(!foundPhoto){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");
        }

        return "Item deleted successfully";
    }
}
