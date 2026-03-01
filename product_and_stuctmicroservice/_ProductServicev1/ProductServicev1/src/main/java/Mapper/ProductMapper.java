package Mapper;

import com.example.ProductServicev1.Dtos.ProductRequestDto;
import com.example.ProductServicev1.Dtos.ProductResponseDto;
import com.example.ProductServicev1.Model.Product;

public class ProductMapper {
    public ProductResponseDto toDto(Product product)
    {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setProductName(product.getProductName());
        productResponseDto.setProductNumber(product.getProductNumber());
        productResponseDto.setNumberOnStock(product.getNumberOnStock());

        return productResponseDto;
    }
}
