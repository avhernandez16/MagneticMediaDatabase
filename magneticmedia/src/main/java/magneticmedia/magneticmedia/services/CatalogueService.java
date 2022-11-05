package magneticmedia.magneticmedia.services;

import magneticmedia.magneticmedia.dtos.CatalogueDto;
import magneticmedia.magneticmedia.dtos.CatalogueEditionDto;
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

    public void editCatalogue(CatalogueEditionDto catalogueEditionDto) {
        CatalogueId newCatalogueId = new CatalogueId(catalogueEditionDto.getNewServerIpV4(), catalogueEditionDto.getNewServerName(), catalogueEditionDto.getNewCatalogueName());
        Optional<Catalogue> catalogueWithNewCatalogueId = catalogueRepository.findByCatalogueId(newCatalogueId);
        if(catalogueWithNewCatalogueId.isPresent()){
            throw new CatalogueException("La IpV4, el nombre de servicor o el nombre del catalogo ingresados ya se encuentran en uso");
        }

        CatalogueId oldCatalogueId = new CatalogueId(catalogueEditionDto.getOldServerIpV4(), catalogueEditionDto.getOldServerName(), catalogueEditionDto.getOldCatalogueName());
        Optional<Catalogue> catalogueWithOldCatalogueId = catalogueRepository.findByCatalogueId(oldCatalogueId);
        if(catalogueWithOldCatalogueId.isEmpty()){
            throw new CatalogueException("No existe un catalogo con dicha IpV4, nombre de servicor y/o el nombre del catalogo");
        }else{
            Catalogue catalogueToUpdate = catalogueWithOldCatalogueId.get();
            catalogueToUpdate.setCatalogueId(newCatalogueId);
            catalogueRepository.save(catalogueToUpdate);
        }
    }
}
