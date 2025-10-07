package com.example.e_com.services;
import com.example.e_com.dtos.CategoryDTO;
import com.example.e_com.gateway.ICategoryGateway;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService {
  private final ICategoryGateway iCategoryGateway;

  FakeStoreCategoryService(ICategoryGateway _iCategoryGateway){
      this.iCategoryGateway=_iCategoryGateway;
  }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return iCategoryGateway.getAllCategories();
    }
}
