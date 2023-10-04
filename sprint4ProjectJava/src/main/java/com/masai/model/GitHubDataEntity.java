package com.masai.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "github_data")
public class GitHubDataEntity {
    @Id
    private Long id;
    private String name;
    private String html_url;
    private String description;
    private LocalDateTime created_at;
    private Integer open_issues;
    private Integer watchers;

    @OneToMany(mappedBy = "gitHubDataEntity", cascade = CascadeType.ALL)
    private List<Owner> owner;
}
