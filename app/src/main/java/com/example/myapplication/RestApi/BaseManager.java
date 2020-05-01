package com.example.myapplication.RestApi;

public class BaseManager {
    //8: bu sınıf bize RestApi interface ini döndürecek
    //bu sınıf bizim hem interface mizdeki url i hem de baseUrl deki ana url i getirecek

    protected RestApi getRestapiClient()
    {
        RestApiClient restApiClient=new RestApiClient(BaseUrl.url);
        return restApiClient.getRestApi();

    }
}
