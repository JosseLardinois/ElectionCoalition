package com.example.ElectionCoalition.Repository;

import com.example.ElectionCoalition.Model.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Integer> {
}
