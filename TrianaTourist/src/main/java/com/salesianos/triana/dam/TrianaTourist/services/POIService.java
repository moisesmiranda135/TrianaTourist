package com.salesianos.triana.dam.TrianaTourist.services;

import com.salesianos.triana.dam.TrianaTourist.dto.POI.CreatePOIDTO;
import com.salesianos.triana.dam.TrianaTourist.dto.POI.GetPOIDTO;
import com.salesianos.triana.dam.TrianaTourist.dto.POI.POIDTOConverter;
import com.salesianos.triana.dam.TrianaTourist.errors.exceptions.ListEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.errors.exceptions.SingleEntityNotFoundException;
import com.salesianos.triana.dam.TrianaTourist.models.POI;
import com.salesianos.triana.dam.TrianaTourist.models.Route;
import com.salesianos.triana.dam.TrianaTourist.repositories.POIRepository;
import com.salesianos.triana.dam.TrianaTourist.repositories.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class POIService {

    private final POIRepository poiRepositoy;
    private final RouteRepository routeRepository;
    private final CategoryService categoryService;
    private final POIDTOConverter poidtoConverter;



    public List<GetPOIDTO> findAll() {
        List<POI> data = poiRepositoy.findAll();

        if (data.isEmpty()) {
            throw new ListEntityNotFoundException(POI.class);
        } else {
            List<GetPOIDTO> result =
                    data.stream()
                            .map(POIDTOConverter::POIToGetPOIDTO)
                            .collect(Collectors.toList());

            return result;
        }
    }

    public GetPOIDTO findById(Long id) {

        Optional<POI> data = poiRepositoy.findById(id);

        if (data.isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), POI.class);
        } else {
            List<GetPOIDTO> result =
                    data.stream()
                            .map(POIDTOConverter::POIToGetPOIDTO)
                            .collect(Collectors.toList());

            return poidtoConverter.POIToGetPOIDTO(poiRepositoy.findById(id).get());
        }

    }


    public POI save(CreatePOIDTO dto) {

        POI poi = POI.builder()
                .name(dto.getName())
                .category(categoryService.findById(dto.getCategory_id()))
                .date(dto.getDate())
                .location(dto.getLocation())
                .description(dto.getDescription())
                .coverPhoto(dto.getCoverPhoto())
                .photo2(dto.getPhoto2())
                .photo3(dto.getPhoto3())
                .build();

        return poiRepositoy.save(poi);
    }


    public CreatePOIDTO edit (CreatePOIDTO poi, Long id) {
        return poiRepositoy.findById(id).map(p -> {
            p.setName(poi.getName());
            p.setLocation(poi.getLocation());
            p.setDescription(poi.getDescription());
            p.setDate(poi.getDate());
            p.setCoverPhoto(poi.getCoverPhoto());
            p.setPhoto2(poi.getPhoto2());
            p.setPhoto3(poi.getPhoto3());
            p.setPhoto3(poi.getPhoto3());
            p.setCategory(categoryService.findById(poi.getCategory_id()));
            poiRepositoy.save(p);
            return poidtoConverter.editPOI(p);
        }).orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), POI.class));

    }


    public void deleteById(Long id) {

        Optional<POI> poi = poiRepositoy.findById(id);
        if(poi.isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(),POI.class);
        }else{
            poi.map(p -> {
                p.setCategory(null);
                poiRepositoy.save(p);
                poiRepositoy.deleteById(id);
                return ResponseEntity.noContent().build();
            });
        }
    }



}
