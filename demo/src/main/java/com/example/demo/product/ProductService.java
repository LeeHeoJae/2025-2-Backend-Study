package com.example.demo.product;

import com.example.demo.member.MemberRepository;
import com.example.demo.product.dto.ProductCreateRequest;
import com.example.demo.product.dto.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Long createProduct(ProductCreateRequest request) {
        Product existingProduct = productRepository.findByLoginId();
        if(existingProduct != null){
            throw new RuntimeException("이미 존재하는 프로덕트 아이디입니다.");
        }
        Product product = new Product(
                request.getId(),
                request.getSpec()
        );
        productRepository.save(product);
        return product.getId();
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(Long id){
        Product product = productRepository.findById(id);
        if(product == null){
            throw new RuntimeException("프로덕트를 찾을 수 없습니다.");
        }
        return product;
    }

    public void updateProduct(Long id, ProductUpdateRequest request){
        Product product = productRepository.findById(id);
        if(product == null){
            throw new RuntimeException("프로덕트를 찾을 수 없습니다.");
        }
        product.updateInfo(request.getSpec);
    }
    public void deleteProduct(Long id){
        Product product = productRepository.findById(id);
        if(product == null){
            throw new RuntimeException("프로덕트를 찾을 수 없습니다.");
        }
        productRepository.deleteById(id);
    }
}
