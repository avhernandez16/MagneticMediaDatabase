package magneticmedia.magneticmedia.services;

import magneticmedia.magneticmedia.dtos.CatalogueDto;
import magneticmedia.magneticmedia.exceptions.CatalogueException;
import magneticmedia.magneticmedia.models.Catalogue;
import magneticmedia.magneticmedia.models.CatalogueId;
import magneticmedia.magneticmedia.models.Ciclo;
import magneticmedia.magneticmedia.repositories.CatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CatalogueService {

    @Autowired
    private CatalogueRepository catalogueRepository;

    public void addCatalogo(CatalogueDto catalogueDto) {

        CatalogueId catalogueId = new CatalogueId(catalogueDto.getServerIpV4(), catalogueDto.getServerName(), catalogueDto.getCatalogueName());

        Optional<Catalogue> catalogueWithCatalogueId = catalogueRepository.findByCatalogueId(catalogueId);
        if(catalogueWithCatalogueId.isPresent()){
            throw new CatalogueException("Ya existe un catalogo el sistema con ese nombre, ip de servidor o nombre de servidor");
        }

        Catalogue newCatalogue = new Catalogue(catalogueId, Ciclo.SEMANAL);
        catalogueRepository.save(newCatalogue);
    }

    public void deleteCatalogue(CatalogueDto catalogueDto) {
        CatalogueId catalogueId = new CatalogueId(catalogueDto.getServerIpV4(), catalogueDto.getServerName(), catalogueDto.getCatalogueName());
        try{
            catalogueRepository.deleteById(catalogueId);
        }catch (EmptyResultDataAccessException ignored){

        }
    }
}
