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

    public void editCatalogue(String catalogueToEditName, CatalogueEditionDto catalogueEditionDto) {
        Optional<Catalogue> catalogueWithCatalogueId = catalogueRepository.findById(catalogueToEditName);
        if(catalogueWithCatalogueId.isEmpty()){
            throw new CatalogueException("No existe en el sistema un Catálogo con ese nombre, ip de servidor o nombre de servidor");
        }
        Catalogue catalogueToEdit = catalogueWithCatalogueId.get();
        if(catalogueToEdit.getCycle() != catalogueEditionDto.getCycle()){
            Server server = catalogueToEdit.getServer();
            CatalogueDto newCatalogueDto = new CatalogueDto(server.getServerIpV4(), server.getServerName(), catalogueToEdit.getCatalogueName(), catalogueEditionDto.getConsole(),
                    catalogueEditionDto.getCycle(), catalogueEditionDto.getProgram(), catalogueEditionDto.getTecnology(), catalogueEditionDto.getMonthWeekNumber());
            Catalogue newCatalogue = catalogueEditionDto.getCycle().createCatalogue(newCatalogueDto);
            catalogueRepository.delete(catalogueToEdit);
            catalogueRepository.save(newCatalogue);
        }else{
            catalogueToEdit.setConsole(catalogueEditionDto.getConsole());
            catalogueToEdit.setProgram(catalogueEditionDto.getProgram());
            catalogueToEdit.setTecnology(catalogueEditionDto.getTecnology());

            catalogueRepository.save(catalogueToEdit);
        }
    }
}
