package com.devPontes.oMordomo.model.dtos;

import java.time.LocalDateTime;
import java.util.Objects;

import com.devPontes.oMordomo.model.enums.StatusMesa;

public class MesaDTO {

    private Long id;
    private StatusMesa statusMesa;
    private LocalDateTime diaDaReserva;
    private Boolean estaReservada;
    private ComandaDTO comanda;

    public MesaDTO(Long id, StatusMesa statusMesa, LocalDateTime diaDaReserva, Boolean estaReservada, ComandaDTO comanda) {
        this.id = id;
        this.statusMesa = statusMesa;
        this.diaDaReserva = diaDaReserva;
        this.estaReservada = estaReservada;
        this.comanda = comanda;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusMesa getStatusMesa() {
        return statusMesa;
    }

    public void setStatusMesa(StatusMesa statusMesa) {
        this.statusMesa = statusMesa;
    }

    public LocalDateTime getDiaDaReserva() {
        return diaDaReserva;
    }

    public void setDiaDaReserva(LocalDateTime diaDaReserva) {
        this.diaDaReserva = diaDaReserva;
    }

    public Boolean getEstaReservada() {
        return estaReservada;
    }

    public void setEstaReservada(Boolean estaReservada) {
        this.estaReservada = estaReservada;
    }

    public ComandaDTO getComanda() {
        return comanda;
    }

    public void setComanda(ComandaDTO comanda) {
        this.comanda = comanda;
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
        MesaDTO other = (MesaDTO) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "MesaDTO [id=" + id + ", statusMesa=" + statusMesa + ", diaDaReserva=" + diaDaReserva + ", estaReservada=" + estaReservada + ", comanda=" + comanda + "]";
    }
}
