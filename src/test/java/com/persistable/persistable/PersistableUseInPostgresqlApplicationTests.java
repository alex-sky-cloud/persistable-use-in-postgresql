package com.persistable.persistable;

import com.persistable.persistable.domain.Mesh;
import com.persistable.persistable.domain.MeshColumn;
import com.persistable.persistable.service.dto.MeshDto;
import com.persistable.persistable.service.mapper.CycleAvoidingMappingContext;
import com.persistable.persistable.service.mapper.MeshMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ActiveProfiles("test-unit")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SqlConfig(encoding = "UTF-8")
public class PersistableUseInPostgresqlApplicationTests {

    @Test
    void contextLoads() {
    }


}
