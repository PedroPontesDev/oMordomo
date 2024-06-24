package com.devPontes.oMordomo.model.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_ponto")
public class Ponto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "horario_entrada")
    private LocalDateTime horarioEntrada;

    @Column(name = "horario_saida")
    private LocalDateTime horarioSaida;

    @ManyToOne(fetch = FetchType.LAZY)
    private BatedorDePonto batedorDePonto;

    public Ponto() {
    }

    public Ponto(Long id, LocalDateTime horarioEntrada, LocalDateTime horarioSaida, BatedorDePonto batedorDePonto) {
        this.id = id;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
        this.batedorDePonto = batedorDePonto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(LocalDateTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public LocalDateTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalDateTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public BatedorDePonto getBatedorDePonto() {
        return batedorDePonto;
    }

    public void setBatedorDePonto(BatedorDePonto batedorDePonto) {
        this.batedorDePonto = batedorDePonto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, horarioEntrada, horarioSaida, batedorDePonto);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ponto other = (Ponto) obj;
        return Objects.equals(id, other.id) && Objects.equals(horarioEntrada, other.horarioEntrada)
                && Objects.equals(horarioSaida, other.horarioSaida) && Objects.equals(batedorDePonto, other.batedorDePonto);
    }

    @Override
    public String toString() {
        return "Ponto [id=" + id + ", horarioEntrada=" + horarioEntrada + ", horarioSaida=" + horarioSaida + "]";
    }
}
