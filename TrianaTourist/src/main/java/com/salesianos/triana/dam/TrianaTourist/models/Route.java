package com.salesianos.triana.dam.TrianaTourist.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Route implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Builder.Default
    @ManyToMany
    private List<POI> steps = new ArrayList<>();


    //HELPPERS

    public void addToRoute(POI p){
        steps.add(p);
    }

    public void removeToRoute(POI p){
        steps.remove(p);
    }
}
