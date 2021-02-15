package com.example.ElectionCoalition.Controller;

import com.example.ElectionCoalition.Model.Party;
import com.example.ElectionCoalition.Service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/parties")
public class PartyController {
    @Autowired
    PartyService partyService;

    @GetMapping("")
    public List<Party> list(){
        return partyService.listAllParties();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Party> get(@PathVariable Integer id){
        try{
            Party party = partyService.getParty(id);
            return new ResponseEntity<Party>(party, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Party>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody Party party){
        partyService.saveParty(party);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Party party, @PathVariable Integer id){
        try{
            Party existParty = partyService.getParty(id);
            party.setId(id);
            partyService.saveParty(party);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        partyService.deleteUser(id);
    }


}
