package org.example.stardew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterDao dao;


    @GetMapping
    public List<Characters> getAll() {
        return dao.findAll();
    }


    @PostMapping
    public Characters add(@RequestBody Characters c) {
        return dao.save(c);
    }


    @GetMapping("/{id}")
    public Characters getOne(@PathVariable Long id) {
        return dao.findById(id).orElse(null);
    }


    @PutMapping("/{id}")
    public Characters update(@PathVariable Long id, @RequestBody Characters c) {
        Characters character = dao.findById(id).orElse(null);
        if (character != null) {
            character.setName(c.getName());
            character.setGender(c.getGender());
            character.setBday(c.getBday());
            character.setColor(c.getColor());
            character.setHobby(c.getHobby());
            dao.save(character);
        }
        return character;
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        dao.deleteById(id);
    }
}
