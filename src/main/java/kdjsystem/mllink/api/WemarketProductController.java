package kdjsystem.mllink.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kdjsystem.mllink.dto.wemarket.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import lombok.var;
import net.minidev.json.JSONObject;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestBody.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@Validated
@RequestMapping("/wemarket/api/v1/")
public class WemarketProductController {
    private static final String Host = "https://w-api.wemakeprice.com/";



    // 배송정책..
    @GetMapping("getShipAPI")
    public Shippingpolicy getShipAPI( @RequestHeader("apiKey") String apiKey)
            throws IOException, JsonParseException, JsonMappingException {

//    // 배송정책..
//    @GetMapping("getShipAPI")
//    public ResultShipData getShipAPI( @RequestParam("policyno") Integer policyno,@RequestHeader("apiKey") String apiKey)
//            throws IOException, JsonParseException, JsonMappingException {

        String path = "/product/out/getSellerShipPolicy";

        System.out.println(apiKey);
//        Response response = null;
//
//        ObjectMapper mapper = new ObjectMapper();
//        OkHttpClient client = new OkHttpClient().newBuilder().build();
//
//        Request request = new Request.Builder().url(Host.concat(path)).method("GET", null)
//                .addHeader("apiKey", apiKey).build();
//
//        response = client.newCall(request).execute();
//
//        Shippingpolicy shipPolicy = mapper.readValue(response.body().string().toString(), Shippingpolicy.class);
//        Shippingpolicy ship = null;
//
//        System.out.println(shipPolicy.getResultCode());
//
//            ship = shipPolicy;
        Shippingpolicy shipPolicy = null;
        return shipPolicy;

//        Shippingpolicy shipPolicy = mapper.readValue(response.body().string().toString(), Shippingpolicy.class);
//        ResultShipData ship = shipPolicy.getData().stream()
//                .filter(d -> d.getShipPolicyNo() == policyno).findAny().get();
//        return ship;

    }

    // 브랜드..
    @GetMapping("getBrandAPI")
    public Brands getBrandAPI( @RequestHeader("apiKey") String apiKey, @RequestParam("brandName") String brandname)
            throws IOException, JsonParseException, JsonMappingException {

        String path = "/product/out/getBrand?" + "brandName=" + brandname;

        Response response = null;

        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder().url(Host.concat(path)).method("GET", null)
                .addHeader("apiKey", apiKey).build();

        response = client.newCall(request).execute();

        Brands brands = mapper.readValue(response.body().string().toString(), Brands.class);

        return brands;

    }

    // 메이커..
    @GetMapping("getMakerAPI")
    public Makers getMakerAPI( @RequestHeader("apiKey") String apiKey, @RequestParam("makerName") String makername)
            throws IOException, JsonParseException, JsonMappingException {

        String path = "/product/out/getMaker?" + "makerName=" + makername;

        Response response = null;

        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder().url(Host.concat(path)).method("GET", null)
                .addHeader("apiKey", apiKey).build();

        response = client.newCall(request).execute();

        Makers makers = mapper.readValue(response.body().string().toString(), Makers.class);

        return makers;

    }

    // 상품정보 고시조회..
    @GetMapping("getNoticeAPI")
    public Notice getNoticeAPI( @RequestHeader("apiKey") String apiKey)
            throws IOException, JsonParseException, JsonMappingException {

        String path = " /product/out/getNotice";

        Response response = null;

        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder().url(Host.concat(path)).method("GET", null)
                .addHeader("apiKey", apiKey).build();

        response = client.newCall(request).execute();

        Notice notice = mapper.readValue(response.body().string().toString(), Notice.class);

        return notice;
    }

        // 상품등록..
    @PostMapping("setProductAPI")
    public Request setProductAPI(@RequestHeader("apiKey") String apiKey, @RequestBody String json)
            throws IOException, JsonParseException, JsonMappingException {
//    // 상품등록..
//    @PostMapping("setProductAPI")
//    public ProductResult setProductAPI(@RequestHeader("apiKey") String apiKey, @RequestBody ProductData.WeMarketProductReg data)
//            throws IOException, JsonParseException, JsonMappingException {
        String path = "/product/in/setProduct";

        System.out.println(json);
//        ObjectMapper mapper = null;
//        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
//        String json = mapper.writeValueAsString(data);
        MediaType mediaType = MediaType.parse("application/json");
        okhttp3.RequestBody body = okhttp3.RequestBody.create(mediaType, json);

        Request request = new Request.Builder().url(Host.concat(path))
                .method("POST", body)
                .addHeader("apiKey", apiKey)
                .addHeader("application", "json;charset=UTF-8")
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();

        return request;
    }
}



