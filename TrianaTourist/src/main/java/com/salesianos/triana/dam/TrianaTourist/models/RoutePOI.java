package com.salesianos.triana.dam.TrianaTourist.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoutePOI implements Serializable {

    @Builder.Default
    @EmbeddedId
    private RoutePOIPk id = new RoutePOIPk();

    @ManyToOne
    @MapsId("poi_id")
    @JoinColumn(name = "poi_id")
    private POI poi;

    @ManyToOne
    @MapsId("route_id")
    @JoinColumn(name = "route_id")
    private Route route;


    //HELPERS
    //**************************************************

    public void addToPOI(POI p){
        this.poi = p;
        p.getListRoute().add(this);
    }

    public void deleteFromPOI(POI p){
        p.getListRoute().remove(this);
        this.poi = null;
    }

    public void addToRoute(Route r){
        this.route = r;
        r.getSteps().add(this);
    }

    public void deleteFromRoute(Route r){
        r.getSteps().remove(this);
        this.route = null;
    }

}
