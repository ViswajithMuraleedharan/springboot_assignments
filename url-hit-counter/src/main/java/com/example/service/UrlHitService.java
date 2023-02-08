package com.example.service;

import com.example.model.visitors;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class UrlHitService {
    HashMap<String,Integer> map=new HashMap<>();
    public visitors getCount(String username)
    {

        map.put(username,map.getOrDefault(username,0)+1);
        visitors visitor=new visitors(username,map.get(username));
        return visitor;
    }
}
