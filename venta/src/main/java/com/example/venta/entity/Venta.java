package com.example.venta.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Venta {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer ventaId;
   private String ventaSerie;
   private String ventaNumero;
   private String ventaDescripcion;
   private String clienteId;

   @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
   @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinColumn(name = "venta_id")
   private List<VentaDetalle> detalle;
}