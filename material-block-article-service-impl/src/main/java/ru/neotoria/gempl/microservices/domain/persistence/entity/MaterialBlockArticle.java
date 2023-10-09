package ru.neotoria.gempl.microservices.domain.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "material_block_article")
@Entity
public class MaterialBlockArticle {
    @Id
    private UUID materialBlockId;

    @OneToMany(mappedBy = "materialBlockId")
    private List<MaterialBlockArticleStructure> structures;
}
