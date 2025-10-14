package com.example.e_com.services;
import com.example.e_com.dtos.CategoryDTO;
import com.example.e_com.gateway.ICategoryGateway;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Primary
@Service("FakeStoreCategoryService")

public class FakeStoreCategoryService implements ICategoryService {
  private final ICategoryGateway iCategoryGateway;

  FakeStoreCategoryService(ICategoryGateway _iCategoryGateway){
      this.iCategoryGateway=_iCategoryGateway;
  }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return iCategoryGateway.getAllCategories();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO dto ) throws IOException {
        return null;
    }

    @Override
    public CategoryDTO getCategoryByName(String name) throws Exception {
        return null;
    }
}
