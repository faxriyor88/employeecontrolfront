package sample;

import com.google.gson.Gson;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import sample.dto.DocumentEffectorDtoResponse;
import sample.page.PageDocument;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
            Gson gson = new Gson(); //empproba.herokuapp.com
            GetMethod getMethod = new GetMethod("http://localhost:8080/api/viewdocument/0?deadlinetype=GREEN"/*"http://localhost:8080/api/employee/getallemployee/0"*/);
            getMethod.setRequestHeader("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0dHI3IiwiaWF0IjoxNjQ0MzI2ODkzLCJleHAiOjE2NDQzNDEyOTN9.8rwMu1NdWm7guRvwd5yKmn56kZRmGL2IJpMr0FXUq6Q");
            HttpClient client = new HttpClient();
            int i = client.executeMethod(getMethod);
            System.out.println(i);
            BufferedReader reader = new BufferedReader(new InputStreamReader(getMethod.getResponseBodyAsStream()));
            PageDocument list = gson.fromJson(reader, PageDocument.class);
            System.out.println(list.getContent().get(0).getDeadLineDay());


    }

}

