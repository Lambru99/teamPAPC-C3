package it.cs.unicam.ids.c3.Corriere;

import com.sun.istack.NotNull;
import it.cs.unicam.ids.c3.chiamata.ControllerChiamata;

public class ControllerCorriere {
    private ControllerChiamata cChiamata;

    public void visuallizzaListaChiamate(){cChiamata.visualizzaChiamate();}
    public void scegliChiamata(long index){cChiamata.scegliChiamata(index);}
    public void cambiaDisponibilita(@NotNull Corriere corriere){corriere.setDisposizione();}


}
