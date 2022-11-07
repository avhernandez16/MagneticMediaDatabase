package magneticmedia.magneticmedia.controllers;

import magneticmedia.magneticmedia.dtos.CatalogueEditionDto;
import magneticmedia.magneticmedia.security.ValidateInternalJwt;
import magneticmedia.magneticmedia.dtos.CatalogueDto;
import magneticmedia.magneticmedia.services.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CatalogueController {

    @Autowired
    private CatalogueService catalogueService;

    @ValidateInternalJwt
    @PostMapping("/catalogue/add")
    public ResponseEntity<CatalogueDto> addCatalogo(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody CatalogueDto catalogueDto){

        catalogueService.addCatalogo(catalogueDto);
        return ResponseEntity.ok().build();
    }

    @ValidateInternalJwt
    @DeleteMapping("/catalogue/delete/{catalogueToDeleteName}")
    public ResponseEntity<CatalogueDto> deleteCatalogo(
            @RequestHeader("Authorization") String token,
            @PathVariable String catalogueToDeleteName){

        catalogueService.deleteCatalogue(catalogueToDeleteName);
        return ResponseEntity.ok().build();
    }

    @ValidateInternalJwt
    @PutMapping("/catalogue/edit/{catalogueToEditName}")
    public ResponseEntity<CatalogueDto> editCatalogo(
            @RequestHeader("Authorization") String token,
            @PathVariable String catalogueToEditName,
            @Valid @RequestBody CatalogueEditionDto catalogueEditionDto){

        catalogueService.editCatalogue(catalogueToEditName, catalogueEditionDto);
        return ResponseEntity.ok().build();
    }
}
