package magneticmedia.magneticmedia.models.enums;

import magneticmedia.magneticmedia.dtos.CatalogueDto;
import magneticmedia.magneticmedia.models.Catalogue;
import magneticmedia.magneticmedia.models.Server;

public enum Cycle {

    DAILY,
    WEEKLY{
        @Override
        public Catalogue createCatalogue(CatalogueDto catalogueDto){
            Server server = createServer(catalogueDto.getServerIpV4(), catalogueDto.getServerName());
            return WeeklyCatalogue.builder()
                    .catalogueName(catalogueDto.getCatalogueName())
                    .server(server)
                    .cycle(this)
                    .tecnology(catalogueDto.getTecnology())
                    .program(catalogueDto.getProgram())
                    .console(catalogueDto.getConsole())
                    .monthWeekNumber(catalogueDto.getMonthWeekNumber())
                    .build();
        }
    },
    MONTHLY;

    protected Server createServer(String serverIpV4, String serverName) {
        return new Server(serverIpV4, serverIpV4);
    }

    public Catalogue createCatalogue(CatalogueDto catalogueDto){
        Server server = createServer(catalogueDto.getServerIpV4(), catalogueDto.getServerName());
        return Catalogue.builder()
                .catalogueName(catalogueDto.getCatalogueName())
                .server(server)
                .cycle(this)
                .tecnology(catalogueDto.getTecnology())
                .program(catalogueDto.getProgram())
                .console(catalogueDto.getConsole())
                .build();
    }
}
