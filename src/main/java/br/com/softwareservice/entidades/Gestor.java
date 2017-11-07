package br.com.softwareservice.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("Gestor")
public class Gestor extends Funcionario {

}
