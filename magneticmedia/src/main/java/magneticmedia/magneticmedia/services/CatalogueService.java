package magneticmedia.magneticmedia.services;

import magneticmedia.magneticmedia.dtos.CatalogueDto;
import magneticmedia.magneticmedia.dtos.CatalogueEditionDto;
import magneticmedia.magneticmedia.exceptions.CatalogueException;
import magneticmedia.magneticmedia.models.Catalogue;
import magneticmedia.magneticmedia.models.Server;
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
        Optional<Catalogue> catalogueWithCatalogueId = catalogueRepository.findById(catalogueDto.getCatalogueName());
        if(catalogueWithCatalogueId.isPresent()){
            throw new CatalogueException("Ya existe un catalogo el sistema con ese nombre, ip de servidor o nombre de servidor");
        }

        Catalogue newCatalogue = catalogueDto.getCycle().createCatalogue(catalogueDto);
        catalogueRepository.save(newCatalogue);
    }

    public void deleteCatalogue(String catalogueToDeleteName) {
        try{
            catalogueRepository.deleteById(catalogueToDeleteName);
        }catch (EmptyResultDataAccessException ignored){}
    }

    public void editCatalogue(CatalogueEditionDto catalogueEditionDto) {
        /*Server newServer = new Server(catalogueEditionDto.getNewServerIpV4(), catalogueEditionDto.getNewServerName(), catalogueEditionDto.getNewCatalogueName());
        Optional<Catalogue> catalogueWithNewCatalogueId = catalogueRepository.findByCatalogueId(newServer);
        if(catalogueWithNewCatalogueId.isPresent()){
            throw new CatalogueException("La IpV4, el nombre de servicor o el nombre del catalogo ingresados ya se encuentran en uso");
        }

        Server oldServer = new Server(catalogueEditionDto.getOldServerIpV4(), catalogueEditionDto.getOldServerName(), catalogueEditionDto.getOldCatalogueName());
        Optional<Catalogue> catalogueWithOldCatalogueId = catalogueRepository.findByCatalogueId(oldServer);
        if(catalogueWithOldCatalogueId.isEmpty()){
            throw new CatalogueException("No existe un catalogo con dicha IpV4, nombre de servicor y/o el nombre del catalogo");
        }else{
            Catalogue catalogueToUpdate = catalogueWithOldCatalogueId.get();
            catalogueToUpdate.setServer(newServer);
            catalogueRepository.save(catalogueToUpdate);
        }*/
    }
}
