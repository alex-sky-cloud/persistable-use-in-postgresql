package com.persistable.persistable.controller;

import com.persistable.persistable.PersistableUseInPostgresqlApplicationTests;
import com.persistable.persistable.service.dto.MeshDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GridControllerTest extends PersistableUseInPostgresqlApplicationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void getGridList() {

        ResponseEntity<List<MeshDto>> response =
                testRestTemplate.exchange("/grid/v1", HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });

        List<MeshDto> body = response.getBody();
    }
}