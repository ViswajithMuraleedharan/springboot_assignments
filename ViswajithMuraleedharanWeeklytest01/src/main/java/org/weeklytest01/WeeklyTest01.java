package org.weeklytest01;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class WeeklyTest01 {
    public static void main(String[] args) {

        try {
            jsonPlaceholder();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void jsonPlaceholder() throws URISyntaxException, IOException{
        URIBuilder builder= new URIBuilder("https://jsonplaceholder.typicode.com/albums");

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