package org.example.stardew;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterDao extends JpaRepository<Characters, Long> {
}