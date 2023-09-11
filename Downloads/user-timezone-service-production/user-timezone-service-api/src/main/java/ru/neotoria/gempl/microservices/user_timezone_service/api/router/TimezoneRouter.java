package ru.neotoria.gempl.microservices.user_timezone_service.api.router;

public interface TimezoneRouter {
    String ROOT = "/timezone";

    String SEARCH = ROOT + "/search";


    interface ID {
        String ROOT = TimezoneRouter.ROOT + PathVariables.ID;
    }

    interface PathVariables {
        String ID = "/{id}";
    }
}
