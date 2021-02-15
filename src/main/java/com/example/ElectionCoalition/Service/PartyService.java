package com.example.ElectionCoalition.Service;

import com.example.ElectionCoalition.Model.Party;
import com.example.ElectionCoalition.Repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class PartyService {
    @Autowired
    private PartyRepository partyRepository;
    public List<Party> listAllParties() {
        return partyRepository.findAll();
    }

    public void saveParty(Party party) {
        partyRepository.save(party);
    }

    public Party getParty(Integer id) {
        return partyRepository.findById(id).get();
    }

    public void deleteUser(Integer id) {
        partyRepository.deleteById(id);
    }
}