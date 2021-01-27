package it.cs.unicam.ids.c3.entity;


/**
 * Gli ordini possono avere diversi stati e ogni attore ha il compito cambiare stato dell'ordine in un preciso momento facente parte dell'intera durata
 * del contratto, che inizierà con un ordine "eseguito" e si concluderà solo nel momento in cui l'ordine sarà "completato".
 * Il contratto stipulato tra il cliente e il commerciante per essere completato non dovrà per forza passare per ogni stato intermedio
 */
public enum StatoOrdine {
    ESEGUITO,RITIRO_NEGOZIO,IN_TRASPORTO,CONSEGNATO,COMPLETATO;
}
