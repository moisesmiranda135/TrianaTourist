package com.salesianos.triana.dam.TrianaTourist.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class POI implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    @Lob
    private String description;

    private LocalDate date;

    @ManyToOne
    private Category category;

    @Lob
    private String coverPhoto;

    @Lob
    private String photo2;

    @Lob
    private String photo3;


    @Builder.Default
    @OneToMany(mappedBy = "poi",cascade = CascadeType.REMOVE)
    private List<RoutePOI> listRoute = new ArrayList<>();



}
