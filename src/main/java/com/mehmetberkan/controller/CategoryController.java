package com.mehmetberkan.controller;

import com.mehmetberkan.dto.request.AddCategoryRequestDto;
import com.mehmetberkan.dto.response.BaseResponse;
import com.mehmetberkan.entity.Category;
import com.mehmetberkan.service.CategoryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mehmetberkan.config.RestApis.*;

@RestController
@RequestMapping(CATEGORY)
@RequiredArgsConstructor
@CrossOrigin("*")
@SecurityRequirement(name = "bearerAuth")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping(ADD_CATEGORY)
    public ResponseEntity<BaseResponse<Category>> addCategory(@RequestBody AddCategoryRequestDto dto) {
        return ResponseEntity.ok(BaseResponse.<Category>builder()
                        .code(200)
                        .message("Success")
                        .data(categoryService.addCategoryy(dto))
                .build());
    }
    @GetMapping(GET_ALL_CATEGORY)
    public ResponseEntity<BaseResponse<List<Category>>> getCategory(){
        return ResponseEntity.ok(BaseResponse.<List<Category>>builder()
                        .code(200)
                        .message("List Success")
                        .data(categoryService.getAllCategory())
                .build());
    }
    @DeleteMapping(DELETE_CATEGORY)
    public ResponseEntity<BaseResponse<Boolean>> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategoryy(id);
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                        .code(200)
                        .message("Delete Success")
                        .data(true)
                .build());
    }


}
