package org.example.stardew;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterDoa extends JpaRepository<Characters, Long> {
}