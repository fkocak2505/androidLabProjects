package tr.ms.csgb.deneme.singleton;

import java.util.List;

import tr.ms.csgb.deneme.data_model.AddServiceListDataModel;

public class ServiceDataSingleton {

    private static ServiceDataSingleton serviceDataInstance;

    List<AddServiceListDataModel> serviceListDataModelList;

    public List<AddServiceListDataModel> getServiceListDataModelList() {
        return serviceListDataModelList;
    }

    public void setServiceListDataModelList(List<AddServiceListDataModel> serviceListDataModelList) {
        this.serviceListDataModelList = serviceListDataModelList;
    }

    public static ServiceDataSingleton getInstance(){
        if(serviceDataInstance == null)
            serviceDataInstance = new ServiceDataSingleton();
        return serviceDataInstance;
    }
}
