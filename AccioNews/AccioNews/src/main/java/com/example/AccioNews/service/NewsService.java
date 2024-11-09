package com.example.AccioNews.service;

import com.example.AccioNews.dto.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    @Autowired
    RestTemplate restTemplate;

    private static final String baseUrl = "https://newsapi.org/v2/top-headlines";

    public NewsResponse getNewsByCountry(String country, String apiKey) {
        String url = baseUrl + "?country="+country+"&apiKey=" + apiKey;
        return restTemplate.getForObject(url, NewsResponse.class);
    }

    // H.W -> Build some other app using some free API, explore .exchange() method of RestTemplate
}
