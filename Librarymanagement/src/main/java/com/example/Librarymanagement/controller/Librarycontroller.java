package com.example.Librarymanagement.controller;

import com.example.Librarymanagement.model.Library;
import com.example.Librarymanagement.service.Libraryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/library-management/")
public class Librarycontroller {
    @Autowired
    public Libraryservice libraryservice;

    @GetMapping("/findAll")
    public HashMap<String, Library> getAllLibrary(){
        return libraryservice.getAllLibrary();
    }

    @PostMapping("/add_library")
    public String addLib(Library newlibrary){
        return libraryservice.addLibrary(newlibrary);
    }

    @GetMapping("/findLibrary_By_id/name/{name}")
    public Library findLibraryByName(String name){
        return libraryservice.getLibrary(name);
    }

    @DeleteMapping("/deleteLibrary")
    public String deleteLib(String name){
        return libraryservice.deleteLibrary(name);
    }

    @PostMapping("/updateLibrary")
    public void getLib(Library library){
        libraryservice.updateLibrary(library);
    }
}
