package ru.neotoria.gempl.microservices.domain.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "material_block_article_text_part")
@Entity
public class MaterialBlockArticleTextPart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "localization_context_id", nullable = false)
    private Long localizationContentId;

    @Column(name = "material_block_id", nullable = false)
    private UUID materialBlockId;
}
