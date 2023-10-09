package ru.neotoria.gempl.microservices.api.router;

public interface MaterialBlockArticleRouter {
    String ROOT = "/material/block/article";
    String FILE = ROOT + "/file";
    String TEXT = ROOT + "/text";
    String STRUCTURE = ROOT + "/structure";

    String CREATE = ROOT + "/creating";
    String FILE_CREATE = FILE + "/creating";
    String TEXT_CREATE = TEXT + "/creating";
    String STRUCTURE_CREATE = STRUCTURE + "/creating";

    String STRUCTURE_FILTER = STRUCTURE + "/filter";


    interface ID {
        String ROOT = MaterialBlockArticleRouter.ROOT + PathVariables.ID;
        String FILE = MaterialBlockArticleRouter.FILE + PathVariables.ID;
        String TEXT = MaterialBlockArticleRouter.TEXT + PathVariables.ID;
        String STRUCTURE = MaterialBlockArticleRouter.STRUCTURE + PathVariables.ID;

        String DELETE = ROOT + "/deleting";
        String FILE_DELETE = FILE + "/deleting";
        String TEXT_DELETE = TEXT + "/deleting";
        String STRUCTURE_DELETE = STRUCTURE + "/deleting";

        String UPDATE = ROOT + "/updating";
        String FILE_UPDATE = FILE + "/updating";
        String TEXT_UPDATE = TEXT + "/updating";
        String STRUCTURE_UPDATE = STRUCTURE + "/updating";
    }

    interface PathVariables {
        String ID = "/{id}";
    }

}
