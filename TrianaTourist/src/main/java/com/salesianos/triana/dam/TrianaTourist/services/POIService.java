package com.salesianos.triana.dam.TrianaTourist.services;

import com.salesianos.triana.dam.TrianaTourist.errors.exceptions.ListEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.errors.exceptions.SingleEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.models.POI;
import com.salesianos.triana.dam.TrianaTourist.repositories.POIRepositoy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class POIService {

    private final POIRepositoy poiRepositoy;


    public List<POI> findAll() {
        List<POI> result = poiRepositoy.findAll();

        if (result.isEmpty()) {
            throw new ListEntityNotFoundException(POI.class);
        } else {
            return result;
        }
    }

    public POI findById(Long id) {
        return poiRepositoy.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));
    }


    //FALTA EDITAR Y CREAR

    public void deleteById(Long id) {

        Optional<POI> estacionServicio = poiRepositoy.findById(id);
        if(estacionServicio.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(),POI.class);
        }else{
            poiRepositoy.deleteById(id);
        }
    }
}
