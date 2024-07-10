package com.devPontes.oMordomo.model.dtos;

import java.time.LocalDateTime;
import java.util.Objects;

import com.devPontes.oMordomo.model.enums.StatusMesa;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class MesaDTO {

    private Long id;
    private StatusMesa statusMesa;
    private Long comandaId;
    
    @JsonFormat(pattern = "yyyy/MM/dd'T'HH:mm:ss'Z'", timezone = "GMT", shape = Shape.STRING)
    private LocalDateTime horarioOcupacao;
  
    @JsonFormat(pattern = "yyyy/MM/dd'T'HH:mm:ss'Z'", timezone = "GMT", shape = Shape.STRING)
    private LocalDateTime horarioSaida;
    
    private Long totalDeHorasMesa;

    public MesaDTO(Long id, StatusMesa statusMesa, Long comandaId, LocalDateTime horarioOcupacao,
            LocalDateTime horarioSaida, Long totalDeHorasMesa) {
        this.id = id;
        this.statusMesa = statusMesa;
        this.comandaId = comandaId;
        this.horarioOcupacao = horarioOcupacao;
        this.horarioSaida = horarioSaida;
        this.totalDeHorasMesa = totalDeHorasMesa;
    }

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

    public Long getComandaId() {
        return comandaId;
    }

    public void setComandaId(Long comandaId) {
        this.comandaId = comandaId;
    }

    public LocalDateTime getHorarioOcupacao() {
        return horarioOcupacao;
    }

    public void setHorarioOcupacao(LocalDateTime horarioOcupacao) {
        this.horarioOcupacao = horarioOcupacao;
    }

    public LocalDateTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalDateTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public Long getTotalDeHorasMesa() {
        return totalDeHorasMesa;
    }

    public void setTotalDeHorasMesa(Long totalDeHorasMesa) {
        this.totalDeHorasMesa = totalDeHorasMesa;
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
        return "MesaDTO [id=" + id + ", statusMesa=" + statusMesa + ", comandaId=" + comandaId + ", horarioOcupacao="
                + horarioOcupacao + ", horarioSaida=" + horarioSaida + ", totalDeHorasMesa=" + totalDeHorasMesa + "]";
    }

}
