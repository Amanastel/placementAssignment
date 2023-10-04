package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Owner {
    @Id
    private Long id;
    private String avatar_url;
    private String html_url;
    private String type;
    private String site_admin;

    @ManyToOne
    private GitHubDataEntity gitHubDataEntity;
}
