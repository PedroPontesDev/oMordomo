package com.devPontes.oMordomo.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devPontes.oMordomo.model.dtos.ComandaDTO;
import com.devPontes.oMordomo.model.entities.Comanda;
import com.devPontes.oMordomo.model.entities.Garcom;
import com.devPontes.oMordomo.model.entities.Mesa;
import com.devPontes.oMordomo.model.mapper.MyMapper;
import com.devPontes.oMordomo.repositories.ComandaRepository;
import com.devPontes.oMordomo.repositories.GarcomRepository;
import com.devPontes.oMordomo.repositories.ItemRepository;
import com.devPontes.oMordomo.repositories.MesaRepository;
import com.devPontes.oMordomo.services.ComandaServices;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComandaServicesImpl implements ComandaServices {
	
	@Autowired
	private ComandaRepository comandaRepository;
	
	@Autowired
	private GarcomRepository garcomRepository;
	
	@Autowired
	private MesaRepository mesaRepository;
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public ComandaDTO abrirComanda(ComandaDTO novaComanda, Long mesaId, Long garcomId) throws Exception { //Tempo de execução Algoritmo -> O(1)
		Comanda comanda = MyMapper.parseObject(novaComanda, Comanda.class);
		Mesa mesa = mesaRepository.findById(mesaId).orElseThrow(() -> new Exception("")); //O(1) Notation
		Garcom garcom = garcomRepository.findById(garcomId).orElseThrow(() -> new Exception("")); //O(1) Notation
		if(comanda != null) {
			comanda.setDiaPedido(LocalDate.now());
			comanda.setEstaFechada(false);
			comanda.setSubTotal(0D);
			comanda.setTotal(0D);
			comanda.setGarcomComanda(garcom);
			comanda.setMesa(mesa);
			comandaRepository.save(comanda); //Tempo de execução (1) para essa função
			return MyMapper.parseObject(comanda, ComandaDTO.class); // Retorna a comanda criada (1)
		} throw new Exception("Não foi possivel registar uma nova comanda");
	
	}

	
	@Override
	public ComandaDTO fecharComanda(Long comandaId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
    public void adicionarItemNaComanda(Long itemId, Long comandaId) throws Exception { 		//O(1) Notation
        var item = itemRepository.findById(itemId).orElseThrow(() -> new Exception("Item não encontrado")); //O(1)
        var comanda = comandaRepository.findById(comandaId).orElseThrow(() -> new Exception("Comanda não encontrada")); //O(1)
        if (comanda.isEstaFechada()) {
            throw new Exception("Comanda está fechada, não foi possível adicionar o item!");
        }
        comanda.getItems().add(item);
        comandaRepository.save(comanda);	//O(1)
    }
	


	@Override
	public void removerItemDaComanda(Long comandaId) throws Exception { //O(n)
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adicionarMultiplosItemsComanda(List<Long> itemsId, Long comandaId) throws Exception { //O(n) Notation
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double calcularSubTotal(Long comandaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calcularTotal(Long comandaId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
	
	