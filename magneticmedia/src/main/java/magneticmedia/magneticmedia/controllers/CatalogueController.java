package magneticmedia.magneticmedia.controllers;

import magneticmedia.magneticmedia.security.ValidateInternalJwt;
import magneticmedia.magneticmedia.dtos.CatalogueAdditionDto;
import magneticmedia.magneticmedia.services.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CatalogueController {

    @Autowired
    private CatalogueService catalogueService;

    @ValidateInternalJwt
    @PostMapping("/catalogue/add")
    public ResponseEntity<CatalogueAdditionDto> addCatalogo(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody CatalogueAdditionDto catalogueAdditionDto){

        catalogueService.addCatalogo(catalogueAdditionDto);
        return ResponseEntity.ok().build();
    }
}
