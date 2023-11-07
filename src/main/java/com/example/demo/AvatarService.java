package com.example.demo;

import java.util.Collection;

public class AvatarService {

    public Collection<Avatar> find(int page, int pageSize){

        return avatarRepository.findAll(PageRequest.of(page, pageSize)).getContent();
    }
}
