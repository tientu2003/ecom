package com.intern.ecom.repository.product;

import com.intern.ecom.entity.product.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, String> {
}