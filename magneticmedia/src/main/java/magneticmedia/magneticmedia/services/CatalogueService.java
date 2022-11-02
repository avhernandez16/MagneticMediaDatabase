package magneticmedia.magneticmedia.services;

import magneticmedia.magneticmedia.dtos.CatalogueAdditionDto;
import magneticmedia.magneticmedia.exceptions.CatalogException;
import magneticmedia.magneticmedia.models.Catalogue;
import magneticmedia.magneticmedia.models.CatalogueId;
import magneticmedia.magneticmedia.models.Ciclo;
import magneticmedia.magneticmedia.repositories.CatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CatalogueService {

    @Autowired
    private CatalogueRepository catalogueRepository;

    public void addCatalogo(CatalogueAdditionDto catalogueAdditionDto) {

        CatalogueId catalogueId = new CatalogueId(catalogueAdditionDto.getServerIpV4(), catalogueAdditionDto.getServerName(), catalogueAdditionDto.getCatalogueName());

        Optional<Catalogue> catalogueWithCatalogueId = catalogueRepository.findByCatalogueId(catalogueId);
        if(catalogueWithCatalogueId.isPresent()){
            throw new CatalogException("Ya existe un catalogo el sistema con ese nombre, ip de servidor o nombre de servidor");
        }

        Catalogue newCatalogue = new Catalogue(catalogueId, Ciclo.SEMANAL);
        catalogueRepository.save(newCatalogue);
    }
}
