package com.example.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PhotoController {
    
    // private List<Photo> db = List.of(new Photo("test.txt", "1"));
    private Map<String, Photo> db = new HashMap<>() {{
    put("1", new Photo("test.txt", "1"));
    }};

    @GetMapping("/photo")
    public Collection<Photo> GetPhoto() {
        return db.values();
    }

    @GetMapping("/photo/{id}")
    public Photo get(@PathVariable String id) {
        Photo photo = db.get(id);

        if (photo == null) {throw new ResponseStatusException(HttpStatus.NOT_FOUND);};
        return photo;
    }

    @DeleteMapping("/photo/delete/{id}")
    public void deletePhoto(@PathVariable String id) {
        Photo photo = db.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
