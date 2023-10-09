package ru.neotoria.gempl.microservices.domain.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.neotoria.gempl.microservices.payload.constant.ESourceType;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "material_block_article_structure")
@Entity
public class MaterialBlockArticleStructure {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "material_block_id", nullable = false)
    private MaterialBlockArticle materialBlockId;

    @Column(name = "material_block_article_type_id", nullable = false)
    private UUID materialBlockArticleTypeId;

    @Column(name = "source_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ESourceType sourceType;

    @Column(nullable = false)
    private Long position;
}
