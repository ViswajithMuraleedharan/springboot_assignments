package com.example.Librarymanagement.service;

import com.example.Librarymanagement.model.Library;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class Libraryservice {

    public static HashMap<String, Library> map=new HashMap<>();
    static {
        map.put("Mulanthuruthy",new Library("Mulanthuruthy","Mulanthuruthy po, near police station","9074037346","youth club,music"));
        map.put("Veliyanad",new Library("Veliyanad","Veliyanad po, near public school","90640373890","youth club,yoga class"));
        map.put("Peppathi",new Library("Peppathi","near co-operative bank","899763456","internet, television, club"));
    }

    public String addLibrary(Library library){
        String name=library.getName();
        if(map.containsKey(name)){
            return "Library already exists";
        }
        map.put(name,library);
        return "Library added successfully";
    }

    public Library getLibrary(String name){
        if(map.containsKey(name)){
            return map.get(name);
        }
        return null;
    }

    public HashMap<String,Library> getAllLibrary(){
        return  map;
    }

    public String deleteLibrary(String name){
        if(map.containsKey(name)){
            map.remove(name);
            return "Library deleted";
        }
        return "No Library found";
    }

    public void updateLibrary(Library library){
        String name=library.getName();
        map.put(name,library);
    }

}
