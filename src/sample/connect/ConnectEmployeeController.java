package sample.connect;

import com.google.gson.Gson;
import javafx.stage.DirectoryChooser;
import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import sample.dto.*;
import sample.model.District;
import sample.model.Employee;
import sample.model.Region;
import sample.page.Page;
import sample.page.PageDocument;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


public class ConnectEmployeeController {
    @SneakyThrows
    public static ApiResponse addEmployee(File image, EmployeeDto employeeDto) throws IOException {
        String base64 = "data:image/png;base64," + encodeFileToBase64Binary(image);
        String token = getToken();
        Gson gson = new Gson();
        PostMethod filePost = new PostMethod("https://empproba.herokuapp.com/api/employee/addemployee"/*"http://localhost:8080/api/employee/addemployee"*/);
        filePost.setRequestHeader("Authorization", "Bearer " + token);
        Part[] parts = {
                // new FilePart("image", image, "image/jpeg", "UTF-8"),
                new StringPart("image", base64), new StringPart("employeeDto", gson.toJson(employeeDto))};
        filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));
        HttpClient client = new HttpClient();
        client.executeMethod(filePost);
        BufferedReader reader = new BufferedReader(new InputStreamReader(filePost.getResponseBodyAsStream()));
        return gson.fromJson(reader, ApiResponse.class);
    }

    @SneakyThrows
    public static ApiResponse addDocument(File file, DocumentEffectorDto effectorDto){
        String token = getToken();
        Gson gson = new Gson();
        PostMethod filePost = new PostMethod("http://localhost:8080/api/addocument"/*"http://localhost:8080/api/employee/addemployee"*/);
        filePost.setRequestHeader("Authorization", "Bearer " + token);
        Part[] parts = {
                 new FilePart("file", file, "image/jpeg", "UTF-8"),
                new StringPart("documentEffectorDto", gson.toJson(effectorDto))};
        filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));
        HttpClient client = new HttpClient();
        client.executeMethod(filePost);
        BufferedReader reader = new BufferedReader(new InputStreamReader(filePost.getResponseBodyAsStream()));
        System.out.println("OK");
        return gson.fromJson(reader, ApiResponse.class);
    }

    public static ApiResponse editEmployee(File image, EmployeeDto employeeDto, UUID uuid) throws IOException {
        String token = getToken();
        Gson gson = new Gson();
        PutMethod putMethod = new PutMethod("http://empproba.herokuapp.com/api/employee/editemployee/" + uuid);
        putMethod.setRequestHeader("Authorization", "Bearer " + token);
        Part[] parts = {new FilePart("image", image, "image/png", "UTF-8"), new StringPart("employeeDto", gson.toJson(employeeDto))};
        putMethod.setRequestEntity(new MultipartRequestEntity(parts, putMethod.getParams()));
        HttpClient client = new HttpClient();
        client.executeMethod(putMethod);
        BufferedReader reader = new BufferedReader(new InputStreamReader(putMethod.getResponseBodyAsStream()));
        return gson.fromJson(reader, ApiResponse.class);
    }

    public static ApiResponse deleteEmployee(UUID uuid) throws IOException {
        String token = getToken();
        Gson gson = new Gson();
        DeleteMethod deleteMethod = new DeleteMethod("https://empproba.herokuapp.com/api/employee/deleteemployee/" /*"http://localhost:8080/api/employee/deleteemployee/"*/ + uuid);
        deleteMethod.setRequestHeader("Authorization", "Bearer " + token);
        HttpClient client = new HttpClient();
        client.executeMethod(deleteMethod);
        BufferedReader reader = new BufferedReader(new InputStreamReader(deleteMethod.getResponseBodyAsStream()));
        return gson.fromJson(reader, ApiResponse.class);
    }

    public static List<Employee> getAllEmployee() throws IOException {
        String token = getToken();
        Gson gson = new Gson(); //empproba.herokuapp.com
        GetMethod getMethod = new GetMethod("https://empproba.herokuapp.com/api/employee/getallemployee/0"/*"http://localhost:8080/api/employee/getallemployee/0"*/);
        getMethod.setRequestHeader("Authorization", "Bearer " + token);
        HttpClient client = new HttpClient();
        client.executeMethod(getMethod);
        BufferedReader reader = new BufferedReader(new InputStreamReader(getMethod.getResponseBodyAsStream()));
        Page list = gson.fromJson(reader, Page.class);
        return list.getContent();
    }

    public static ApiResponse login(String username, String password) throws IOException {
        Gson gson = new Gson();//empproba.herokuapp.com //localhost:8080
        LoginDto loginDTO1 = new LoginDto(username, password);
        PostMethod filePost = new PostMethod("http://localhost:8080/api/login");
        filePost.setRequestEntity(new StringRequestEntity(gson.toJson(loginDTO1), "application/json", "UTF-8"));
        System.out.println(username);
        System.out.println(password);
        HttpClient client = new HttpClient();
        int i = client.executeMethod(filePost);
        if (String.valueOf(i).contains("20")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(filePost.getResponseBodyAsStream()));
            TokenAndWho tokenAndWho=gson.fromJson(reader,TokenAndWho.class);
            System.out.println(tokenAndWho.getWho());
            tokenSaver(tokenAndWho.getToken());
            return new ApiResponse(tokenAndWho.getWho(), true);
        }
        System.out.println(i);
        return new ApiResponse(filePost.getResponseBodyAsString(), false);
    }

    public static void employeeDownloader(UUID uuid) throws IOException {
        String token = getToken();
        DirectoryChooser dirChooser = new DirectoryChooser();
        File chosenDir = dirChooser.showDialog(null);
        if (chosenDir != null) {
            GetMethod getMethod = new GetMethod("https://empproba.herokuapp.com/api/download/employeeaboutinformation/"/*"http://localhost:8080/api/download/employeeaboutinformation/"*/ + uuid);
            getMethod.setRequestHeader("Authorization", "Bearer " + token);
            HttpClient client = new HttpClient();
            try {
                client.executeMethod(getMethod);
                String filename = getMethod.getResponseHeader("Content-Disposition").getValue();
                filename = filename.substring(21, filename.length() - 1);
                File exis = new File(chosenDir.getAbsolutePath() + "/" + filename);
                if (!exis.exists()) {
                    Path path = Paths.get(chosenDir.getAbsolutePath() + "/" + filename);
                    Files.copy(getMethod.getResponseBodyAsStream(), path);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void documentDownloader(UUID uuid) throws IOException {
        String token = getToken();
        DirectoryChooser dirChooser = new DirectoryChooser();
        File chosenDir = dirChooser.showDialog(null);
        if (chosenDir != null) {
            GetMethod getMethod = new GetMethod("http://localhost:8080/api/downloaddocument/"/*"http://localhost:8080/api/download/employeeaboutinformation/"*/ + uuid);
            getMethod.setRequestHeader("Authorization", "Bearer " + token);
            HttpClient client = new HttpClient();
            try {
                client.executeMethod(getMethod);
                String filename = getMethod.getResponseHeader("Content-Disposition").getValue();
                filename = filename.substring(21, filename.length() - 1);
                File exis = new File(chosenDir.getAbsolutePath() + "/" + filename);
                if (!exis.exists()) {
                    Path path = Paths.get(chosenDir.getAbsolutePath() + "/" + filename);
                    Files.copy(getMethod.getResponseBodyAsStream(), path);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static EmployeeAdditonalDTO getExtractInformation(UUID uuid) throws IOException {
        Gson gson = new Gson();
        String token = getToken();
        GetMethod getMethod = new GetMethod("https://empproba.herokuapp.com/api/employee/getemployeeadditional/" /*"http://localhost:8080/api/employee/getemployeeadditional/"*/ + uuid);
        getMethod.setRequestHeader("Authorization", "Bearer " + token);
        HttpClient client = new HttpClient();
        client.executeMethod(getMethod);
        BufferedReader reader = new BufferedReader(new InputStreamReader(getMethod.getResponseBodyAsStream()));
        return gson.fromJson(reader, EmployeeAdditonalDTO.class);

    }

    public static List<Region> sugRegion() throws IOException {
        Gson gson = new Gson();
        String token = getToken();
        GetMethod getMethod = new GetMethod("https://empproba.herokuapp.com/api/suggestion/region"/*"http://localhost:8080/api/suggestion/region"*/);
        getMethod.setRequestHeader("Authorization", "Bearer " + token);
        HttpClient client = new HttpClient();
        client.executeMethod(getMethod);
        BufferedReader reader = new BufferedReader(new InputStreamReader(getMethod.getResponseBodyAsStream()));
        Region[] regions = gson.fromJson(reader, Region[].class);
        return new ArrayList<>(Arrays.asList(regions));
    }

    public static List<District> sugDistrict(Integer regionId) throws IOException {
        Gson gson = new Gson();
        String token = getToken();
        GetMethod getMethod = new GetMethod("https://empproba.herokuapp.com/api/suggestion/district/"/*"http://localhost:8080/api/suggestion/district/"*/ + regionId);
        getMethod.setRequestHeader("Authorization", "Bearer " + token);
        HttpClient client = new HttpClient();
        client.executeMethod(getMethod);
        BufferedReader reader = new BufferedReader(new InputStreamReader(getMethod.getResponseBodyAsStream()));
        District[] districts = gson.fromJson(reader, District[].class);
        return new ArrayList<>(Arrays.asList(districts));
    }

    public static List<District> sugAllDistrict() throws IOException {
        Gson gson = new Gson();
        String token = getToken();
        GetMethod getMethod = new GetMethod("https://empproba.herokuapp.com/api/suggestion/getalldistrict"/*"http://localhost:8080/api/suggestion/district/"*/);
        getMethod.setRequestHeader("Authorization", "Bearer " + token);
        HttpClient client = new HttpClient();
        client.executeMethod(getMethod);
        BufferedReader reader = new BufferedReader(new InputStreamReader(getMethod.getResponseBodyAsStream()));
        District[] districts = gson.fromJson(reader, District[].class);
        return new ArrayList<>(Arrays.asList(districts));
    }

    public static List<CompanyDTO> sugCompany() throws IOException {
        Gson gson = new Gson();
        String token = getToken();
        GetMethod getMethod = new GetMethod("https://empproba.herokuapp.com/api/suggestion/company"/*"http://localhost:8080/api/suggestion/company"*/);
        getMethod.setRequestHeader("Authorization", "Bearer " + token);
        HttpClient client = new HttpClient();
        client.executeMethod(getMethod);
        BufferedReader reader = new BufferedReader(new InputStreamReader(getMethod.getResponseBodyAsStream()));
        CompanyDTO[] districts = gson.fromJson(reader, CompanyDTO[].class);
        return new ArrayList(Arrays.asList(districts));
    }

    public static List<ManagerDtoOfDocumentEffector> sugManagerOfDocumentEffector() throws IOException {
        Gson gson = new Gson();
        String token = getToken();
        GetMethod getMethod = new GetMethod("http://localhost:8080/manag/getallmanagerofdocumenteffector"/*"http://localhost:8080/api/suggestion/company"*/);
        getMethod.setRequestHeader("Authorization", "Bearer " + token);
        HttpClient client = new HttpClient();
        client.executeMethod(getMethod);
        BufferedReader reader = new BufferedReader(new InputStreamReader(getMethod.getResponseBodyAsStream()));
        ManagerDtoOfDocumentEffector[] districts = gson.fromJson(reader, ManagerDtoOfDocumentEffector[].class);
        return new ArrayList(Arrays.asList(districts));
    }

    public static List<DocumentEffectorDtoResponse> getAllDocumentEffector(String deadlineColor) throws IOException {
        String token = getToken();
        Gson gson = new Gson(); //empproba.herokuapp.com
        GetMethod getMethod = new GetMethod("http://localhost:8080/api/viewdocument/0?deadlinetype="+deadlineColor/*"http://localhost:8080/api/employee/getallemployee/0"*/);
        getMethod.setRequestHeader("Authorization", "Bearer " + token);
        HttpClient client = new HttpClient();
        int i = client.executeMethod(getMethod);

        BufferedReader reader = new BufferedReader(new InputStreamReader(getMethod.getResponseBodyAsStream()));
        PageDocument list = gson.fromJson(reader, PageDocument.class);
        return list.getContent();
    }

    public static File jsonWriter(EmployeeDto employeeDto) throws IOException {
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        employeeDtos.add(employeeDto);
        Gson gson = new Gson();
        File file = new File("src/sample/dto/package.json");
        FileWriter fileWriter = new FileWriter(file);
        gson.toJson(employeeDtos, fileWriter);
        fileWriter.close();
        return file;
    }

    public static boolean netChecker() throws MalformedURLException {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = connection = url.openConnection();
            connection.connect();
            return true;
        } catch (IOException e) {
           return false;
        }
    }

    private static void tokenSaver(String token) throws IOException {
        FileWriter fileWriter = new FileWriter("src/sample/token/token.txt");
        fileWriter.write(token);
        fileWriter.close();
//        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
//        String s = bufferedReader.readLine();
    }

    private static String getToken() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/sample/token/token.txt"));
        return bufferedReader.readLine();
    }

    private static String encodeFileToBase64Binary(File file) throws Exception {
        FileInputStream fileInputStreamReader = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        fileInputStreamReader.read(bytes);
        return new String(Base64.encodeBase64(bytes), "UTF-8");
    }
}
