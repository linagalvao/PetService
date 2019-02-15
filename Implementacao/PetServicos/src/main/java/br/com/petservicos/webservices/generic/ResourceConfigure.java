package br.com.petservicos.webservices.generic;

import br.com.petservicos.webservices.exception.ServerExceptionInterceptor;

import org.apache.log4j.PropertyConfigurator;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Configure exposed resources by jersey.
 *
 * @author Lina
 */
public final class ResourceConfigure extends ResourceConfig {

    /**
     * Default constructor.
     */
    public ResourceConfigure() {
        packages("br.com.petservicos.webservices");

        PropertyConfigurator.configure(ResourceConfigure.class.getClassLoader().getResource("log4j.properties"));
        register(ServerExceptionInterceptor.class);

        /*
        Quaisquer classes singleton inicializar aqui
        try {
            SuaClasseSingleton.getInstance();
        } catch (ExcecaoEspecifica e) {
            e.printStackTrace();
        }
        */
    }
}