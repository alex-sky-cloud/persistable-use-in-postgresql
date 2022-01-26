package com.persistable.persistable.controller;

import com.persistable.persistable.service.ColumnService;
import com.persistable.persistable.service.dto.MeshDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("grid")
@RestController
public class GridController {

    private final ColumnService gridService;

    public GridController(ColumnService gridService) {
        this.gridService = gridService;
    }

// ToDo: implement getAll, create, update and delete

    @GetMapping("v1")
    public List<MeshDto> getGridList (){

        List<MeshDto> allGrid = gridService.getMeshAll();

        return allGrid;
    }


}