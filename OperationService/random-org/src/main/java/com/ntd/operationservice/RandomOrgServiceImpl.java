package com.ntd.operationservice;

import com.ntd.operationservice.dto.JsonRpcRequest;
import com.ntd.operationservice.dto.JsonRpcResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class RandomOrgServiceImpl implements RandomOrgService {
    private final RestTemplate restTemplate;
    protected final Log logger = LogFactory.getLog(this.getClass());

    public RandomOrgServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getRandomString() throws Exception {
        try {
            var uri = UriComponentsBuilder.fromUriString("https://api.random.org/json-rpc/4/invoke");

            return restTemplate.exchange(
                    uri.toUriString(),
                    HttpMethod.POST,
                    new HttpEntity<>(new JsonRpcRequest(), new HttpHeaders()),
                    JsonRpcResponse.class).getBody().getResult().getRandom().getData().get(0);
        } catch( Exception e) {
            logger.error("RecordServiceImpl.save, message: " + e.getMessage(), e);
            throw e;
        }
    }
}


