package com.example.respository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class ProcedureRepository {
    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    public ProcedureRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    private void init() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("myfirstprocedure")
                .withSchemaName("practise"); // Add schema name if needed
    }

    public int callProcedure(int a, int b) {
        Map<String, Object> result = simpleJdbcCall.execute(Map.of(
                "a", a,
                "b", b
        ));
        return (Integer) result.get("c");  // assuming 'c' is the OUT parameter name
    }
}
