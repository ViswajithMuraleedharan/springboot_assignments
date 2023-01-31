package org.example;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
public class fetchUsingJava2 {
    public static void main(String[] args) {
        try {
            fetchUsingJava2();
        }
        catch (URISyntaxException e){
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fetchUsingJava2()  throws URISyntaxException, IOException{
        URIBuilder builder= new URIBuilder("https://api.weatherbit.io/v2.0/current");

        builder.setParameter("lat","35.7796");
        builder.setParameter("lon","35.7796");
        builder.setParameter("key","07254cd3b82f4ae9a908aebac3baf974");
        builder.setParameter("include","minutely");

        HttpGet getData= new HttpGet(builder.build());

        CloseableHttpClient httpClient= HttpClients.createDefault();

        CloseableHttpResponse response=httpClient.execute(getData);


        if(response.getStatusLine().getStatusCode()==200) {
            HttpEntity responseEntity = response.getEntity();
            String result = EntityUtils.toString(responseEntity);
            System.out.println(result);
        }
        else{
            System.out.println("Something went wrong");
            return;
        }
        httpClient.close();
    }
}