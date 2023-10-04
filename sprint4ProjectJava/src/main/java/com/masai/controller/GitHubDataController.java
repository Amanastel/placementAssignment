package com.masai.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.masai.model.GitHubDataEntity;
import com.masai.model.Owner;
import com.masai.repository.GitHubDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GitHubDataController {

    @Autowired
    private GitHubDataRepository repository;


    @PostMapping("/github")
    public List<Object> fetchAndSaveGitHubData() {
        String apiUrl = "https://api.github.com/users/mralexgray/repos";

        RestTemplate restTemplate = new RestTemplate();
        Object[] objects = restTemplate.getForObject(apiUrl, Object[].class);
        System.out.println("objects = " + Arrays.asList(objects));

        ObjectMapper objectMapper = new ObjectMapper();
        List<GitHubDataEntity> gitHubDataEntities = Arrays.stream(objects)
                .map(object -> objectMapper.convertValue(object, GitHubDataEntity.class))
                .toList();

//        System.out.println("gitHubDataEntities = " + gitHubDataEntities);

//        GitHubDataEntity gitHubDataEntit = new GitHubDataEntity();
//
//        gitHubDataEntities.forEach(gitHubDataEntity -> {
//            gitHubDataEntit.setCreated_at(LocalDateTime.now());
//            gitHubDataEntit.setId(gitHubDataEntity.getId());
//            gitHubDataEntit.setName(gitHubDataEntity.getName());
//            gitHubDataEntit.setHtml_url(gitHubDataEntity.getHtml_url());
//            gitHubDataEntit.setDescription(gitHubDataEntity.getDescription());
//            gitHubDataEntit.setOpen_issues(gitHubDataEntity.getOpen_issues());
//            gitHubDataEntit.setWatchers(gitHubDataEntity.getWatchers());
////            gitHubDataEntity.setOwner(gitHubDataEntity.getOwner());
//            Owner owner = new Owner();
//            gitHubDataEntity.getOwner().forEach(owners -> {
//                owner.setId(owners.getId());
//                owner.setAvatar_url(owners.getAvatar_url());
//                owner.setHtml_url(owners.getHtml_url());
//                owner.setType(owners.getType());
//                owner.setSite_admin(owners.getSite_admin());
//                owner.setGitHubDataEntity(gitHubDataEntit);
//            });
//            gitHubDataEntit.getOwner().add(owner);
//
//
//            repository.save(gitHubDataEntity);

//        });

        return Arrays.asList(objects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GitHubDataEntity> getGitHubDataById(@PathVariable Long id) {
        GitHubDataEntity githubData = repository.findById(id).orElse(null);

        if (githubData != null) {
            return ResponseEntity.ok(githubData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
