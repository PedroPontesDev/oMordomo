package com.devPontes.oMordomo.model.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ComandaDTO {

    private Long id;
    private Double subTotal;
    private Double total;
    private LocalDate diaPedido;
    private Long garcomComandaId;
    private Long clienteComandaId;
    private Long mesaId;
    private Integer[] notaAtendimento = {0, 1, 2, 3, 4, 5};

    private List<ItemDTO> items = new ArrayList<>();

    public ComandaDTO(Long id, Double subTotal, Double total, LocalDate diaPedido, Long garcomComandaId,
            Long clienteComandaId, Long mesaId, Integer[] notaAtendimento, List<ItemDTO> items) {
        this.id = id;
        this.subTotal = subTotal;
        this.total = total;
        this.diaPedido = diaPedido;
        this.garcomComandaId = garcomComandaId;
        this.clienteComandaId = clienteComandaId;
        this.mesaId = mesaId;
        this.notaAtendimento = notaAtendimento;
        this.items = items;
    }

    public ComandaDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDate getDiaPedido() {
        return diaPedido;
    }

    public void setDiaPedido(LocalDate diaPedido) {
        this.diaPedido = diaPedido;
    }

    public Long getGarcomComandaId() {
        return garcomComandaId;
    }

    public void setGarcomComandaId(Long garcomComandaId) {
        this.garcomComandaId = garcomComandaId;
    }

    public Long getClienteComandaId() {
        return clienteComandaId;
    }

    public void setClienteComandaId(Long clienteComandaId) {
        this.clienteComandaId = clienteComandaId;
    }

    public Long getMesaId() {
        return mesaId;
    }

    public void setMesaId(Long mesaId) {
        this.mesaId = mesaId;
    }

    public Integer[] getNotaAtendimento() {
        return notaAtendimento;
    }

    public void setNotaAtendimento(Integer[] notaAtendimento) {
        this.notaAtendimento = notaAtendimento;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ComandaDTO other = (ComandaDTO) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "ComandaDTO [id=" + id + ", subTotal=" + subTotal + ", total=" + total + ", diaPedido=" + diaPedido
                + ", garcomComandaId=" + garcomComandaId + ", clienteComandaId=" + clienteComandaId + ", mesaId="
                + mesaId + ", notaAtendimento=" + Arrays.toString(notaAtendimento) + ", items=" + items + "]";
    }

}
