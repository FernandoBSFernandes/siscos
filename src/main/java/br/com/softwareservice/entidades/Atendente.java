package br.com.softwareservice.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("Atendente")
public class Atendente extends Funcionario {

}
