package tr.ms.csgb.deneme.singleton;

public class RootSingleton {

    private static RootSingleton rootInstance;

    ServiceDataSingleton serviceDataSingleton;

    public ServiceDataSingleton getServiceDataSingleton() {
        return serviceDataSingleton.getInstance();
    }

    public void setServiceDataSingleton(ServiceDataSingleton serviceDataSingleton) {
        this.serviceDataSingleton = serviceDataSingleton;
    }

    public static RootSingleton getRootInstance(){
        if(rootInstance == null)
            rootInstance = new RootSingleton();
        return rootInstance;
    }
}
