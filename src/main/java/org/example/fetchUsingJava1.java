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


public class fetchUsingJava1 {
    public static void main(String[] args){
        try {
            fetchUsingJava1();
        }
        catch (URISyntaxException e){
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void fetchUsingJava1()  throws URISyntaxException, IOException{
        URIBuilder builder= new URIBuilder("https://api.chucknorris.io/jokes/random");

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