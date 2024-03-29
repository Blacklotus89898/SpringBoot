package com.example.demo.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Photo;

@RestController
public class PhotoController {

    private Map<String, Photo> db = new HashMap<>() {
        {
            put("1", new Photo("test.txt", "1"));
        }
    };

    @GetMapping("/photo")
    public Collection<Photo> GetPhoto() {
        return db.values();
    }

    @GetMapping("/photo/{id}")
    public Photo get(@PathVariable String id) {
        Photo photo = db.get(id);

        if (photo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        ;
        return photo;
    }

    @DeleteMapping("/photo/delete/{id}")
    public void deletePhoto(@PathVariable String id) {
        Photo photo = db.remove(id);
        if (photo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/photo")
    public Photo createPhoto(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = new Photo(null, null);
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(file.getOriginalFilename());
        photo.setData(file.getBytes());
        db.put(photo.getId(), photo);
        return photo;
    }
}
