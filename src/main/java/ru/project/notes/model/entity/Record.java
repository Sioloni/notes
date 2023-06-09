package ru.project.notes.model.entity;


import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ElementCollection
    @CollectionTable(name = "tags", joinColumns = @JoinColumn(name = "record_id"))
    private List<String> tags;

    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    @Column(nullable = false)
    private String text;

    @ManyToMany(cascade = {CascadeType.REFRESH, CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "record_record", joinColumns = @JoinColumn(name = "record_two_id"),
            inverseJoinColumns = @JoinColumn(name = "record_one_id"))
    private Set<Record> records = new HashSet<>();
}
