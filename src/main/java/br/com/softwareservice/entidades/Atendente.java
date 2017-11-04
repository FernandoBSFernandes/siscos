package br.com.softwareservice.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "Atendente")
@Table(name = "Atendente")
public class Atendente extends Funcionario{

}
