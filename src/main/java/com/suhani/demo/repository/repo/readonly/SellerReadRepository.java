package com.suhani.demo.repository.repo.readonly;

import com.suhani.demo.repository.model.Seller;
import com.suhani.demo.utils.ReadOnlyRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@ReadOnlyRepository
public interface SellerReadRepository extends JpaRepository<Seller, Integer> {

    Optional<Seller> findByAadharNumberOrPanNumberOrContactOrEmailOrGstin(String aadharNumber, String panNumber, Long contact, String email, String gstin);
}
