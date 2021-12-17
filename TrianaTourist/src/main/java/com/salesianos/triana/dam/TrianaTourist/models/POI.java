package com.salesianos.triana.dam.TrianaTourist.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class POI {

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

    private String coverPhoto;

    private String photo2;

    private String photo3;

    @ManyToMany
    private List<Route> listRoutes = new ArrayList<>();


}
