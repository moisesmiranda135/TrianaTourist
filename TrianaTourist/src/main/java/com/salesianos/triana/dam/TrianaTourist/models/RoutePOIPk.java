package com.salesianos.triana.dam.TrianaTourist.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoutePOIPk implements Serializable {

    private Long poi_id;
    private Long route_id;
}
